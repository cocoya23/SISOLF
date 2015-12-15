package org.eja.sisolf.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


public class CifradoUtil {
    
    private static final SecureRandom RANDOM = new SecureRandom();
    
    public static String cifrar(String password) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(password.getBytes());

            for (int i = 0; i < bytes.length; i++) {
                String hex = Integer.toHexString(0xff & bytes[i]);
                if (hex.length() == 1) {
                    sb.append('0');
                }
                sb.append(hex);
            }

        } catch (NoSuchAlgorithmException e) {
            return "El password no pudo ser encriptado";
        }
        return sb.toString();
    }
    
    public static String nuevaClave(){
        return new BigInteger(50, RANDOM).toString(32);
    }
    
}
