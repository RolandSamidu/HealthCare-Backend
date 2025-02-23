package com.hospitalmanagementsystem.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hospitalmanagementsystem.healthcare.model.Doctor;
import java.util.*;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByDoctorID(Long id);
    Optional<Doctor> findByName(String name);
    Optional<Doctor> findBySpecialization(String specialization);
}
