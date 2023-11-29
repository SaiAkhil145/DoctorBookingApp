package com.geekster.DoctorBookingApp.Repo;

import com.geekster.DoctorBookingApp.Model.PatientAuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientAuthenticationTokenRepo extends JpaRepository<PatientAuthenticationToken,Integer> {


    PatientAuthenticationToken findFirstByTokenValue(String tokenValue);
}
