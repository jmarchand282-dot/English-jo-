package com.josephmarchand.englishjoe.data;

public class UserProfile {

    private String firstName;
    private String username;
    private String level;
    private String targetLanguage;
    private String reason;

    public UserProfile() {
        firstName = "";
        username = "";
        level = "A1";
        targetLanguage = "English";
        reason = "";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTargetLanguage() {
        return targetLanguage;
    }

    public void setTargetLanguage(String targetLanguage) {
        this.targetLanguage = targetLanguage;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
