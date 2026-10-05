package com.josephmarchand.englishjoe.data;

import android.content.Context;
import android.content.SharedPreferences;

public class NotificationSettings {

    private static final String PREFS = "english_joe_notifications";

    private static final String KEY_ENABLED = "enabled";
    private static final String KEY_HOUR = "hour";
    private static final String KEY_MINUTE = "minute";

    private final SharedPreferences preferences;

    public NotificationSettings(Context context) {

        preferences = context.getApplicationContext()
                .getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    public boolean isEnabled() {
        return preferences.getBoolean(KEY_ENABLED, false);
    }

    public void setEnabled(boolean enabled) {

        preferences.edit()
                .putBoolean(KEY_ENABLED, enabled)
                .apply();
    }

    public int getHour() {
        return preferences.getInt(KEY_HOUR, 18);
    }

    public int getMinute() {
        return preferences.getInt(KEY_MINUTE, 0);
    }

    public void setTime(int hour, int minute) {

        preferences.edit()
                .putInt(KEY_HOUR, hour)
                .putInt(KEY_MINUTE, minute)
                .apply();
    }

    public void reset() {

        preferences.edit()
                .clear()
                .apply();
    }
}
