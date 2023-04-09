package com.employee.EmployeeData.controller;

import com.employee.EmployeeData.PayLoad.TaxDto;
import com.employee.EmployeeData.entity.Employee;
import com.employee.EmployeeData.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/employeeDetails")
public class employeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<Employee> createNewEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/tax/{employeeID}")
    public ResponseEntity<TaxDto> findTaxUsingEmployeeId(@PathVariable("employeeID") Long employeeID) {
        return new ResponseEntity<TaxDto>(employeeService.findTaxofEmployee(employeeID), HttpStatus.OK);
    }

}
