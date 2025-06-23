package com.employee.employeeManagementSystem.core.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "employees_table")
public class Employee {
    @Id
    @GeneratedValue(generator = "increment")
    private Long Id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private int age;
}
