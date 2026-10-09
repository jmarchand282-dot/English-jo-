package com.josephmarchand.englishjoe.planning;

public class StudyPlan {

    private int dailyMinutes;
    private int weeklyDays;
    private String preferredTime;
    private boolean remindersEnabled;

    public StudyPlan() {
        dailyMinutes = 20;
        weeklyDays = 5;
        preferredTime = "18:00";
        remindersEnabled = true;
    }

    public int getDailyMinutes() {
        return dailyMinutes;
    }

    public void setDailyMinutes(int minutes) {
        dailyMinutes = Math.max(5, Math.min(240, minutes));
    }

    public int getWeeklyDays() {
        return weeklyDays;
    }

    public void setWeeklyDays(int days) {
        weeklyDays = Math.max(1, Math.min(7, days));
    }

    public String getPreferredTime() {
        return preferredTime;
    }

    public void setPreferredTime(String time) {
        if (time != null && time.matches("^([01]\\d|2[0-3]):[0-5]\\d$")) {
            preferredTime = time;
        }
    }

    public boolean isRemindersEnabled() {
        return remindersEnabled;
    }

    public void setRemindersEnabled(boolean enabled) {
        remindersEnabled = enabled;
    }

    public int getWeeklyMinutesTarget() {
        return dailyMinutes * weeklyDays;
    }
}
