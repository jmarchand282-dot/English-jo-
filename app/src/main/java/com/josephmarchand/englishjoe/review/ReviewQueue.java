package com.josephmarchand.englishjoe.review;

import com.josephmarchand.englishjoe.lessons.LessonAnswer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReviewQueue {

    private final List<LessonAnswer> queue = new ArrayList<>();

    public synchronized void add(LessonAnswer answer) {
        if (answer == null || answer.isCorrect()) {
            return;
        }

        queue.add(answer);
    }

    public synchronized LessonAnswer next() {
        if (queue.isEmpty()) {
            return null;
        }

        return queue.get(0);
    }

    public synchronized LessonAnswer removeNext() {
        if (queue.isEmpty()) {
            return null;
        }

        return queue.remove(0);
    }

    public synchronized boolean remove(LessonAnswer answer) {
        return queue.remove(answer);
    }

    public synchronized List<LessonAnswer> getAll() {
        return Collections.unmodifiableList(
                new ArrayList<>(queue)
        );
    }

    public synchronized int size() {
        return queue.size();
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }

    public synchronized void clear() {
        queue.clear();
    }
}
