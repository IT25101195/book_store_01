package com.library.util;

import java.util.regex.Pattern;

/**
 * Validation utility for user input.
 */
public final class ValidationUtil {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    private ValidationUtil() { }

    /**
     * Check if a string is null or empty/blank.
     */
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    /**
     * Validate e-mail format.
     */
    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * Validate password length (min 4 characters).
     */
    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 4;
    }

    /**
     * Check if two passwords match.
     */
    public static boolean passwordsMatch(String pw1, String pw2) {
        return pw1 != null && pw1.equals(pw2);
    }
}
