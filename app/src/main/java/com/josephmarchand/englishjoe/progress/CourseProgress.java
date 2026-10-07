package com.josephmarchand.englishjoe.progress;

public class CourseProgress {

    private final String courseId;
    private int completedLessons;
    private int totalLessons;

    public CourseProgress(
            String courseId,
            int completedLessons,
            int totalLessons
    ) {
        this.courseId = courseId;
        this.completedLessons = Math.max(0, completedLessons);
        this.totalLessons = Math.max(0, totalLessons);
    }

    public String getCourseId() {
        return courseId;
    }

    public int getCompletedLessons() {
        return completedLessons;
    }

    public int getTotalLessons() {
        return totalLessons;
    }

    public void setCompletedLessons(int value) {
        completedLessons = Math.max(0, value);
    }

    public void setTotalLessons(int value) {
        totalLessons = Math.max(0, value);
    }

    public int getProgressPercent() {

        if (totalLessons == 0) {
            return 0;
        }

        return Math.min(
                100,
                (completedLessons * 100) / totalLessons
        );
    }

    public boolean isCompleted() {
        return totalLessons > 0
                && completedLessons >= totalLessons;
    }
            }
