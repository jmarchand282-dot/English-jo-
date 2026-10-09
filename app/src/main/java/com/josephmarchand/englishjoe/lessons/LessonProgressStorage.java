package com.josephmarchand.englishjoe.lessons;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

public class LessonProgressStorage {

    private static final String PREFS = "english_joe_lesson_progress";
    private static final String KEY_COMPLETED = "completed_lessons";

    private final SharedPreferences preferences;

    public LessonProgressStorage(Context context) {
        preferences = context.getApplicationContext()
                .getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    public synchronized boolean markCompleted(String lessonId) {
        if (!isValidId(lessonId)) {
            return false;
        }

        Set<String> completed = getCompletedLessons();

        if (!completed.add(lessonId)) {
            return false;
        }

        preferences.edit()
                .putStringSet(KEY_COMPLETED, completed)
                .apply();

        return true;
    }

    public synchronized boolean isCompleted(String lessonId) {
        return isValidId(lessonId)
                && getCompletedLessons().contains(lessonId);
    }

    public synchronized boolean removeCompleted(String lessonId) {
        if (!isValidId(lessonId)) {
            return false;
        }

        Set<String> completed = getCompletedLessons();

        if (!completed.remove(lessonId)) {
            return false;
        }

        preferences.edit()
                .putStringSet(KEY_COMPLETED, completed)
                .apply();

        return true;
    }

    public synchronized Set<String> getCompletedLessons() {
        Set<String> saved = preferences.getStringSet(
                KEY_COMPLETED,
                new HashSet<>()
        );

        return saved == null
                ? new HashSet<>()
                : new HashSet<>(saved);
    }

    public synchronized int getCompletedCount() {
        return getCompletedLessons().size();
    }

    public synchronized void reset() {
        preferences.edit()
                .remove(KEY_COMPLETED)
                .apply();
    }

    private boolean isValidId(String id) {
        return id != null && !id.trim().isEmpty();
    }
}
