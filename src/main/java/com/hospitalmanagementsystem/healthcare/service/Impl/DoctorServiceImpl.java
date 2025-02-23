package com.hospitalmanagementsystem.healthcare.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalmanagementsystem.healthcare.model.Doctor;
import com.hospitalmanagementsystem.healthcare.repository.DoctorRepository;
import com.hospitalmanagementsystem.healthcare.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> getDoctorByID(Long id) {
        return doctorRepository.findByDoctorID(id);
    }

    @Override
    public Optional<Doctor> getDoctorByName(String name) {
        return doctorRepository.findByName(name);
    }

    @Override
    public Optional<Doctor> getDoctorBySpecialization(String specialization) {
        return doctorRepository.findBySpecialization(specialization);
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor updateDoctor(Long doctorID, Doctor doctor) {
        if(doctorRepository.existsById(doctorID)){
            doctor.setDoctorID(doctorID);
            return doctorRepository.save(doctor);
        }
        return null;
                
    }

    @Override
    public void deleteDoctor(Long doctorID) {
        doctorRepository.deleteById(doctorID);
    }
    
}
