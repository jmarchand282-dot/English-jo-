package com.josephmarchand.englishjoe.utils;

import android.text.TextUtils;
import android.util.Patterns;

public final class AppValidator {

    private AppValidator() {
    }

    public static boolean isValidName(String name) {
        return name != null
                && name.trim().length() >= 2
                && name.trim().length() <= 40;
    }

    public static boolean isValidUsername(String username) {
        return username != null
                && username.matches("^[a-zA-Z0-9._-]{3,20}$");
    }

    public static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email)
                && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isValidLevel(String level) {
        if (level == null) {
            return false;
        }

        switch (level.toUpperCase()) {
            case "A1":
            case "A2":
            case "B1":
            case "B2":
            case "C1":
            case "C2":
                return true;
            default:
                return false;
        }
    }

    public static boolean isValidLanguagePair(
            String sourceLanguage,
            String targetLanguage
    ) {
        return sourceLanguage != null
                && targetLanguage != null
                && !sourceLanguage.trim().isEmpty()
                && !targetLanguage.trim().isEmpty()
                && !sourceLanguage.equalsIgnoreCase(targetLanguage);
    }
}
