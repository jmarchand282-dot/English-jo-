package com.josephmarchand.englishjoe.lessons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LessonHistory {

    private final List<LessonAnswer> answers = new ArrayList<>();

    public void add(LessonAnswer answer) {
        if (answer != null) {
            answers.add(answer);
        }
    }

    public List<LessonAnswer> getAll() {
        return Collections.unmodifiableList(answers);
    }

    public List<LessonAnswer> getIncorrectAnswers() {
        List<LessonAnswer> result = new ArrayList<>();

        for (LessonAnswer answer : answers) {
            if (!answer.isCorrect()) {
                result.add(answer);
            }
        }

        return result;
    }

    public int getCorrectCount() {
        int count = 0;

        for (LessonAnswer answer : answers) {
            if (answer.isCorrect()) {
                count++;
            }
        }

        return count;
    }

    public int getIncorrectCount() {
        return answers.size() - getCorrectCount();
    }

    public int size() {
        return answers.size();
    }

    public void clear() {
        answers.clear();
    }
}
