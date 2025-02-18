package com.hospitalmanagementsystem.healthcare.controller;

import com.hospitalmanagementsystem.healthcare.model.Role;
import com.hospitalmanagementsystem.healthcare.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/{name}")
    public Optional<Role> getRoleByName(String name){
        return roleService.getRoleByName(name);
    }
}
