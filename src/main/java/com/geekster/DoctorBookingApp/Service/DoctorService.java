package com.geekster.DoctorBookingApp.Service;

import com.geekster.DoctorBookingApp.Model.Doctor;
import com.geekster.DoctorBookingApp.Model.Patient;
import com.geekster.DoctorBookingApp.Model.Qualification;
import com.geekster.DoctorBookingApp.Model.Specialization;
import com.geekster.DoctorBookingApp.Model.dto.AuthenticationInputdto;
import com.geekster.DoctorBookingApp.Repo.IDoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    @Autowired
    IDoctorRepo doctorRepo;
    @Autowired
    PatientService patientService;
    @Autowired
    PatientAuthenticationTokenService tokenService;

    public List<Doctor> getAllDoctors(AuthenticationInputdto authInfo) {

        if(tokenService.Authenticate(authInfo)) {
            return (List<Doctor>) doctorRepo.findAll();
        }else{
            return null;
        }
    }

    public String addDoctor(Doctor doctor) {

        Long docId = doctor.getDoctorId();
        if(docId!=null && doctorRepo.existsById(docId)){
             return "doctor already exists!!";
        }
        doctor.setAppointments(null);
        doctorRepo.save(doctor);

        return "doctor added";
    }

    public Doctor findDoctorById(Long id) {
        return doctorRepo.findById(id).orElseThrow();
    }



}
