package com.employee.EmployeeData.serviceImpl;

import com.employee.EmployeeData.PayLoad.TaxDto;
import com.employee.EmployeeData.Repository.EmployeeRepository;
import com.employee.EmployeeData.Repository.TaxDetailsRepository;
import com.employee.EmployeeData.entity.Employee;
import com.employee.EmployeeData.entity.TaxDetails;
import com.employee.EmployeeData.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    private TaxDto taxDto=new TaxDto();
    @Autowired
    private TaxDetailsRepository taxRepo;

    @Override
    public Employee createEmployee(Employee employee) {

        Employee save = employeeRepository.save(employee);
        return save;
    }

    @Override
    public TaxDto findTaxofEmployee(Long employeeId) {
        Optional<Employee> findById = employeeRepository.findById(employeeId);

        if (findById.isPresent()) {
           TaxDetails empTaxDetails = new TaxDetails();

            Employee employee = findById.get();
            empTaxDetails.setEmployeeId(employee.getEmployeeId());

            LocalDate d = LocalDate.now();
            int months = Period.between(employee.getDoj(),d).getMonths();
            empTaxDetails.setYearlysalary(months*employee.getSalary());
            double yearlySalary = empTaxDetails.getYearlysalary();
            if (yearlySalary < 250000) {
                empTaxDetails.setTaxAmount((yearlySalary*1.0)-yearlySalary);
            }
            if (yearlySalary >= 250000 && yearlySalary <= 500000) {
                empTaxDetails.setTaxAmount((yearlySalary*1.05)-yearlySalary);
            }
            if (yearlySalary >= 500000 && yearlySalary <= 1000000) {
                empTaxDetails.setTaxAmount((yearlySalary*1.10)-yearlySalary);
            }
            if (yearlySalary > 1000000) {
                empTaxDetails.setTaxAmount((yearlySalary*1.20)-yearlySalary);
            }


            taxDto.setEmployeeId(empTaxDetails.getEmployeeId());
            taxDto.setFirstName(employee.getFirstName());
            taxDto.setLastName(employee.getLastName());
            taxDto.setYearlySalary(empTaxDetails.getYearlysalary());
            taxDto.setTaxAmount(empTaxDetails.getTaxAmount());
            taxRepo.save(empTaxDetails);
            return taxDto;
        }else {
            throw new RuntimeException("Invalid Employee ID");
        }
    }
}
