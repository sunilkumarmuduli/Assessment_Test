package com.employee.EmployeeData.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TaxDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taxId;

    @OneToOne
    private Employee employee;

    private long employeeId;
    private Double yearlysalary;
    private Double taxAmount;
}
