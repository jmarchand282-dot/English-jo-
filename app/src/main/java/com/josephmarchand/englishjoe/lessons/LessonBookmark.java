package com.josephmarchand.englishjoe.lessons;

public class LessonBookmark {

    private final String lessonId;
    private final String title;
    private final long savedAt;

    public LessonBookmark(String lessonId, String title, long savedAt) {
        this.lessonId = lessonId == null ? "" : lessonId;
        this.title = title == null ? "" : title;
        this.savedAt = savedAt;
    }

    public String getLessonId() {
        return lessonId;
    }

    public String getTitle() {
        return title;
    }

    public long getSavedAt() {
        return savedAt;
    }
}
