package com.josephmarchand.englishjoe.profile;

import android.content.Context;
import android.content.SharedPreferences;

public class ProfileStorage {

    private static final String PREFS = "english_joe_profile_storage";

    private static final String FIRST_NAME = "first_name";
    private static final String USERNAME = "username";
    private static final String TARGET_LANGUAGE = "target_language";
    private static final String LEVEL = "level";
    private static final String REASON = "reason";

    private final SharedPreferences preferences;

    public ProfileStorage(Context context) {
        preferences = context.getApplicationContext()
                .getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    public void save(ProfileData profile) {

        preferences.edit()
                .putString(FIRST_NAME, profile.getFirstName())
                .putString(USERNAME, profile.getUsername())
                .putString(TARGET_LANGUAGE, profile.getTargetLanguage())
                .putString(LEVEL, profile.getLevel())
                .putString(REASON, profile.getReason())
                .apply();
    }

    public ProfileData load() {

        ProfileData profile = new ProfileData();

        profile.setFirstName(
                preferences.getString(FIRST_NAME, "")
        );

        profile.setUsername(
                preferences.getString(USERNAME, "")
        );

        profile.setTargetLanguage(
                preferences.getString(TARGET_LANGUAGE, "English")
        );

        profile.setLevel(
                preferences.getString(LEVEL, "A1")
        );

        profile.setReason(
                preferences.getString(REASON, "")
        );

        return profile;
    }

    public boolean hasProfile() {
        return !preferences
                .getString(FIRST_NAME, "")
                .trim()
                .isEmpty();
    }

    public void clear() {
        preferences.edit()
                .clear()
                .apply();
    }
}
