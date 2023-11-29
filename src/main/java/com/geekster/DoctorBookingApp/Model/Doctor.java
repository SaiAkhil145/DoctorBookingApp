package com.geekster.DoctorBookingApp.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = Doctor.class,property = "doctorId")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;
    private String doctorName;
    private double doctorFee;
    @Enumerated(value = EnumType.STRING)
    private Specialization doctorSpecialization;
    @Enumerated(value = EnumType.STRING)
    private Qualification doctorQualification;
    private String doctorContact;
    @OneToMany(mappedBy = "doctor")
    List<Appointment> appointments;
}
