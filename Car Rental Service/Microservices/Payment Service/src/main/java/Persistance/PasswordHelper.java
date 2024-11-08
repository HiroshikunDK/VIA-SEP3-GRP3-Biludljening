package Persistance;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHelper {

    // Method to hash passwords
    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    // Method to verify a plain password against a hashed password
    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

    // Method to hash sensitive payment information
    public static String hashSensitiveData(String plainData) {
        return BCrypt.hashpw(plainData, BCrypt.gensalt());
    }

    // Method to verify sensitive data
    public static boolean checkSensitiveData(String plainData, String hashedData) {
        return BCrypt.checkpw(plainData, hashedData);
    }
}
