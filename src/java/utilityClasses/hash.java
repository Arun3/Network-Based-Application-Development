package utilityClasses;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Base64;


public class hash
{
    

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



    /*  This code uses SHA-256. If this algorithm isn't available to 
     you, you can try a weaker level of encryption 
     such as SHA-128.
     */

    public static String hashPassword(String password)
            throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] mdArray = md.digest();
        StringBuilder sb = new StringBuilder(mdArray.length * 2);
        for (byte b : mdArray) {
            int v = b & 0xff;
            if (v < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString();
    }

    public static String getSalt() {
        Random r = new SecureRandom();
        byte[] saltBytes = new byte[32];
        r.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }

    public static String hashAndSaltPassword(String password, String salt)
            throws NoSuchAlgorithmException {
        return hashPassword(password + salt);
    }

    public static void checkPasswordStrength(String password)
            throws Exception {
        if (password == null || password.trim().isEmpty()) {
            throw new Exception("Password cannot be empty.");
        } else if (password.length() < 8) {
            throw new Exception("Password is too short. "
                    + "Must be at least 8 characters long.");
        }
    }
    
    public static boolean checkPassword(String password, String salt, String hash) {
        
        
        
        
        
        
        return true;
    }
    
}
