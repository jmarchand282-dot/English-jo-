package com.josephmarchand.englishjoe.data;

import android.content.Context;
import android.content.SharedPreferences;

/** Stores lesson completion locally and prevents duplicate XP rewards. */
public final class LessonProgress {
    private static final String PREFS = "english_joe_data";
    private static final String KEY_XP = "xp";
    private static final String KEY_COMPLETED = "completed_lessons";

    private LessonProgress() {}

    public static boolean isCompleted(Context context, String lessonId) {
        return preferences(context).getBoolean("lesson_completed_" + lessonId, false);
    }

    /** Returns true only the first time this lesson is completed. */
    public static boolean complete(Context context, String lessonId, int xpReward) {
        SharedPreferences prefs = preferences(context);
        String key = "lesson_completed_" + lessonId;
        if (prefs.getBoolean(key, false)) return false;

        int xp = prefs.getInt(KEY_XP, 0);
        int completed = prefs.getInt(KEY_COMPLETED, 0);
        prefs.edit()
            .putBoolean(key, true)
            .putInt(KEY_XP, xp + Math.max(0, xpReward))
            .putInt(KEY_COMPLETED, completed + 1)
            .apply();
        return true;
    }

    private static SharedPreferences preferences(Context context) {
        return context.getApplicationContext()
            .getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }
}
