package com.geekster.DoctorBookingApp.Service;

import jakarta.xml.bind.DatatypeConverter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncrypter {

    public static String  encrypt(String unhashedPassword) throws NoSuchAlgorithmException {

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(unhashedPassword.getBytes());
        byte[] updated = messageDigest.digest();
        return DatatypeConverter.printHexBinary(updated);


    }
}
