package com.employee.employeeManagementSystem.core.dao;

import com.mouhcine.SpringBootAPiEmployeeManagement.core.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IEmployeeDao extends JpaRepository<Employee,Long> {
    public Optional<Employee> findById(Long id);

}
