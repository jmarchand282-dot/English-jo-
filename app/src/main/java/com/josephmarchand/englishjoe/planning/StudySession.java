package com.josephmarchand.englishjoe.planning;

public class StudySession {

    private final String id;
    private final String subject;
    private final long startTime;
    private final int plannedMinutes;
    private int completedMinutes;

    public StudySession(
            String id,
            String subject,
            long startTime,
            int plannedMinutes) {

        this.id = id == null ? "" : id;
        this.subject = subject == null ? "" : subject;
        this.startTime = startTime;
        this.plannedMinutes = Math.max(1, plannedMinutes);
        this.completedMinutes = 0;
    }

    public String getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public long getStartTime() {
        return startTime;
    }

    public int getPlannedMinutes() {
        return plannedMinutes;
    }

    public int getCompletedMinutes() {
        return completedMinutes;
    }

    public void addCompletedMinutes(int minutes) {
        if (minutes > 0) {
            completedMinutes = Math.min(
                    plannedMinutes, completedMinutes + minutes);
        }
    }

    public boolean isCompleted() {
        return completedMinutes >= plannedMinutes;
    }

    public int getRemainingMinutes() {
        return Math.max(0, plannedMinutes - completedMinutes);
    }
}
