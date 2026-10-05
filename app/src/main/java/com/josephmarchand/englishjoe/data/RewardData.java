package com.josephmarchand.englishjoe.data;

public class RewardData {

    private int requiredLessons;
    private int completedLessons;

    public RewardData() {
        requiredLessons = 2;
        completedLessons = 0;
    }

    public RewardData(int requiredLessons, int completedLessons) {
        this.requiredLessons = Math.max(1, requiredLessons);
        this.completedLessons = Math.max(0, completedLessons);
    }

    public int getRequiredLessons() {
        return requiredLessons;
    }

    public int getCompletedLessons() {
        return completedLessons;
    }

    public void setRequiredLessons(int requiredLessons) {
        this.requiredLessons = Math.max(1, requiredLessons);
    }

    public void setCompletedLessons(int completedLessons) {
        this.completedLessons = Math.max(0, completedLessons);
    }

    public int getRemainingLessons() {
        return Math.max(
                0,
                requiredLessons - completedLessons
        );
    }

    public boolean isUnlocked() {
        return completedLessons >= requiredLessons;
    }
}
