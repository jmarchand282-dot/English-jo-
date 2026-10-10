package com.josephmarchand.englishjoe.lessons;

import java.util.List;

public class ExerciseStatistics {

    private final int total;
    private final int correct;
    private final int mistakes;
    private final int xp;

    public ExerciseStatistics(List<ExerciseResult> results) {
        int totalCount = 0;
        int correctCount = 0;
        int mistakeCount = 0;
        int totalXp = 0;

        if (results != null) {
            for (ExerciseResult result : results) {
                if (result == null) continue;

                totalCount++;

                if (result.isCorrect()) {
                    correctCount++;
                } else {
                    mistakeCount++;
                }

                totalXp += result.getXpEarned();
            }
        }

        total = totalCount;
        correct = correctCount;
        mistakes = mistakeCount;
        xp = totalXp;
    }

    public int getTotal() {
        return total;
    }

    public int getCorrect() {
        return correct;
    }

    public int getMistakes() {
        return mistakes;
    }

    public int getXp() {
        return xp;
    }

    public int getAccuracyPercentage() {
        return total == 0 ? 0 : correct * 100 / total;
    }
}
