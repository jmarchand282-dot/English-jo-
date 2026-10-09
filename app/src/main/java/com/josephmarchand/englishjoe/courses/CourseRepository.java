package com.josephmarchand.englishjoe.courses;

import com.josephmarchand.englishjoe.models.Course;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseRepository {

    private final List<Course> courses = new ArrayList<>();

    public CourseRepository() {
        loadInitialCourses();
    }

    private void loadInitialCourses() {
        Course a1 = CourseCatalog.createA1Course();
        if (a1 != null) {
            courses.add(a1);
        }
    }

    public List<Course> getAllCourses() {
        return Collections.unmodifiableList(courses);
    }

    public Course findById(String id) {
        if (id == null) return null;

        for (Course course : courses) {
            if (id.equals(course.getId())) {
                return course;
            }
        }
        return null;
    }

    public void addCourse(Course course) {
        if (course != null && findById(course.getId()) == null) {
            courses.add(course);
        }
    }

    public int getCourseCount() {
        return courses.size();
    }

    public void clear() {
        courses.clear();
    }
}
