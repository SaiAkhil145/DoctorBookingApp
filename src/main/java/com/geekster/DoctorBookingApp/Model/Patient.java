package com.geekster.DoctorBookingApp.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope=Appointment.class,property = "patientId")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String patientName;
    private String patientEmail;
    private String patientPassword;
    @Enumerated(value = EnumType.STRING)
    private Gender patientGender;
    @Enumerated(value=EnumType.STRING)
    private BloodGroup bloodGroup;
    private String patientContact;
    private LocalDateTime patientDOB;
    @OneToMany(mappedBy = "patient")
    List<Appointment> appointments;

}
