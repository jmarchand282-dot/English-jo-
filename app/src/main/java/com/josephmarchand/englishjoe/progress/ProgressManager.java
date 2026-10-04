package com.josephmarchand.englishjoe.progress;

import android.content.Context;

import com.josephmarchand.englishjoe.data.AppData;

public class ProgressManager {

    private final AppData appData;

    public ProgressManager(Context context) {
        appData = new AppData(context);
    }

    public int getXp() {
        return appData.getXp();
    }

    public void addXp(int amount) {
        if (amount <= 0) {
            return;
        }

        appData.setXp(appData.getXp() + amount);
    }

    public int getStreak() {
        return appData.getStreak();
    }

    public void setStreak(int streak) {
        appData.setStreak(streak);
    }

    public void increaseStreak() {
        appData.setStreak(appData.getStreak() + 1);
    }

    public int getCompletedLessons() {
        return appData.getCompletedLessons();
    }

    public void completeLesson() {
        appData.setCompletedLessons(
                appData.getCompletedLessons() + 1
        );
    }

    public int getDailyGoal() {
        return 50;
    }

    public int getDailyXp() {
        return appData.getXp() % 50;
    }

    public boolean isDailyGoalCompleted() {
        return getDailyXp() >= getDailyGoal();
    }

    public int getXpToNextReward() {
        int remainder = appData.getXp() % 100;

        if (remainder == 0) {
            return 100;
        }

        return 100 - remainder;
    }

    public void resetProgress() {
        appData.setXp(0);
        appData.setStreak(0);
        appData.setCompletedLessons(0);
    }
}
