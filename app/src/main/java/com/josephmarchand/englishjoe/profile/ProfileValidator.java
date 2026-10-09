package com.josephmarchand.englishjoe.profile;

public final class ProfileValidator {

    private ProfileValidator() {
    }

    public static boolean isValidFirstName(String name) {
        return name != null
                && name.trim().length() >= 2
                && name.trim().length() <= 40;
    }

    public static boolean isValidUsername(String username) {
        return username != null
                && username.trim().matches("[A-Za-z0-9._-]{3,20}");
    }

    public static boolean isValidLanguage(String language) {
        return language != null && !language.trim().isEmpty();
    }

    public static boolean isValidLevel(String level) {
        if (level == null) {
            return false;
        }

        switch (level.trim().toUpperCase(java.util.Locale.ROOT)) {
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

    public static String cleanName(String name) {
        return name == null ? "" : name.trim();
    }

    public static String cleanUsername(String username) {
        return username == null ? "" : username.trim();
    }
}
