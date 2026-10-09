package com.josephmarchand.englishjoe.lessons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExerciseBank {

    private final List<Exercise> exercises = new ArrayList<>();

    public ExerciseBank() {
        loadStarterExercises();
    }

    private void loadStarterExercises() {
        exercises.add(ExerciseFactory.createMultipleChoice(
                "a1-greeting-001",
                "What does 'Hello' mean in French?",
                "Bonjour",
                "'Hello' is a common English greeting.",
                java.util.Arrays.asList(
                        "Bonjour", "Au revoir", "Merci", "Bonne nuit"
                )
        ));

        exercises.add(ExerciseFactory.createMultipleChoice(
                "a1-introduction-001",
                "Complete: My name ___ Anna.",
                "is",
                "Use 'is' with he, she, it, and a singular name.",
                java.util.Arrays.asList("am", "is", "are", "be")
        ));

        exercises.add(ExerciseFactory.createTranslation(
                "a1-basic-001",
                "Translate into English: Merci.",
                "Thank you",
                "'Thank you' means 'merci' in French."
        ));

        exercises.add(ExerciseFactory.createMultipleChoice(
                "a1-numbers-001",
                "Which word means 'trois'?",
                "Three",
                "'Three' is the English word for 'trois'.",
                java.util.Arrays.asList("Two", "Three", "Four", "Five")
        ));

        exercises.add(ExerciseFactory.createMultipleChoice(
                "a1-family-001",
                "What does 'mother' mean in French?",
                "Mère",
                "'Mother' means 'mère'.",
                java.util.Arrays.asList(
                        "Père", "Sœur", "Mère", "Frère"
                )
        ));
    }

    public List<Exercise> getAll() {
        return Collections.unmodifiableList(exercises);
    }

    public Exercise findById(String id) {
        if (id == null) return null;

        for (Exercise exercise : exercises) {
            if (id.equals(exercise.getId())) {
                return exercise;
            }
        }
        return null;
    }

    public int size() {
        return exercises.size();
    }

    public void add(Exercise exercise) {
        if (ExerciseValidator.isValid(exercise)
                && findById(exercise.getId()) == null) {
            exercises.add(exercise);
        }
    }
}
