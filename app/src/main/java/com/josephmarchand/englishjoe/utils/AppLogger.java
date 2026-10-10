package com.josephmarchand.englishjoe.utils;

import android.util.Log;

public final class AppLogger {

    private static final String TAG = "EnglishJoe";

    private AppLogger() {
    }

    public static void debug(String message) {
        Log.d(TAG, safe(message));
    }

    public static void info(String message) {
        Log.i(TAG, safe(message));
    }

    public static void warning(String message) {
        Log.w(TAG, safe(message));
    }

    public static void error(String message) {
        Log.e(TAG, safe(message));
    }

    public static void error(String message, Throwable error) {
        Log.e(TAG, safe(message), error);
    }

    private static String safe(String message) {
        return message == null ? "" : message;
    }
}
