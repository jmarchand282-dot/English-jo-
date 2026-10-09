package com.josephmarchand.englishjoe.lessons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExerciseHistory {

    private final List<ExerciseResult> history = new ArrayList<>();

    public void add(ExerciseResult result) {
        if (result != null) {
            history.add(result);
        }
    }

    public List<ExerciseResult> getAll() {
        return Collections.unmodifiableList(history);
    }

    public List<ExerciseResult> getMistakes() {
        List<ExerciseResult> mistakes = new ArrayList<>();

        for (ExerciseResult result : history) {
            if (!result.isCorrect()) {
                mistakes.add(result);
            }
        }

        return mistakes;
    }

    public int getCorrectCount() {
        int count = 0;

        for (ExerciseResult result : history) {
            if (result.isCorrect()) {
                count++;
            }
        }

        return count;
    }

    public int getTotalCount() {
        return history.size();
    }

    public void clear() {
        history.clear();
    }
}
