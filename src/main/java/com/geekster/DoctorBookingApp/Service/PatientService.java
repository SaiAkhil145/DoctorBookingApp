package com.geekster.DoctorBookingApp.Service;

import com.geekster.DoctorBookingApp.Model.Appointment;
import com.geekster.DoctorBookingApp.Model.Patient;
import com.geekster.DoctorBookingApp.Model.PatientAuthenticationToken;
import com.geekster.DoctorBookingApp.Model.dto.AuthenticationInputdto;
import com.geekster.DoctorBookingApp.Model.dto.ScheduleAppointmentDTO;
import com.geekster.DoctorBookingApp.Model.dto.SignInInput;
import com.geekster.DoctorBookingApp.Repo.IPatientAuthenticationTokenRepo;
import com.geekster.DoctorBookingApp.Repo.IPatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    IPatientRepo patientRepo;
    @Autowired
    PatientAuthenticationTokenService tokenService;
    //signUp
    public String patientSignUp(Patient patient) throws NoSuchAlgorithmException {
        //check if email is present or not : if present try login instead signup
        String patientEmail = patient.getPatientEmail();
        //find whether the email already existing or not;
        Patient existingPatient = patientRepo.findFirstByPatientEmail(patientEmail);

        if (existingPatient != null) {
            return "email already in use ";
        }

        String signUpPassword = patient.getPatientPassword();
        try {
            String encryptedPassword = PasswordEncrypter.encrypt(signUpPassword);

            patient.setPatientPassword(encryptedPassword);
            patientRepo.save(patient);
            return "Registered successfully";
        } catch (Exception e) {
            return "internal server error while saving the password ! try again later!!!!";
        }

    }
    //sign-in
    public String patientSignIn(SignInInput signInInput) {
        //check if the email present in tables or not
        //sign in only if the email present in the table
        //password should be matched
        String patientEmail = signInInput.getUserEmail();
        Patient existingPatient = patientRepo.findFirstByPatientEmail(patientEmail);
        if(existingPatient==null){
            return "patient not found. please sign up first";
        }
        String patientPassword = signInInput.getPassword();
        try{
            String encryptedPassword = PasswordEncrypter.encrypt(patientPassword);
            if(existingPatient.getPatientPassword().equals(encryptedPassword)){
                PatientAuthenticationToken token = new PatientAuthenticationToken(existingPatient);
                   tokenService.createToken(token);

                return token.getTokenValue();

            }else{
                return "Not a valid email . sign up first !!!!";
            }

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }


    //signout
    public String patientSignOut(AuthenticationInputdto authInfo) {

        //Authentication token should get deleted.
        if(tokenService.Authenticate(authInfo)) {
            String tokenValue = authInfo.getTokenValue();
            tokenService.deleteToken(tokenValue);
            return "Sign Out Successfully!!!";
        }else{
            return "Un Authenticated Access!!!";
        }
    }


    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }



}












