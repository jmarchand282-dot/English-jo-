package com.josephmarchand.englishjoe.profile;

import android.content.Context;
import android.content.SharedPreferences;

public class ProfilePhotoManager {

    private static final String PREFS = "english_joe_profile";
    private static final String KEY_PHOTO_URI = "photo_uri";

    private final SharedPreferences preferences;

    public ProfilePhotoManager(Context context) {
        preferences = context.getApplicationContext()
                .getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    public void savePhotoUri(String uri) {
        preferences.edit()
                .putString(KEY_PHOTO_URI, uri)
                .apply();
    }

    public String getPhotoUri() {
        return preferences.getString(KEY_PHOTO_URI, "");
    }

    public boolean hasPhoto() {
        String uri = getPhotoUri();
        return uri != null && !uri.isEmpty();
    }

    public void removePhoto() {
        preferences.edit()
                .remove(KEY_PHOTO_URI)
                .apply();
    }
}
