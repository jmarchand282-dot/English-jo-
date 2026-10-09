package com.josephmarchand.englishjoe.lessons;

import com.josephmarchand.englishjoe.courses.A1.A1Course;
import com.josephmarchand.englishjoe.models.Lesson;

import java.util.ArrayList;
import java.util.List;

public final class LessonBank {

    private LessonBank() {
        // Classe utilitaire
    }

    public static List<Lesson> getAllLessons() {
        List<Lesson> lessons = new ArrayList<>();

        lessons.addAll(A1Course.getLessons());

        return lessons;
    }

    public static List<Lesson> getLessonsByLevel(String level) {
        List<Lesson> result = new ArrayList<>();

        if (level == null) {
            return result;
        }

        for (Lesson lesson : getAllLessons()) {
            if (level.equalsIgnoreCase(lesson.getLevel())) {
                result.add(lesson);
            }
        }

        return result;
    }

    public static Lesson findById(String lessonId) {
        if (lessonId == null) {
            return null;
        }

        for (Lesson lesson : getAllLessons()) {
            if (lessonId.equals(lesson.getId())) {
                return lesson;
            }
        }

        return null;
    }

    public static int getTotalLessons() {
        return getAllLessons().size();
    }
}
