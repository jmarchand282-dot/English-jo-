package com.josephmarchand.englishjoe.courses;

import android.content.Context;
import android.content.SharedPreferences;

public class CourseUnlockManager {

    private static final String PREFS = "english_joe_course_unlocks";

    private final SharedPreferences preferences;

    public CourseUnlockManager(Context context) {
        preferences = context.getApplicationContext()
                .getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    public boolean isUnlocked(String level) {
        if (level == null) {
            return false;
        }

        if ("A1".equalsIgnoreCase(level)) {
            return true;
        }

        return preferences.getBoolean(level.toUpperCase(), false);
    }

    public boolean unlock(String level) {
        if (level == null || level.trim().isEmpty()) {
            return false;
        }

        String key = level.toUpperCase();

        if (preferences.getBoolean(key, false)) {
            return false;
        }

        preferences.edit()
                .putBoolean(key, true)
                .apply();

        return true;
    }

    public void reset() {
        preferences.edit().clear().apply();
    }
}
