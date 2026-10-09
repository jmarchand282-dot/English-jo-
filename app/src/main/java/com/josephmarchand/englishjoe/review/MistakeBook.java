package com.josephmarchand.englishjoe.review;

import com.josephmarchand.englishjoe.lessons.LessonAnswer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MistakeBook {

    private final List<LessonAnswer> mistakes = new ArrayList<>();

    public void record(LessonAnswer answer) {
        if (answer != null && !answer.isCorrect()) {
            mistakes.add(answer);
        }
    }

    public List<LessonAnswer> getMistakes() {
        return Collections.unmodifiableList(mistakes);
    }

    public int getCount() {
        return mistakes.size();
    }

    public boolean hasMistakes() {
        return !mistakes.isEmpty();
    }

    public void remove(LessonAnswer answer) {
        mistakes.remove(answer);
    }

    public void clear() {
        mistakes.clear();
    }
}
