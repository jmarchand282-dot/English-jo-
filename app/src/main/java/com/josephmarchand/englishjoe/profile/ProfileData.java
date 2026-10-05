package com.josephmarchand.englishjoe.profile;

public class ProfileData {

    private String firstName;
    private String username;
    private String targetLanguage;
    private String level;
    private String reason;

    public ProfileData() {
        firstName = "";
        username = "";
        targetLanguage = "English";
        level = "A1";
        reason = "";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? "" : firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? "" : username;
    }

    public String getTargetLanguage() {
        return targetLanguage;
    }

    public void setTargetLanguage(String targetLanguage) {
        this.targetLanguage = targetLanguage == null ? "English" : targetLanguage;
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
        this.reason = reason == null ? "" : reason;
    }
}
