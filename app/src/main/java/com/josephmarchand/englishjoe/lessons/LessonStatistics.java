package com.josephmarchand.englishjoe.lessons;

public class LessonStatistics {

    private final String lessonId;
    private final int totalQuestions;
    private final int correctAnswers;
    private final int incorrectAnswers;
    private final int xpEarned;
    private final long durationMillis;

    public LessonStatistics(
            String lessonId,
            int totalQuestions,
            int correctAnswers,
            int incorrectAnswers,
            int xpEarned,
            long durationMillis
    ) {
        this.lessonId = lessonId == null ? "" : lessonId;
        this.totalQuestions = Math.max(0, totalQuestions);
        this.correctAnswers = Math.max(0, correctAnswers);
        this.incorrectAnswers = Math.max(0, incorrectAnswers);
        this.xpEarned = Math.max(0, xpEarned);
        this.durationMillis = Math.max(0, durationMillis);
    }

    public String getLessonId() {
        return lessonId;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public int getXpEarned() {
        return xpEarned;
    }

    public long getDurationMillis() {
        return durationMillis;
    }

    public int getScorePercent() {
        if (totalQuestions == 0) {
            return 0;
        }

        return correctAnswers * 100 / totalQuestions;
    }

    public boolean isPassed() {
        return getScorePercent() >= 70;
    }
}
