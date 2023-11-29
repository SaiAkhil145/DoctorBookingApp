package com.geekster.DoctorBookingApp.Controller;

import com.geekster.DoctorBookingApp.Model.Doctor;
import com.geekster.DoctorBookingApp.Model.Patient;
import com.geekster.DoctorBookingApp.Model.dto.AuthenticationInputdto;
import com.geekster.DoctorBookingApp.Service.DoctorService;
import com.geekster.DoctorBookingApp.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    DoctorService doctorService;
    @Autowired
    PatientService patientService;

    @PostMapping("doctor")
    public String addDoctor(@RequestBody Doctor doctor){
        return doctorService.addDoctor(doctor);
    }

    @GetMapping("patients")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }
}
