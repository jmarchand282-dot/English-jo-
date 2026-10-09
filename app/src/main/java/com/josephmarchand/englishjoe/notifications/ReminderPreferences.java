package com.josephmarchand.englishjoe.notifications;

import android.content.Context;
import android.content.SharedPreferences;

public class ReminderPreferences {

    private static final String PREFS = "english_joe_reminder_preferences";

    private final SharedPreferences preferences;

    public ReminderPreferences(Context context) {
        preferences = context.getApplicationContext()
                .getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    public boolean isEnabled() {
        return preferences.getBoolean("enabled", true);
    }

    public void setEnabled(boolean enabled) {
        preferences.edit().putBoolean("enabled", enabled).apply();
    }

    public int getHour() {
        return preferences.getInt("hour", 18);
    }

    public int getMinute() {
        return preferences.getInt("minute", 0);
    }

    public void setTime(int hour, int minute) {
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Heure de rappel invalide.");
        }

        preferences.edit()
                .putInt("hour", hour)
                .putInt("minute", minute)
                .apply();
    }

    public ReminderTime getTime() {
        return new ReminderTime(getHour(), getMinute());
    }

    public void reset() {
        preferences.edit().clear().apply();
    }
}
