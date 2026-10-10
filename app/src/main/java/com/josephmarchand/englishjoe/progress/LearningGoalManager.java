package com.josephmarchand.englishjoe.progress;

import android.content.Context;
import java.util.List;

public class LearningGoalManager {

    private final LearningGoalStorage storage;

    public LearningGoalManager(Context context) {
        storage = new LearningGoalStorage(context);
    }

    public synchronized void addGoal(LearningGoal goal) {
        if (goal == null || goal.getId().trim().isEmpty()) return;

        List<LearningGoal> goals = storage.loadAll();

        for (LearningGoal existing : goals) {
            if (existing.getId().equals(goal.getId())) return;
        }

        goals.add(goal);
        storage.saveAll(goals);
    }

    public synchronized List<LearningGoal> getGoals() {
        return storage.loadAll();
    }

    public synchronized boolean addProgress(String id, int amount) {
        if (id == null) return false;

        List<LearningGoal> goals = storage.loadAll();

        for (LearningGoal goal : goals) {
            if (goal.getId().equals(id)) {
                goal.addProgress(amount);
                storage.saveAll(goals);
                return true;
            }
        }

        return false;
    }

    public synchronized boolean removeGoal(String id) {
        if (id == null) return false;

        List<LearningGoal> goals = storage.loadAll();
        boolean removed = goals.removeIf(
                goal -> goal.getId().equals(id));

        if (removed) storage.saveAll(goals);
        return removed;
    }

    public synchronized void clear() {
        storage.clear();
    }
}
