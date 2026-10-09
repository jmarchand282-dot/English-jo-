package com.josephmarchand.englishjoe.settings;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPreferences {

    private static final String PREFS = "english_joe_user_preferences";

    private final SharedPreferences preferences;

    public UserPreferences(Context context) {
        preferences = context.getApplicationContext()
                .getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    public boolean isSoundEnabled() {
        return preferences.getBoolean("sound_enabled", true);
    }

    public void setSoundEnabled(boolean enabled) {
        preferences.edit().putBoolean("sound_enabled", enabled).apply();
    }

    public boolean areNotificationsEnabled() {
        return preferences.getBoolean("notifications_enabled", true);
    }

    public void setNotificationsEnabled(boolean enabled) {
        preferences.edit()
                .putBoolean("notifications_enabled", enabled)
                .apply();
    }

    public String getStudyLanguage() {
        return preferences.getString("study_language", "English");
    }

    public void setStudyLanguage(String language) {
        if (language != null && !language.trim().isEmpty()) {
            preferences.edit()
                    .putString("study_language", language.trim())
                    .apply();
        }
    }

    public String getEnglishVariant() {
        return preferences.getString("english_variant", "American English");
    }

    public void setEnglishVariant(String variant) {
        if (variant != null && !variant.trim().isEmpty()) {
            preferences.edit()
                    .putString("english_variant", variant.trim())
                    .apply();
        }
    }

    public void reset() {
        preferences.edit().clear().apply();
    }
}
