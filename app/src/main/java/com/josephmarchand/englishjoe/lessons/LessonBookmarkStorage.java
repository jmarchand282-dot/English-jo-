package com.josephmarchand.englishjoe.lessons;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashSet;
import java.util.Set;

public class LessonBookmarkStorage {

    private static final String PREFS = "english_joe_bookmarks";
    private static final String KEY_IDS = "lesson_ids";

    private final SharedPreferences preferences;

    public LessonBookmarkStorage(Context context) {
        preferences = context.getApplicationContext()
                .getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    public synchronized boolean save(String lessonId) {
        if (lessonId == null || lessonId.trim().isEmpty()) return false;

        Set<String> ids = getIds();
        boolean added = ids.add(lessonId);

        preferences.edit().putStringSet(KEY_IDS, ids).apply();
        return added;
    }

    public synchronized boolean remove(String lessonId) {
        if (lessonId == null) return false;

        Set<String> ids = getIds();
        boolean removed = ids.remove(lessonId);

        preferences.edit().putStringSet(KEY_IDS, ids).apply();
        return removed;
    }

    public synchronized boolean isSaved(String lessonId) {
        return lessonId != null && getIds().contains(lessonId);
    }

    public synchronized Set<String> getIds() {
        Set<String> saved = preferences.getStringSet(KEY_IDS, null);

        return saved == null ? new HashSet<>() : new HashSet<>(saved);
    }

    public synchronized int count() {
        return getIds().size();
    }

    public synchronized void clear() {
        preferences.edit().remove(KEY_IDS).apply();
    }
}
