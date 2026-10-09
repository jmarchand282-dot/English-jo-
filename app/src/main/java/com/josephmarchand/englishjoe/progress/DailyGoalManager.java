package com.josephmarchand.englishjoe.progress;

import android.content.Context;
import android.content.SharedPreferences;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DailyGoalManager {

    private static final String PREFS = "english_joe_daily_goal";
    private static final String KEY_DATE = "date";
    private static final String KEY_XP = "xp";
    private static final String KEY_TARGET = "target";

    private final SharedPreferences preferences;

    public DailyGoalManager(Context context) {
        preferences = context.getApplicationContext()
                .getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        refreshDay();
    }

    private String today() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.US)
                .format(new Date());
    }

    private synchronized void refreshDay() {
        String currentDate = today();
        String savedDate = preferences.getString(KEY_DATE, "");

        if (!currentDate.equals(savedDate)) {
            preferences.edit()
                    .putString(KEY_DATE, currentDate)
                    .putInt(KEY_XP, 0)
                    .apply();
        }
    }

    public synchronized void addXp(int xp) {
        refreshDay();

        if (xp <= 0) {
            return;
        }

        int current = preferences.getInt(KEY_XP, 0);

        preferences.edit()
                .putInt(KEY_XP, current + xp)
                .apply();
    }

    public int getTodayXp() {
        refreshDay();
        return preferences.getInt(KEY_XP, 0);
    }

    public void setTarget(int target) {
        preferences.edit()
                .putInt(KEY_TARGET, Math.max(1, target))
                .apply();
    }

    public int getTarget() {
        return preferences.getInt(KEY_TARGET, 50);
    }

    public int getRemainingXp() {
        return Math.max(0, getTarget() - getTodayXp());
    }

    public int getProgressPercent() {
        return Math.min(100, getTodayXp() * 100 / getTarget());
    }

    public boolean isCompleted() {
        return getTodayXp() >= getTarget();
    }

    public void resetToday() {
        preferences.edit()
                .putString(KEY_DATE, today())
                .putInt(KEY_XP, 0)
                .apply();
    }
                                   }
