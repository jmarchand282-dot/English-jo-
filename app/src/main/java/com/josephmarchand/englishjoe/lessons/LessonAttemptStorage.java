package com.josephmarchand.englishjoe.lessons;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LessonAttemptStorage {

    private static final String PREFS = "english_joe_attempts";
    private static final String KEY_ATTEMPTS = "attempts";

    private final SharedPreferences preferences;

    public LessonAttemptStorage(Context context) {
        preferences = context.getApplicationContext()
                .getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    public synchronized void save(LessonAttempt attempt) {
        if (attempt == null || attempt.getLessonId().trim().isEmpty()) {
            return;
        }

        List<LessonAttempt> attempts = loadAll();
        attempts.add(attempt);

        JSONArray array = new JSONArray();

        for (LessonAttempt item : attempts) {
            JSONObject object = new JSONObject();

            try {
                object.put("lessonId", item.getLessonId());
                object.put("score", item.getScorePercent());
                object.put("xp", item.getXpEarned());
                object.put("completedAt", item.getCompletedAt());
                object.put("passed", item.isPassed());

                array.put(object);
            } catch (JSONException ignored) {
                // Une entrée invalide ne doit pas bloquer les autres.
            }
        }

        preferences.edit()
                .putString(KEY_ATTEMPTS, array.toString())
                .apply();
    }

    public synchronized List<LessonAttempt> loadAll() {
        List<LessonAttempt> result = new ArrayList<>();

        String saved = preferences.getString(KEY_ATTEMPTS, "[]");

        try {
            JSONArray array = new JSONArray(saved);

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.optJSONObject(i);

                if (object == null) {
                    continue;
                }

                String lessonId = object.optString("lessonId", "");

                if (lessonId.trim().isEmpty()) {
                    continue;
                }

                result.add(new LessonAttempt(
                        lessonId,
                        object.optInt("score", 0),
                        object.optInt("xp", 0),
                        object.optLong("completedAt", 0),
                        object.optBoolean("passed", false)
                ));
            }
        } catch (JSONException ignored) {
            // Retourne une liste vide si les données sont illisibles.
        }

        return Collections.unmodifiableList(result);
    }

    public synchronized int getAttemptCount() {
        return loadAll().size();
    }

    public synchronized void clear() {
        preferences.edit()
                .remove(KEY_ATTEMPTS)
                .apply();
    }
        }
