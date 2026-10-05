package com.josephmarchand.englishjoe.data;

public class DailyGoal {

    private int targetXp;
    private int currentXp;

    public DailyGoal() {
        targetXp = 50;
        currentXp = 0;
    }

    public DailyGoal(int targetXp, int currentXp) {
        this.targetXp = targetXp;
        this.currentXp = currentXp;
    }

    public int getTargetXp() {
        return targetXp;
    }

    public void setTargetXp(int targetXp) {
        this.targetXp = Math.max(1, targetXp);
    }

    public int getCurrentXp() {
        return currentXp;
    }

    public void setCurrentXp(int currentXp) {
        this.currentXp = Math.max(0, currentXp);
    }

    public int getRemainingXp() {
        return Math.max(0, targetXp - currentXp);
    }

    public int getProgressPercent() {

        if (targetXp <= 0) {
            return 0;
        }

        return Math.min(
                100,
                (currentXp * 100) / targetXp
        );
    }

    public boolean isCompleted() {
        return currentXp >= targetXp;
    }
}
