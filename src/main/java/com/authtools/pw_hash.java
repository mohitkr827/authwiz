package com.authtools;

import org.mindrot.jbcrypt.BCrypt;

public class pw_hash {

    public static String hashPassword(String plainTextPassword) {
        // Hash a password using a salt (you can also specify the salt)
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    public static boolean checkPassword(String plainTextPassword, String hashedPassword) {
        return BCrypt.checkpw(plainTextPassword, hashedPassword);
    }
}
