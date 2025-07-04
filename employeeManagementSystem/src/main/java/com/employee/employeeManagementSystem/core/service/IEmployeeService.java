package com.employee.employeeManagementSystem.core.service;

import com.mouhcine.SpringBootAPiEmployeeManagement.core.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    public Employee save(Employee employee);
    public Employee update(Employee employee);
    public List<Employee> getEmployees();
    public Optional<Employee> getEmployeeById(Long id);
    public void delete(Long id);
}
