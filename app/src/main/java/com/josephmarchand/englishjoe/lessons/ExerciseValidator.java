package com.josephmarchand.englishjoe.lessons;

public final class ExerciseValidator {

    private ExerciseValidator() {
    }

    public static boolean isValid(Exercise exercise) {
        return exercise != null
                && !exercise.getId().trim().isEmpty()
                && !exercise.getQuestion().trim().isEmpty()
                && !exercise.getCorrectAnswer().trim().isEmpty();
    }

    public static String validate(Exercise exercise) {
        if (exercise == null) {
            return "L'exercice est absent.";
        }
        if (exercise.getId().trim().isEmpty()) {
            return "L'identifiant de l'exercice est obligatoire.";
        }
        if (exercise.getQuestion().trim().isEmpty()) {
            return "La question est obligatoire.";
        }
        if (exercise.getCorrectAnswer().trim().isEmpty()) {
            return "La réponse correcte est obligatoire.";
        }
        return "";
    }
}
