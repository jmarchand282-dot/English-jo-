package com.josephmarchand.englishjoe.progress;

import android.content.Context;
import android.content.SharedPreferences;

public class StudyStreakStorage {

    private static final String PREFS = "english_joe_streak";
    private static final String CURRENT = "current_days";
    private static final String BEST = "best_days";
    private static final String LAST_DAY = "last_study_day";

    private final SharedPreferences preferences;

    public StudyStreakStorage(Context context) {
        preferences = context.getApplicationContext()
                .getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    public StudyStreak load() {
        return new StudyStreak(
                preferences.getInt(CURRENT, 0),
                preferences.getInt(BEST, 0),
                preferences.getLong(LAST_DAY, 0)
        );
    }

    public void save(StudyStreak streak) {
        if (streak == null) return;

        preferences.edit()
                .putInt(CURRENT, streak.getCurrentDays())
                .putInt(BEST, streak.getBestDays())
                .putLong(LAST_DAY, streak.getLastStudyDay())
                .apply();
    }

    public void clear() {
        preferences.edit().clear().apply();
    }
}
