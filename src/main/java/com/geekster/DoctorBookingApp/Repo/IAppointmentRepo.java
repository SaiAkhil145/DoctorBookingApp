package com.geekster.DoctorBookingApp.Repo;

import com.geekster.DoctorBookingApp.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface IAppointmentRepo extends JpaRepository<Appointment,Long> {
}
