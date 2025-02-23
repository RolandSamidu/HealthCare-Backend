package com.hospitalmanagementsystem.healthcare.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.hospitalmanagementsystem.healthcare.model.Doctor;
import com.hospitalmanagementsystem.healthcare.service.DoctorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{doctorID}")
    public Optional<Doctor> getDoctorByID(@PathVariable Long doctorID){
        return doctorService.getDoctorByID(doctorID);
    }

    @GetMapping("/{name}")
    public Optional<Doctor> getDoctorByName(@PathVariable String name) {
        return doctorService.getDoctorByName(name);
    }

    @GetMapping("/{specialization}")
    public Optional<Doctor> getDoctorBySpecialization(@PathVariable String specialization) {
        return doctorService.getDoctorBySpecialization(specialization);
    }
    
    @PostMapping
    public Doctor saveDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @PutMapping("/{doctorID}")
    public Doctor updateDoctor(@PathVariable Long doctorID, @RequestBody Doctor doctor) {
        return doctorService.updateDoctor(doctorID, doctor);
    }
    
    @DeleteMapping("/{doctorID}")
    public void deleteDoctor(@PathVariable Long doctorID){
        doctorService.deleteDoctor(doctorID);
    }
}
