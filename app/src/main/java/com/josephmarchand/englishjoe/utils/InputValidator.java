package com.josephmarchand.englishjoe.utils;

import android.util.Patterns;

public final class InputValidator {

    private InputValidator() {
    }

    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    public static boolean isValidName(String name) {
        if (!isNotEmpty(name)) return false;

        String cleaned = name.trim();
        return cleaned.length() >= 2 && cleaned.length() <= 40;
    }

    public static boolean isValidEmail(String email) {
        return isNotEmpty(email)
                && Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches();
    }

    public static boolean isValidPositiveNumber(int value) {
        return value > 0;
    }

    public static String normalize(String value) {
        return value == null ? "" : value.trim();
    }
}
