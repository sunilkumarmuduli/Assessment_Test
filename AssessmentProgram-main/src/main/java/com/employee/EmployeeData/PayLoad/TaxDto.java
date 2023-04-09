package com.employee.EmployeeData.PayLoad;

import lombok.Data;

@Data
public class TaxDto {
    private long employeeId;
    private String firstName;
    private String lastName;
    private double yearlySalary;
    private double taxAmount;
}
