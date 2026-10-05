package com.josephmarchand.englishjoe;

import android.app.Application;

public class JoEnglishApplication extends Application {

    private static JoEnglishApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }

    public static JoEnglishApplication getInstance() {
        return instance;
    }
}
