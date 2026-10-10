package com.josephmarchand.englishjoe.progress;

public class StudyStreak {

    private int currentDays;
    private int bestDays;
    private long lastStudyDay;

    public StudyStreak(int currentDays, int bestDays, long lastStudyDay) {
        this.currentDays = Math.max(0, currentDays);
        this.bestDays = Math.max(this.currentDays, bestDays);
        this.lastStudyDay = lastStudyDay;
    }

    public int getCurrentDays() {
        return currentDays;
    }

    public int getBestDays() {
        return bestDays;
    }

    public long getLastStudyDay() {
        return lastStudyDay;
    }

    public void recordStudyDay(long today, long yesterday) {
        if (lastStudyDay == today) return;

        if (lastStudyDay == yesterday) {
            currentDays++;
        } else {
            currentDays = 1;
        }

        bestDays = Math.max(bestDays, currentDays);
        lastStudyDay = today;
    }

    public void reset() {
        currentDays = 0;
        bestDays = 0;
        lastStudyDay = 0;
    }
}
