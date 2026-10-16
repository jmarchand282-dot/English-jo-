package com.josephmarchand.englishjoe.courses;

import com.josephmarchand.englishjoe.courses.A1.A1Course;
import com.josephmarchand.englishjoe.models.Course;
import com.josephmarchand.englishjoe.models.Lesson;

import java.util.ArrayList;
import java.util.List;

public final class CourseCatalog {

    private CourseCatalog() {
    }

    public static List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();
        Course a1 = createA1Course();

        if (a1 != null) {
            courses.add(a1);
        }

        return courses;
    }

    public static Course createA1Course() {
        Course a1 = new Course(
                "a1",
                "English A1",
                "Les bases de l'anglais pour débuter.",
                "A1"
        );

        List<Lesson> lessons = A1Course.getLessons();

        if (lessons != null) {
            for (Lesson lesson : lessons) {
                if (lesson != null) {
                    a1.addLesson(lesson);
                }
            }
        }

        return a1;
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
