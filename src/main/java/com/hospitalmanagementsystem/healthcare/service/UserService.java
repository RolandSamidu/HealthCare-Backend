package com.hospitalmanagementsystem.healthcare.service;

import com.hospitalmanagementsystem.healthcare.model.RegisterRequest;
import com.hospitalmanagementsystem.healthcare.model.Role;
import com.hospitalmanagementsystem.healthcare.model.User;
import com.hospitalmanagementsystem.healthcare.repository.RoleRepository;
import com.hospitalmanagementsystem.healthcare.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User registerUser(RegisterRequest request) {
        // Encrypt password before saving
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // Assign role to user
        Optional<Role> role = roleRepository.findByName(request.getRoleName());
        if (role.isPresent()) {
            user.setRole(role.get());
        } else {
            throw new RuntimeException("Role not found: " + request.getRoleName());
        }

        return userRepository.save(user);
    }
}
