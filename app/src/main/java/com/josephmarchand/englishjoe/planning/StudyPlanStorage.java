package com.josephmarchand.englishjoe.planning;

import android.content.Context;
import android.content.SharedPreferences;

public class StudyPlanStorage {

    private static final String PREFS = "english_joe_study_plan";

    private final SharedPreferences preferences;

    public StudyPlanStorage(Context context) {
        preferences = context.getApplicationContext()
                .getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    public void save(StudyPlan plan) {
        if (plan == null) {
            return;
        }

        preferences.edit()
                .putInt("daily_minutes", plan.getDailyMinutes())
                .putInt("weekly_days", plan.getWeeklyDays())
                .putString("preferred_time", plan.getPreferredTime())
                .putBoolean("reminders_enabled", plan.isRemindersEnabled())
                .apply();
    }

    public StudyPlan load() {
        StudyPlan plan = new StudyPlan();

        plan.setDailyMinutes(preferences.getInt("daily_minutes", 20));
        plan.setWeeklyDays(preferences.getInt("weekly_days", 5));
        plan.setPreferredTime(
                preferences.getString("preferred_time", "18:00")
        );
        plan.setRemindersEnabled(
                preferences.getBoolean("reminders_enabled", true)
        );

        return plan;
    }

    public void reset() {
        preferences.edit().clear().apply();
    }
}
