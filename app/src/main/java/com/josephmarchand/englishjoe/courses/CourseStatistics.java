package com.josephmarchand.englishjoe.courses;

public class CourseStatistics {

    private final int totalLessons;
    private final int completedLessons;
    private final int lockedLessons;

    public CourseStatistics(
            int totalLessons,
            int completedLessons,
            int lockedLessons) {
        this.totalLessons = Math.max(0, totalLessons);
        this.completedLessons = Math.max(0,
                Math.min(completedLessons, this.totalLessons));
        this.lockedLessons = Math.max(0,
                Math.min(lockedLessons, this.totalLessons));
    }

    public int getTotalLessons() {
        return totalLessons;
    }

    public int getCompletedLessons() {
        return completedLessons;
    }

    public int getLockedLessons() {
        return lockedLessons;
    }

    public int getRemainingLessons() {
        return Math.max(0, totalLessons - completedLessons);
    }

    public int getCompletionPercentage() {
        if (totalLessons == 0) return 0;
        return completedLessons * 100 / totalLessons;
    }
}
