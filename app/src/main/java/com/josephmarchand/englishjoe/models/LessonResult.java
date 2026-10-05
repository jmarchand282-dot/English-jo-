package com.josephmarchand.englishjoe.models;

public class LessonResult {

    private final int totalQuestions;
    private final int correctAnswers;
    private final int earnedXp;

    public LessonResult(
            int totalQuestions,
            int correctAnswers,
            int earnedXp
    ) {
        this.totalQuestions = Math.max(0, totalQuestions);
        this.correctAnswers = Math.max(0, correctAnswers);
        this.earnedXp = Math.max(0, earnedXp);
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getWrongAnswers() {
        return Math.max(
                0,
                totalQuestions - correctAnswers
        );
    }

    public int getEarnedXp() {
        return earnedXp;
    }

    public int getScorePercent() {

        if (totalQuestions == 0) {
            return 0;
        }

        return Math.min(
                100,
                (correctAnswers * 100) / totalQuestions
        );
    }

    public boolean passed() {
        return getScorePercent() >= 70;
    }
}
