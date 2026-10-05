package com.josephmarchand.englishjoe.audio;

import android.content.Context;
import android.content.SharedPreferences;

public class AudioSettings {

    private static final String PREFS = "english_joe_audio";
    private static final String KEY_SOUND_ENABLED = "sound_enabled";

    private final SharedPreferences preferences;

    public AudioSettings(Context context) {

        preferences = context.getApplicationContext()
                .getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    public boolean isSoundEnabled() {
        return preferences.getBoolean(KEY_SOUND_ENABLED, true);
    }

    public void setSoundEnabled(boolean enabled) {

        preferences.edit()
                .putBoolean(KEY_SOUND_ENABLED, enabled)
                .apply();
    }

    public void reset() {

        preferences.edit()
                .clear()
                .apply();
    }
}
