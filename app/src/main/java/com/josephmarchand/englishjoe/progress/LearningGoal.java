package com.josephmarchand.englishjoe.progress;

public class LearningGoal {

    private final String id;
    private final String title;
    private final int target;
    private int current;

    public LearningGoal(String id, String title, int target) {
        this.id = id == null ? "" : id;
        this.title = title == null ? "" : title;
        this.target = Math.max(1, target);
        this.current = 0;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getTarget() {
        return target;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = Math.max(0, Math.min(current, target));
    }

    public void addProgress(int amount) {
        if (amount > 0) setCurrent(current + amount);
    }

    public boolean isCompleted() {
        return current >= target;
    }

    public int getPercentage() {
        return current * 100 / target;
    }
}
