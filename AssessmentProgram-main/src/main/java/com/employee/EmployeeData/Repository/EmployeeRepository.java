package com.employee.EmployeeData.Repository;

import com.employee.EmployeeData.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
