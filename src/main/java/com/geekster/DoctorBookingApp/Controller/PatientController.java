package com.geekster.DoctorBookingApp.Controller;

import com.geekster.DoctorBookingApp.Model.*;
import com.geekster.DoctorBookingApp.Model.dto.AuthenticationInputdto;
import com.geekster.DoctorBookingApp.Model.dto.ScheduleAppointmentDTO;
import com.geekster.DoctorBookingApp.Model.dto.SignInInput;
import com.geekster.DoctorBookingApp.Service.AppointmentService;
import com.geekster.DoctorBookingApp.Service.DoctorService;
import com.geekster.DoctorBookingApp.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
public class PatientController {
    @Autowired
    PatientService patientService;

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    DoctorService doctorService;


    //SIGN-UP
    @PostMapping("patient/signUp")
    public String patientSignUp(@RequestBody Patient patient) throws NoSuchAlgorithmException {
        return patientService.patientSignUp(patient);
    }
    @PostMapping("patient/signIn")
    public String patientSignIn(@RequestBody SignInInput signInInput){
        return patientService.patientSignIn(signInInput);
    }
    @DeleteMapping("patient/signOut")
    public String patientSignOut(@RequestBody AuthenticationInputdto authInfo){
        return patientService.patientSignOut(authInfo);
    }

    @PostMapping("patient/appointment/schedule")
    public String scheduleAppointment(@RequestBody ScheduleAppointmentDTO scheduleAppointmentDTO){
        return appointmentService.scheduleAppointment(scheduleAppointmentDTO.getAuthInfo(),scheduleAppointmentDTO.getAppointment());
    }
    @DeleteMapping("patient/appointment/{id}/id/cancel")
    public String cancelAppointment(@RequestBody  AuthenticationInputdto authenticationInputdto,@PathVariable Long id){
        return appointmentService.cancelAppointment(authenticationInputdto,id);
    }

}
