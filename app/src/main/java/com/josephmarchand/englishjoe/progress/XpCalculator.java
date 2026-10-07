package com.josephmarchand.englishjoe.progress;

public class XpCalculator {

    private XpCalculator() {
    }

    public static int lessonXp(int correctAnswers, int totalQuestions) {

        if (totalQuestions <= 0 || correctAnswers <= 0) {
            return 0;
        }

        int safeCorrect = Math.min(
                correctAnswers,
                totalQuestions
        );

        int baseXp = safeCorrect * 5;

        if (safeCorrect == totalQuestions) {
            baseXp += 10;
        }

        return baseXp;
    }

    public static int challengeXp() {
        return 20;
    }

    public static int perfectBonus() {
        return 10;
    }

    public static int streakBonus(int streakDays) {

        if (streakDays <= 0) {
            return 0;
        }

        return Math.min(
                streakDays * 2,
                50
        );
    }
}
