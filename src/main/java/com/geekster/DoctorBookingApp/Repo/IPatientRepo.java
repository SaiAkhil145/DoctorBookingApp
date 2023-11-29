package com.geekster.DoctorBookingApp.Repo;

import com.geekster.DoctorBookingApp.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface IPatientRepo extends JpaRepository<Patient,Long> {

    Patient findFirstByPatientEmail(String patientEmail);
}
