package com.josephmarchand.englishjoe.lessons;

public class AnswerResult {

    private final boolean correct;
    private final String selectedAnswer;
    private final String correctAnswer;
    private final String explanation;
    private final int xpEarned;

    public AnswerResult(
            boolean correct,
            String selectedAnswer,
            String correctAnswer,
            String explanation,
            int xpEarned
    ) {
        this.correct = correct;
        this.selectedAnswer = selectedAnswer == null ? "" : selectedAnswer;
        this.correctAnswer = correctAnswer == null ? "" : correctAnswer;
        this.explanation = explanation == null ? "" : explanation;
        this.xpEarned = Math.max(0, xpEarned);
    }

    public boolean isCorrect() {
        return correct;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getExplanation() {
        return explanation;
    }

    public int getXpEarned() {
        return xpEarned;
    }
}
