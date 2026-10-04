package com.josephmarchand.englishjoe.profile;

import android.content.Context;

import com.josephmarchand.englishjoe.data.AppData;
import com.josephmarchand.englishjoe.data.UserProfile;

public class ProfileManager {

    private final AppData appData;

    public ProfileManager(Context context) {
        appData = new AppData(context);
    }

    public UserProfile loadProfile() {

        UserProfile profile = new UserProfile();

        profile.setFirstName(appData.getFirstName());
        profile.setUsername(appData.getUsername());
        profile.setLevel(appData.getLevel());
        profile.setTargetLanguage("English");

        return profile;
    }

    public void saveProfile(UserProfile profile) {

        if (profile == null) {
            return;
        }

        appData.setFirstName(profile.getFirstName());
        appData.setUsername(profile.getUsername());
        appData.setLevel(profile.getLevel());
    }

    public boolean hasProfile() {
        return !appData.getFirstName().trim().isEmpty();
    }
}
