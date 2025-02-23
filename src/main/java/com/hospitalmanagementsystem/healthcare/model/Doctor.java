package com.hospitalmanagementsystem.healthcare.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    private Long doctorID;
    private String name;
    private String specialization;
    private String phone;
    private String Email;
    private String department;
    
}
