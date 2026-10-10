package com.josephmarchand.englishjoe.progress;

import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class LearningGoalStorage {

    private static final String PREFS = "english_joe_learning_goals";
    private static final String KEY_GOALS = "goals";

    private final SharedPreferences preferences;

    public LearningGoalStorage(Context context) {
        preferences = context.getApplicationContext()
                .getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    public synchronized void saveAll(List<LearningGoal> goals) {
        JSONArray array = new JSONArray();

        try {
            if (goals != null) {
                for (LearningGoal goal : goals) {
                    if (goal == null) continue;

                    JSONObject object = new JSONObject();
                    object.put("id", goal.getId());
                    object.put("title", goal.getTitle());
                    object.put("target", goal.getTarget());
                    object.put("current", goal.getCurrent());
                    array.put(object);
                }
            }

            preferences.edit()
                    .putString(KEY_GOALS, array.toString())
                    .apply();
        } catch (Exception ignored) {
        }
    }

    public synchronized List<LearningGoal> loadAll() {
        List<LearningGoal> goals = new ArrayList<>();

        try {
            JSONArray array = new JSONArray(
                    preferences.getString(KEY_GOALS, "[]"));

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);

                LearningGoal goal = new LearningGoal(
                        object.optString("id", ""),
                        object.optString("title", ""),
                        object.optInt("target", 1)
                );

                goal.setCurrent(object.optInt("current", 0));
                goals.add(goal);
            }
        } catch (Exception ignored) {
        }

        return goals;
    }

    public synchronized void clear() {
        preferences.edit().remove(KEY_GOALS).apply();
    }
  }
