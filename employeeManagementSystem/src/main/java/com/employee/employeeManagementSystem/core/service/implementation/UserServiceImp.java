package com.employee.employeeManagementSystem.core.service.implementation;

import com.mouhcine.SpringBootAPiEmployeeManagement.core.entity.User;
import com.mouhcine.SpringBootAPiEmployeeManagement.core.config.JwtService;
import com.mouhcine.SpringBootAPiEmployeeManagement.core.dao.IUserDao;
import com.mouhcine.SpringBootAPiEmployeeManagement.core.model.AuthRequest;
import com.mouhcine.SpringBootAPiEmployeeManagement.core.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    @Override
    public Optional<User> getUserById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public String save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userDao.save(user);
        AuthRequest authRequest = new AuthRequest(savedUser.getUsername(),savedUser.getPassword(),savedUser.getRole());
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
//        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername(),savedUser.getRole());
//        } else {
//            throw new UsernameNotFoundException("invalid user request !");
//        }
//        return login(authRequest);
    }

    @Override
    public String login(AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername(), authRequest.getRole());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }
}
