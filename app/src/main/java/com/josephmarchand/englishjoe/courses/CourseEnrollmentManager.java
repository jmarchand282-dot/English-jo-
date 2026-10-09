package com.josephmarchand.englishjoe.courses;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

public class CourseEnrollmentManager {

    private static final String PREFS = "english_joe_enrollment";
    private static final String KEY_ENROLLED = "enrolled_courses";

    private final SharedPreferences preferences;

    public CourseEnrollmentManager(Context context) {
        preferences = context.getApplicationContext()
                .getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    public synchronized boolean enroll(String courseId) {
        if (!isValidId(courseId)) {
            return false;
        }

        Set<String> courses = getEnrolledCourses();

        if (courses.contains(courseId)) {
            return false;
        }

        courses.add(courseId);

        preferences.edit()
                .putStringSet(KEY_ENROLLED, courses)
                .apply();

        return true;
    }

    public synchronized boolean isEnrolled(String courseId) {
        return isValidId(courseId)
                && getEnrolledCourses().contains(courseId);
    }

    public synchronized boolean unenroll(String courseId) {
        if (!isValidId(courseId)) {
            return false;
        }

        Set<String> courses = getEnrolledCourses();

        if (!courses.remove(courseId)) {
            return false;
        }

        preferences.edit()
                .putStringSet(KEY_ENROLLED, courses)
                .apply();

        return true;
    }

    public synchronized Set<String> getEnrolledCourses() {
        Set<String> saved = preferences.getStringSet(
                KEY_ENROLLED,
                new HashSet<>()
        );

        return saved == null
                ? new HashSet<>()
                : new HashSet<>(saved);
    }

    public synchronized int getEnrollmentCount() {
        return getEnrolledCourses().size();
    }

    public synchronized void clear() {
        preferences.edit()
                .remove(KEY_ENROLLED)
                .apply();
    }

    private boolean isValidId(String id) {
        return id != null && !id.trim().isEmpty();
    }
}
