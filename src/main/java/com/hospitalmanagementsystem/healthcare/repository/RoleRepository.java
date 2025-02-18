package com.hospitalmanagementsystem.healthcare.repository;

import com.hospitalmanagementsystem.healthcare.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
