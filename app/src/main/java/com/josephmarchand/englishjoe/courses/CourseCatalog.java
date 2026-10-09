package com.josephmarchand.englishjoe.courses;

import com.josephmarchand.englishjoe.courses.A1.A1Course;
import com.josephmarchand.englishjoe.models.Lesson;

import java.util.ArrayList;
import java.util.List;

public final class CourseCatalog {

    private CourseCatalog() {
        // Classe utilitaire
    }

    public static List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();

        Course a1 = new Course(
                "a1",
                "English A1",
                "Les bases de l'anglais pour débuter.",
                "A1"
        );

        for (Lesson lesson : A1Course.getLessons()) {
            a1.addLesson(lesson);
        }

        courses.add(a1);

        return courses;
    }

    public static Course getCourse(String level) {
        if (level == null) {
            return null;
        }

        for (Course course : getCourses()) {
            if (level.equalsIgnoreCase(course.getLevel())) {
                return course;
            }
        }

        return null;
    }

    public static int getCourseCount() {
        return getCourses().size();
    }

    public static List<String> getAvailableLevels() {
        List<String> levels = new ArrayList<>();

        for (Course course : getCourses()) {
            levels.add(course.getLevel());
        }

        return levels;
    }
}
