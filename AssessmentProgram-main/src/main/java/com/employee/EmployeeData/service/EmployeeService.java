package com.employee.EmployeeData.service;

import com.employee.EmployeeData.PayLoad.TaxDto;
import com.employee.EmployeeData.entity.Employee;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    TaxDto findTaxofEmployee(Long employeeId);

}
