package com.josephmarchand.englishjoe.lessons;

public class ExerciseResult {

    private final String exerciseId;
    private final String submittedAnswer;
    private final String correctAnswer;
    private final boolean correct;
    private final int xpEarned;
    private final long answeredAt;

    public ExerciseResult(
            String exerciseId,
            String submittedAnswer,
            String correctAnswer,
            boolean correct,
            int xpEarned,
            long answeredAt) {

        this.exerciseId = exerciseId == null ? "" : exerciseId;
        this.submittedAnswer = submittedAnswer == null
                ? "" : submittedAnswer;
        this.correctAnswer = correctAnswer == null
                ? "" : correctAnswer;
        this.correct = correct;
        this.xpEarned = Math.max(0, xpEarned);
        this.answeredAt = answeredAt;
    }

    public String getExerciseId() {
        return exerciseId;
    }

    public String getSubmittedAnswer() {
        return submittedAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public int getXpEarned() {
        return xpEarned;
    }

    public long getAnsweredAt() {
        return answeredAt;
    }
}
