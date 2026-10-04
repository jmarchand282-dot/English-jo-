package com.josephmarchand.englishjoe.data;

public class SettingsData {

    private boolean notificationsEnabled;
    private boolean soundEnabled;
    private boolean studyRemindersEnabled;

    private String studyTime;

    public SettingsData() {
        notificationsEnabled = true;
        soundEnabled = true;
        studyRemindersEnabled = true;
        studyTime = "19:00";
    }

    public boolean isNotificationsEnabled() {
        return notificationsEnabled;
    }

    public void setNotificationsEnabled(boolean enabled) {
        notificationsEnabled = enabled;
    }

    public boolean isSoundEnabled() {
        return soundEnabled;
    }

    public void setSoundEnabled(boolean enabled) {
        soundEnabled = enabled;
    }

    public boolean isStudyRemindersEnabled() {
        return studyRemindersEnabled;
    }

    public void setStudyRemindersEnabled(boolean enabled) {
        studyRemindersEnabled = enabled;
    }

    public String getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(String studyTime) {
        this.studyTime = studyTime;
    }
}
