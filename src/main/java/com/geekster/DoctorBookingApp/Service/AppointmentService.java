package com.geekster.DoctorBookingApp.Service;

import com.geekster.DoctorBookingApp.Model.Appointment;
import com.geekster.DoctorBookingApp.Model.Patient;
import com.geekster.DoctorBookingApp.Model.dto.AuthenticationInputdto;
import com.geekster.DoctorBookingApp.Model.dto.ScheduleAppointmentDTO;
import com.geekster.DoctorBookingApp.Repo.IAppointmentRepo;
import com.geekster.DoctorBookingApp.Repo.IDoctorRepo;
import com.geekster.DoctorBookingApp.Repo.IPatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AppointmentService {
     @Autowired
    IAppointmentRepo appointmentRepo;

    @Autowired
    PatientAuthenticationTokenService tokenService;
    @Autowired
    IPatientRepo patientRepo;

    @Autowired
    IDoctorRepo doctorRepo;


    public String scheduleAppointment(AuthenticationInputdto authInfo, Appointment appointment) {
        if (tokenService.Authenticate(authInfo)) {

            //find the patient
            String email = authInfo.getEmail();
            Patient existingEmail = patientRepo.findFirstByPatientEmail(email);

            //find the doctor

            Long docId = appointment.getDoctor().getDoctorId();
            boolean isDoctorValid = doctorRepo.existsById(docId);


            if (isDoctorValid) {
                appointment.setAppointmentCreationTime(LocalDateTime.now());
                appointmentRepo.save(appointment);
                return "appointment booked at "+appointment.getAppointmentScheduleTime()+"with doctor"+appointment.getDoctor().getDoctorName();
            }

        } else {
            return "Doctor does not exist,could not book appointment";
        }


     return "Unauthenticated access!!";

    }

    public String cancelAppointment(AuthenticationInputdto authInfo, Long id) {
        if(tokenService.Authenticate(authInfo)) {

            String email = authInfo.getEmail();

            Patient patient = patientRepo.findFirstByPatientEmail(email);

            Appointment existingAppointment =  appointmentRepo.findById(id).orElseThrow();

            if(existingAppointment.getPatient().equals(patient))
            {
                appointmentRepo.deleteById(id);
                return "appointment with " + existingAppointment.getDoctor().getDoctorName() + " has been cancelled!!";

            }
            else
            {
                return "UnAuthorized cancel appointment!!";
            }

        }
        else {
            return "Un Authenticated access!!!";
        }
    }

}
