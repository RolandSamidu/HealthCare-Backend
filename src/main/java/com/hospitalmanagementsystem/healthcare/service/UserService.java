package com.hospitalmanagementsystem.healthcare.service;

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
    @Autowired
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User registerUser(User user, String roleName) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Optional<Role> role = roleRepository.findByName(roleName);
        role.ifPresent(r -> user.setRoles(Set.of(r)));
        return userRepository.save(user);
    }
}
