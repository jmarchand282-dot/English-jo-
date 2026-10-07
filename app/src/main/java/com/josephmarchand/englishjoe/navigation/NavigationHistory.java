package com.josephmarchand.englishjoe.navigation;

import java.util.ArrayDeque;
import java.util.Deque;

public class NavigationHistory {

    private final Deque<ScreenType> history = new ArrayDeque<>();

    public void push(ScreenType screen) {
        if (screen == null) {
            return;
        }

        history.push(screen);
    }

    public ScreenType pop() {
        if (history.isEmpty()) {
            return null;
        }

        return history.pop();
    }

    public ScreenType peek() {
        if (history.isEmpty()) {
            return null;
        }

        return history.peek();
    }

    public boolean canGoBack() {
        return !history.isEmpty();
    }

    public void clear() {
        history.clear();
    }

    public int size() {
        return history.size();
    }
}
