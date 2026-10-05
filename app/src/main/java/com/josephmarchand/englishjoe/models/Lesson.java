package com.josephmarchand.englishjoe.models;

public class Lesson {

    private int id;
    private String title;
    private String description;
    private String level;
    private String category;
    private int xpReward;
    private boolean completed;
    private boolean locked;

    public Lesson(
            int id,
            String title,
            String description,
            String level,
            String category,
            int xpReward
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.level = level;
        this.category = category;
        this.xpReward = xpReward;
        this.completed = false;
        this.locked = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLevel() {
        return level;
    }

    public String getCategory() {
        return category;
    }

    public int getXpReward() {
        return xpReward;
    }

    public boolean isCompleted() {
        return completed;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
    }
