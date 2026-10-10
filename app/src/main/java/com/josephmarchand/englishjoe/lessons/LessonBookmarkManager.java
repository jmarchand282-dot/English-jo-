package com.josephmarchand.englishjoe.lessons;

import android.content.Context;

public class LessonBookmarkManager {

    private final LessonBookmarkStorage storage;

    public LessonBookmarkManager(Context context) {
        storage = new LessonBookmarkStorage(context);
    }

    public boolean toggle(String lessonId) {
        if (storage.isSaved(lessonId)) {
            storage.remove(lessonId);
            return false;
        }

        return storage.save(lessonId);
    }

    public boolean isSaved(String lessonId) {
        return storage.isSaved(lessonId);
    }

    public int getSavedCount() {
        return storage.count();
    }

    public void clearAll() {
        storage.clear();
    }
}
