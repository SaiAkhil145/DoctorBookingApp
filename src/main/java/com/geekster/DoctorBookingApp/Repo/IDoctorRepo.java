package com.geekster.DoctorBookingApp.Repo;

import com.geekster.DoctorBookingApp.Model.Doctor;
import com.geekster.DoctorBookingApp.Model.Qualification;
import com.geekster.DoctorBookingApp.Model.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.List;

@Repository
public interface IDoctorRepo extends JpaRepository<Doctor,Long> {
    List<Doctor> findByDocQualificationOrDocSpecialization(Qualification qual, Specialization spec);
}
