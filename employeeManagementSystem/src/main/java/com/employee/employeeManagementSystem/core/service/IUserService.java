package com.employee.employeeManagementSystem.core.service;

import com.mouhcine.SpringBootAPiEmployeeManagement.core.entity.User;
import com.mouhcine.SpringBootAPiEmployeeManagement.core.model.AuthRequest;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public Optional<User> getUserById(Long id);
    public String save(User user);

    public String login(AuthRequest authRequest);

    public List<User> getAll();
}
