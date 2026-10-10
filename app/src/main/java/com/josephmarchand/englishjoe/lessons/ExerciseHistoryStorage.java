package com.josephmarchand.englishjoe.lessons;

import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExerciseHistoryStorage {

    private static final String PREFS = "english_joe_exercise_history";
    private static final String KEY_HISTORY = "history";

    private final SharedPreferences preferences;

    public ExerciseHistoryStorage(Context context) {
        preferences = context.getApplicationContext()
                .getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    public synchronized void save(ExerciseResult result) {
        if (result == null) return;

        List<ExerciseResult> history = getAll();
        history.add(result);
        JSONArray array = new JSONArray();

        try {
            for (ExerciseResult item : history) {
                JSONObject object = new JSONObject();
                object.put("id", item.getExerciseId());
                object.put("submitted", item.getSubmittedAnswer());
                object.put("correctAnswer", item.getCorrectAnswer());
                object.put("correct", item.isCorrect());
                object.put("xp", item.getXpEarned());
                object.put("time", item.getAnsweredAt());
                array.put(object);
            }

            preferences.edit()
                    .putString(KEY_HISTORY, array.toString())
                    .apply();
        } catch (Exception ignored) {
        }
    }

    public synchronized List<ExerciseResult> getAll() {
        List<ExerciseResult> results = new ArrayList<>();

        try {
            JSONArray array = new JSONArray(
                    preferences.getString(KEY_HISTORY, "[]"));

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);

                results.add(new ExerciseResult(
                        object.optString("id", ""),
                        object.optString("submitted", ""),
                        object.optString("correctAnswer", ""),
                        object.optBoolean("correct", false),
                        object.optInt("xp", 0),
                        object.optLong("time", 0)
                ));
            }
        } catch (Exception ignored) {
        }

        return Collections.unmodifiableList(results);
    }

    public synchronized List<ExerciseResult> getMistakes() {
        List<ExerciseResult> mistakes = new ArrayList<>();

        for (ExerciseResult result : getAll()) {
            if (!result.isCorrect()) mistakes.add(result);
        }

        return Collections.unmodifiableList(mistakes);
    }

    public synchronized int getTotalCount() {
        return getAll().size();
    }

    public synchronized void clear() {
        preferences.edit().remove(KEY_HISTORY).apply();
    }
    }
