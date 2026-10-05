package com.josephmarchand.englishjoe.models;

public class Question {

    private String questionText;
    private String[] options;
    private int correctAnswer;
    private String explanation;

    public Question(
            String questionText,
            String[] options,
            int correctAnswer,
            String explanation
    ) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.explanation = explanation;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public String getExplanation() {
        return explanation;
    }

    public boolean isCorrect(int answer) {
        return answer == correctAnswer;
    }
}
