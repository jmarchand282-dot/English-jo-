package com.josephmarchand.englishjoe.lessons;

public class LessonAnswer {

    private final String lessonId;
    private final String question;
    private final String selectedAnswer;
    private final String correctAnswer;
    private final boolean correct;
    private final String explanation;

    public LessonAnswer(
            String lessonId,
            String question,
            String selectedAnswer,
            String correctAnswer,
            boolean correct,
            String explanation
    ) {
        this.lessonId = lessonId == null ? "" : lessonId;
        this.question = question == null ? "" : question;
        this.selectedAnswer = selectedAnswer == null ? "" : selectedAnswer;
        this.correctAnswer = correctAnswer == null ? "" : correctAnswer;
        this.correct = correct;
        this.explanation = explanation == null ? "" : explanation;
    }

    public String getLessonId() {
        return lessonId;
    }

    public String getQuestion() {
        return question;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public String getExplanation() {
        return explanation;
    }
}
