package com.geekster.DoctorBookingApp.Controller;

import com.geekster.DoctorBookingApp.Service.PatientAuthenticationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientAuthenticationTokenController {
    @Autowired
    PatientAuthenticationTokenService tokenService;
}
