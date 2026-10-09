package com.josephmarchand.englishjoe.courses;

import com.josephmarchand.englishjoe.models.Lesson;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class CourseFilter {

    private CourseFilter() {
    }

    public static List<Course> byLevel(
            List<Course> courses,
            String level
    ) {
        List<Course> result = new ArrayList<>();

        if (courses == null || level == null) {
            return result;
        }

        for (Course course : courses) {
            if (course != null
                    && level.equalsIgnoreCase(course.getLevel())) {
                result.add(course);
            }
        }

        return result;
    }

    public static List<Course> search(
            List<Course> courses,
            String query
    ) {
        List<Course> result = new ArrayList<>();

        if (courses == null) {
            return result;
        }

        String searchText = query == null
                ? ""
                : query.trim().toLowerCase(Locale.ROOT);

        for (Course course : courses) {
            if (course == null) {
                continue;
            }

            boolean matches = searchText.isEmpty()
                    || contains(course.getTitle(), searchText)
                    || contains(course.getDescription(), searchText)
                    || contains(course.getLevel(), searchText);

            if (matches) {
                result.add(course);
            }
        }

        return result;
    }

    public static List<Lesson> getLessonsByLevel(
            List<Lesson> lessons,
            String level
    ) {
        List<Lesson> result = new ArrayList<>();

        if (lessons == null || level == null) {
            return result;
        }

        for (Lesson lesson : lessons) {
            if (lesson != null
                    && level.equalsIgnoreCase(lesson.getLevel())) {
                result.add(lesson);
            }
        }

        return result;
    }

    private static boolean contains(String value, String query) {
        return value != null
                && value.toLowerCase(Locale.ROOT).contains(query);
    }
}
