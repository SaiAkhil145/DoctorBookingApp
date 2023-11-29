package com.geekster.DoctorBookingApp.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationInputdto {

    private String email;
    private String tokenValue;
}
