package com.josephmarchand.englishjoe.onboarding;

import android.content.Context;
import android.content.SharedPreferences;

public class OnboardingManager {

    private static final String PREFS_NAME = "english_joe_onboarding";

    private static final String KEY_FIRST_NAME = "first_name";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_SOURCE_LANGUAGE = "source_language";
    private static final String KEY_TARGET_LANGUAGE = "target_language";
    private static final String KEY_LEVEL = "level";
    private static final String KEY_REASON = "reason";
    private static final String KEY_PLACEMENT_SCORE = "placement_score";
    private static final String KEY_COMPLETED = "completed";

    private final SharedPreferences preferences;

    public OnboardingManager(Context context) {
        preferences = context.getApplicationContext()
                .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void save(OnboardingData data) {
        if (data == null) {
            return;
        }

        preferences.edit()
                .putString(KEY_FIRST_NAME, data.getFirstName())
                .putString(KEY_USERNAME, data.getUsername())
                .putString(KEY_SOURCE_LANGUAGE, data.getSourceLanguage())
                .putString(KEY_TARGET_LANGUAGE, data.getTargetLanguage())
                .putString(KEY_LEVEL, data.getLevel())
                .putString(KEY_REASON, data.getReason())
                .putInt(KEY_PLACEMENT_SCORE, data.getPlacementScore())
                .putBoolean(KEY_COMPLETED, data.isCompleted())
                .apply();
    }

    public OnboardingData load() {
        OnboardingData data = new OnboardingData();

        data.setFirstName(preferences.getString(KEY_FIRST_NAME, ""));
        data.setUsername(preferences.getString(KEY_USERNAME, ""));
        data.setSourceLanguage(
                preferences.getString(KEY_SOURCE_LANGUAGE, "French")
        );
        data.setTargetLanguage(
                preferences.getString(KEY_TARGET_LANGUAGE, "English")
        );
        data.setLevel(
                preferences.getString(KEY_LEVEL, "A1")
        );
        data.setReason(
                preferences.getString(KEY_REASON, "")
        );
        data.setPlacementScore(
                preferences.getInt(KEY_PLACEMENT_SCORE, 0)
        );
        data.setCompleted(
                preferences.getBoolean(KEY_COMPLETED, false)
        );

        return data;
    }

    public boolean isCompleted() {
        return preferences.getBoolean(KEY_COMPLETED, false);
    }

    public void markCompleted() {
        preferences.edit()
                .putBoolean(KEY_COMPLETED, true)
                .apply();
    }

    public void reset() {
        preferences.edit().clear().apply();
    }
          }
