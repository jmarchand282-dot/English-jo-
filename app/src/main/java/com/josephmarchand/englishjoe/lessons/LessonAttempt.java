package com.josephmarchand.englishjoe.lessons;

public class LessonAttempt {

    private final String lessonId;
    private final int scorePercent;
    private final int xpEarned;
    private final long completedAt;
    private final boolean passed;

    public LessonAttempt(
            String lessonId,
            int scorePercent,
            int xpEarned,
            long completedAt,
            boolean passed
    ) {
        this.lessonId = lessonId == null ? "" : lessonId;
        this.scorePercent = Math.max(0, Math.min(100, scorePercent));
        this.xpEarned = Math.max(0, xpEarned);
        this.completedAt = Math.max(0, completedAt);
        this.passed = passed;
    }

    public String getLessonId() {
        return lessonId;
    }

    public int getScorePercent() {
        return scorePercent;
    }

    public int getXpEarned() {
        return xpEarned;
    }

    public long getCompletedAt() {
        return completedAt;
    }

    public boolean isPassed() {
        return passed;
    }
}
