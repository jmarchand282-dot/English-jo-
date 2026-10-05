package com.josephmarchand.englishjoe.courses;

import com.josephmarchand.englishjoe.courses.A1.A1Course;
import com.josephmarchand.englishjoe.models.Course;
import com.josephmarchand.englishjoe.models.Lesson;

import java.util.ArrayList;
import java.util.List;

public class CourseManager {

    private CourseManager() {
    }

    public static List<Course> getAllCourses() {

        List<Course> courses = new ArrayList<>();

        courses.add(createA1Course());

        return courses;
    }

    public static Course getCourse(String level) {

        if (level == null) {
            return createA1Course();
        }

        switch (level.toUpperCase()) {

            case "A1":
                return createA1Course();

            default:
                return createA1Course();
        }
    }

    private static Course createA1Course() {

        Course course = new Course(
                "a1",
                "Anglais A1",
                "Les bases essentielles de l'anglais.",
                "A1"
        );

        List<Lesson> lessons = A1Course.getLessons();

        for (Lesson lesson : lessons) {
            course.addLesson(lesson);
        }

        return course;
    }
}
