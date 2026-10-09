package com.josephmarchand.englishjoe.lessons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExerciseSession {

    private final List<Exercise> exercises;
    private final List<ExerciseResult> results = new ArrayList<>();
    private int currentIndex = 0;
    private boolean finished = false;

    public ExerciseSession(List<Exercise> exercises) {
        this.exercises = exercises == null
                ? new ArrayList<>()
                : new ArrayList<>(exercises);

        if (this.exercises.isEmpty()) {
            finished = true;
        }
    }

    public Exercise getCurrentExercise() {
        if (finished || currentIndex >= exercises.size()) {
            return null;
        }
        return exercises.get(currentIndex);
    }

    public ExerciseResult submitAnswer(String answer) {
        Exercise exercise = getCurrentExercise();

        if (exercise == null) {
            return null;
        }

        boolean correct = exercise.isCorrect(answer);
        int xp = correct ? exercise.getXpReward() : 0;

        ExerciseResult result = new ExerciseResult(
                exercise.getId(),
                answer,
                exercise.getCorrectAnswer(),
                correct,
                xp,
                System.currentTimeMillis()
        );

        results.add(result);
        currentIndex++;

        if (currentIndex >= exercises.size()) {
            finished = true;
        }

        return result;
    }

    public boolean hasNext() {
        return !finished && currentIndex < exercises.size();
    }

    public boolean isFinished() {
        return finished;
    }

    public int getCurrentNumber() {
        return Math.min(currentIndex + 1, exercises.size());
    }

    public int getTotalExercises() {
        return exercises.size();
    }

    public int getCorrectCount() {
        int count = 0;
        for (ExerciseResult result : results) {
            if (result.isCorrect()) count++;
        }
        return count;
    }

    public int getTotalXp() {
        int total = 0;
        for (ExerciseResult result : results) {
            total += result.getXpEarned();
        }
        return total;
    }

    public List<ExerciseResult> getResults() {
        return Collections.unmodifiableList(results);
    }

    public void reset() {
        currentIndex = 0;
        finished = exercises.isEmpty();
        results.clear();
    }
  }
