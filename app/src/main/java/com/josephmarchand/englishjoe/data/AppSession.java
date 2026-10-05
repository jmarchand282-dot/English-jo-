package com.josephmarchand.englishjoe.data;

import android.content.Context;

public class AppSession {

    private static AppSession instance;

    private final Context context;

    private AppSession(Context context) {
        this.context = context.getApplicationContext();
    }

    public static synchronized AppSession getInstance(Context context) {

        if (instance == null) {
            instance = new AppSession(context);
        }

        return instance;
    }

    public Context getContext() {
        return context;
    }

    public AppData getAppData() {
        return new AppData(context);
    }

    public NotificationSettings getNotificationSettings() {
        return new NotificationSettings(context);
    }

    public ProfileStorage getProfileStorage() {
        return new ProfileStorage(context);
    }
}
