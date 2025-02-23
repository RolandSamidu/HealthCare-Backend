package com.hospitalmanagementsystem.healthcare.service;

import java.util.*;
import com.hospitalmanagementsystem.healthcare.model.Doctor;

public interface DoctorService {
    List<Doctor> getAllDoctors();
    Optional<Doctor> getDoctorByID(Long id);
    Optional<Doctor> getDoctorByName(String name);
    Optional<Doctor> getDoctorBySpecialization(String specialization);
    Doctor saveDoctor(Doctor doctor);
    Doctor updateDoctor(Long id, Doctor doctor);
    void deleteDoctor(Long id);
}
