package com.employee.EmployeeData.Repository;

import com.employee.EmployeeData.entity.TaxDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxDetailsRepository extends JpaRepository<TaxDetails, Integer> {
}
