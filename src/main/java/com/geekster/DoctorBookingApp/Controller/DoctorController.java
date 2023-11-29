package com.geekster.DoctorBookingApp.Controller;

import com.geekster.DoctorBookingApp.Model.Doctor;
import com.geekster.DoctorBookingApp.Model.dto.AuthenticationInputdto;
import com.geekster.DoctorBookingApp.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @GetMapping("doctors")
    public List<Doctor> getAllDoctors(@RequestBody AuthenticationInputdto authInfo){
        return doctorService.getAllDoctors(authInfo);
    }
    @GetMapping("doctor/{id}/id")
    public Doctor findDoctorById(@PathVariable Long id){
        return doctorService.findDoctorById(id);
    }

}
