package com.josephmarchand.englishjoe.lessons;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ExerciseFactory {

    private ExerciseFactory() {
    }

    public static Exercise createMultipleChoice(
            String id,
            String question,
            String correctAnswer,
            String explanation,
            List<String> choices) {

        return new Exercise(
                id,
                ExerciseType.MULTIPLE_CHOICE,
                question,
                correctAnswer,
                explanation,
                choices,
                10
        );
    }

    public static Exercise createTranslation(
            String id,
            String question,
            String correctAnswer,
            String explanation) {

        return new Exercise(
                id,
                ExerciseType.TRANSLATION,
                question,
                correctAnswer,
                explanation,
                Collections.emptyList(),
                15
        );
    }

    public static Exercise createListening(
            String id,
            String question,
            String correctAnswer,
            String explanation,
            String... choices) {

        return new Exercise(
                id,
                ExerciseType.LISTENING,
                question,
                correctAnswer,
                explanation,
                Arrays.asList(choices),
                15
        );
    }
}
