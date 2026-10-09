package com.josephmarchand.englishjoe.progress;

import android.content.Context;
import android.content.SharedPreferences;

public class RewardManager {

    private static final String PREFS = "english_joe_rewards";

    private final SharedPreferences preferences;

    public RewardManager(Context context) {
        preferences = context.getApplicationContext()
                .getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    public boolean isUnlocked(String rewardId) {
        if (rewardId == null || rewardId.trim().isEmpty()) {
            return false;
        }

        return preferences.getBoolean(rewardId, false);
    }

    public boolean unlock(String rewardId) {
        if (rewardId == null || rewardId.trim().isEmpty()) {
            return false;
        }

        if (isUnlocked(rewardId)) {
            return false;
        }

        preferences.edit()
                .putBoolean(rewardId, true)
                .apply();

        return true;
    }

    public void lock(String rewardId) {
        if (rewardId != null) {
            preferences.edit()
                    .putBoolean(rewardId, false)
                    .apply();
        }
    }

    public void reset() {
        preferences.edit().clear().apply();
    }
}
