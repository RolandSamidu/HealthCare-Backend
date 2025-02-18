package com.hospitalmanagementsystem.healthcare.controller;

import com.hospitalmanagementsystem.healthcare.model.User;
import com.hospitalmanagementsystem.healthcare.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        Optional<User> existingUser = userService.getUserById(user.getId());
        if (existingUser.isPresent() && existingUser.get().getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user, @RequestParam String roleName) {
        User registeredUser = userService.registerUser(user, roleName);
        return ResponseEntity.ok(registeredUser);
    }
}
