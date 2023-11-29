package com.geekster.DoctorBookingApp.Model.dto;

import com.geekster.DoctorBookingApp.Model.Appointment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleAppointmentDTO {
    AuthenticationInputdto authInfo;
    Appointment appointment;
}
