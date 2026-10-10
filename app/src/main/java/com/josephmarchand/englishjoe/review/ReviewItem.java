package com.josephmarchand.englishjoe.review;

public class ReviewItem {

    private final String id;
    private final String question;
    private final String correctAnswer;
    private final String explanation;
    private final long createdAt;

    public ReviewItem(
            String id,
            String question,
            String correctAnswer,
            String explanation,
            long createdAt) {

        this.id = id == null ? "" : id;
        this.question = question == null ? "" : question;
        this.correctAnswer = correctAnswer == null ? "" : correctAnswer;
        this.explanation = explanation == null ? "" : explanation;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getExplanation() {
        return explanation;
    }

    public long getCreatedAt() {
        return createdAt;
    }
}
