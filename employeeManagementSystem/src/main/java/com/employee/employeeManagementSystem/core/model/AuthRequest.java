package com.employee.employeeManagementSystem.core.model;

import com.mouhcine.SpringBootAPiEmployeeManagement.core.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

    private String username;
    private String password;


    private Role role =Role.USER;

}
