package com.josephmarchand.englishjoe.models;

public class Achievement {

    private final String id;
    private final String title;
    private final String description;
    private final int requiredValue;
    private boolean unlocked;

    public Achievement(
            String id,
            String title,
            String description,
            int requiredValue
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.requiredValue = Math.max(0, requiredValue);
        this.unlocked = false;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getRequiredValue() {
        return requiredValue;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }
}
