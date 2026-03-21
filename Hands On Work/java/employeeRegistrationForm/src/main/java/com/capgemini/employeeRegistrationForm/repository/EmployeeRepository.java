package com.capgemini.employeeRegistrationForm.repository;

import com.capgemini.employeeRegistrationForm.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByUsername(String username);
}