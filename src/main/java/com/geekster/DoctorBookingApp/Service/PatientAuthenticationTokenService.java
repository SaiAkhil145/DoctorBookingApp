package com.geekster.DoctorBookingApp.Service;

import com.geekster.DoctorBookingApp.Model.PatientAuthenticationToken;
import com.geekster.DoctorBookingApp.Model.dto.AuthenticationInputdto;
import com.geekster.DoctorBookingApp.Repo.IPatientAuthenticationTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientAuthenticationTokenService {
    @Autowired
    IPatientAuthenticationTokenRepo tokenRepo;

    public void createToken(PatientAuthenticationToken token) {
        tokenRepo.save(token);
    }

    public void deleteToken(String tokenValue) {
       PatientAuthenticationToken token = tokenRepo.findFirstByTokenValue(tokenValue);
       tokenRepo.delete(token);

    }

    public boolean Authenticate(AuthenticationInputdto authInfo) {
        String email = authInfo.getEmail();
        String tokenValue = authInfo.getTokenValue();

        //return tokenRepo.findFirstByTokenValue(tokenValue).getPatient().getPatientEmail().equals(email);

        PatientAuthenticationToken token = tokenRepo.findFirstByTokenValue(tokenValue);
        if(token!=null){
           return token.getPatient().getPatientEmail().equals(email);
        }else{
            return false;
        }

    }


}
