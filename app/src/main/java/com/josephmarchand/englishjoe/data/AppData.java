package com.josephmarchand.englishjoe.data;

import android.content.Context;
import android.content.SharedPreferences;

public class AppData {

    private static final String PREFS_NAME = "english_joe_data";

    private final SharedPreferences preferences;

    public AppData(Context context) {
        preferences = context.getSharedPreferences(
                PREFS_NAME,
                Context.MODE_PRIVATE
        );
    }

    public String getFirstName() {
        return preferences.getString("first_name", "");
    }

    public void setFirstName(String firstName) {
        preferences.edit()
                .putString("first_name", firstName)
                .apply();
    }

    public String getUsername() {
        return preferences.getString("username", "");
    }

    public void setUsername(String username) {
        preferences.edit()
                .putString("username", username)
                .apply();
    }

    public String getLevel() {
        return preferences.getString("level", "A1");
    }

    public void setLevel(String level) {
        preferences.edit()
                .putString("level", level)
                .apply();
    }

    public int getXp() {
        return preferences.getInt("xp", 0);
    }

    public void setXp(int xp) {
        preferences.edit()
                .putInt("xp", Math.max(0, xp))
                .apply();
    }

    public int getStreak() {
        return preferences.getInt("streak", 0);
    }

    public void setStreak(int streak) {
        preferences.edit()
                .putInt("streak", Math.max(0, streak))
                .apply();
    }

    public int getCompletedLessons() {
        return preferences.getInt("completed_lessons", 0);
    }

    public void setCompletedLessons(int lessons) {
        preferences.edit()
                .putInt("completed_lessons", Math.max(0, lessons))
                .apply();
    }

    public boolean isOnboardingCompleted() {
        return preferences.getBoolean("onboarding_completed", false);
    }

    public void setOnboardingCompleted(boolean completed) {
        preferences.edit()
                .putBoolean("onboarding_completed", completed)
                .apply();
    }

    public void resetAll() {
        preferences.edit()
                .clear()
                .apply();
    }
  }
