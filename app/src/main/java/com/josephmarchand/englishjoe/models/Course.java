package com.josephmarchand.englishjoe.models;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private final String id;
    private final String title;
    private final String description;
    private final String level;
    private final List<Lesson> lessons;

    public Course(
            String id,
            String title,
            String description,
            String level
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.level = level;
        this.lessons = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLevel() {
        return level;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void addLesson(Lesson lesson) {

        if (lesson != null) {
            lessons.add(lesson);
        }
    }

    public int getLessonCount() {
        return lessons.size();
    }

    public int getCompletedLessonCount() {

        int count = 0;

        for (Lesson lesson : lessons) {
            if (lesson.isCompleted()) {
                count++;
            }
        }

        return count;
    }

    public int getProgressPercent() {

        if (lessons.isEmpty()) {
            return 0;
        }

        return (getCompletedLessonCount() * 100)
                / lessons.size();
    }
}
