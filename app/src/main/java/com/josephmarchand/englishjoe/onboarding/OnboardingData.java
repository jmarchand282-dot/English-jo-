package com.josephmarchand.englishjoe.onboarding;

public class OnboardingData {

    private String firstName = "";
    private String username = "";
    private String sourceLanguage = "French";
    private String targetLanguage = "English";
    private String level = "A1";
    private String reason = "";
    private int placementScore = 0;
    private boolean completed = false;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? "" : firstName.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? "" : username.trim();
    }

    public String getSourceLanguage() {
        return sourceLanguage;
    }

    public void setSourceLanguage(String sourceLanguage) {
        this.sourceLanguage = sourceLanguage == null ? "" : sourceLanguage;
    }

    public String getTargetLanguage() {
        return targetLanguage;
    }

    public void setTargetLanguage(String targetLanguage) {
        this.targetLanguage = targetLanguage == null ? "" : targetLanguage;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? "A1" : level;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? "" : reason.trim();
    }

    public int getPlacementScore() {
        return placementScore;
    }

    public void setPlacementScore(int placementScore) {
        this.placementScore = Math.max(0, Math.min(100, placementScore));
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isReady() {
        return !firstName.isEmpty()
                && !username.isEmpty()
                && !sourceLanguage.isEmpty()
                && !targetLanguage.isEmpty()
                && !level.isEmpty();
    }

    public void reset() {
        firstName = "";
        username = "";
        sourceLanguage = "French";
        targetLanguage = "English";
        level = "A1";
        reason = "";
        placementScore = 0;
        completed = false;
    }
      }
