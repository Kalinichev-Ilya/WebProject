package com.webproject.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class SecurityService {
    private final String value;

    public SecurityService(String value) {
        this.value = value;
    }

    public static StringBuffer md5(String value) {
        StringBuffer hexString = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(value.getBytes());

            for (int i = 0; i < hash.length; i++) {
                if ((0xff & hash[i]) < 0x10) {
                    hexString.append("0"
                            + Integer.toHexString((0xFF & hash[i])));
                } else {
                    hexString.append(Integer.toHexString(0xFF & hash[i]));
                }
            }
        } catch (NoSuchAlgorithmException e) {
        }
        return hexString;
    }
}
