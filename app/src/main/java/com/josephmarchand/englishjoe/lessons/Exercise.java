package com.josephmarchand.englishjoe.lessons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise {

    private final String id;
    private final ExerciseType type;
    private final String question;
    private final String correctAnswer;
    private final String explanation;
    private final List<String> choices;
    private final int xpReward;

    public Exercise(
            String id,
            ExerciseType type,
            String question,
            String correctAnswer,
            String explanation,
            List<String> choices,
            int xpReward) {

        this.id = id == null ? "" : id;
        this.type = type == null
                ? ExerciseType.MULTIPLE_CHOICE : type;
        this.question = question == null ? "" : question;
        this.correctAnswer = correctAnswer == null
                ? "" : correctAnswer.trim();
        this.explanation = explanation == null ? "" : explanation;
        this.choices = choices == null
                ? new ArrayList<>()
                : new ArrayList<>(choices);
        this.xpReward = Math.max(0, xpReward);
    }

    public String getId() {
        return id;
    }

    public ExerciseType getType() {
        return type;
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

    public List<String> getChoices() {
        return Collections.unmodifiableList(choices);
    }

    public int getXpReward() {
        return xpReward;
    }

    public boolean isCorrect(String answer) {
        return answer != null
                && correctAnswer.equalsIgnoreCase(answer.trim());
    }
}
