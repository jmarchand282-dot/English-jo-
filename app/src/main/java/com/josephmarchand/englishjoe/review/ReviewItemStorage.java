package com.josephmarchand.englishjoe.review;

import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReviewItemStorage {

    private static final String PREFS = "english_joe_review_items";
    private static final String KEY_ITEMS = "items";

    private final SharedPreferences preferences;

    public ReviewItemStorage(Context context) {
        preferences = context.getApplicationContext()
                .getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    public synchronized void add(ReviewItem item) {
        if (item == null || item.getId().trim().isEmpty()) return;

        List<ReviewItem> items = new ArrayList<>(getAll());

        for (ReviewItem existing : items) {
            if (existing.getId().equals(item.getId())) return;
        }

        items.add(item);
        saveAll(items);
    }

    public synchronized List<ReviewItem> getAll() {
        List<ReviewItem> items = new ArrayList<>();

        try {
            JSONArray array = new JSONArray(
                    preferences.getString(KEY_ITEMS, "[]"));

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);

                items.add(new ReviewItem(
                        object.optString("id", ""),
                        object.optString("question", ""),
                        object.optString("answer", ""),
                        object.optString("explanation", ""),
                        object.optLong("createdAt", 0)
                ));
            }
        } catch (Exception ignored) {
        }

        return Collections.unmodifiableList(items);
    }

    public synchronized void remove(String id) {
        if (id == null) return;

        List<ReviewItem> items = new ArrayList<>(getAll());
        items.removeIf(item -> item.getId().equals(id));
        saveAll(items);
    }

    public synchronized void clear() {
        preferences.edit().remove(KEY_ITEMS).apply();
    }

    private void saveAll(List<ReviewItem> items) {
        JSONArray array = new JSONArray();

        try {
            for (ReviewItem item : items) {
                JSONObject object = new JSONObject();
                object.put("id", item.getId());
                object.put("question", item.getQuestion());
                object.put("answer", item.getCorrectAnswer());
                object.put("explanation", item.getExplanation());
                object.put("createdAt", item.getCreatedAt());
                array.put(object);
            }

            preferences.edit()
                    .putString(KEY_ITEMS, array.toString())
                    .apply();
        } catch (Exception ignored) {
        }
    }
          }
