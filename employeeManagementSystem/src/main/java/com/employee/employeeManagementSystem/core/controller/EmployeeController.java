package com.employee.employeeManagementSystem.core.controller;

import com.mouhcine.SpringBootAPiEmployeeManagement.core.entity.Employee;
import com.mouhcine.SpringBootAPiEmployeeManagement.core.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;


    @GetMapping("employees")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployee(@PathVariable("id") Long id){
        return employeeService.getEmployeeById(id).get();
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }
    @PutMapping("employees/{id}")
    public Employee updateEmployee(@RequestBody Employee employee,@PathVariable long id){
        Employee emp=employeeService.getEmployeeById(id).get();
        emp.setAge(employee.getAge());
        emp.setEmail(employee.getEmail());
        emp.setFullName(employee.getFullName());
        emp.setPhoneNumber(employee.getPhoneNumber());
        return employeeService.update(emp);
    }
    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        employeeService.delete(id);
        return "Delete successFully";
    }
}
