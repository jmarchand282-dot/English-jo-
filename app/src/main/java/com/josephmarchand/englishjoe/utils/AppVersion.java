package com.josephmarchand.englishjoe.utils;

public final class AppVersion {

    public static final String NAME = "English joe";
    public static final String VERSION = "1.0.0";
    public static final int VERSION_CODE = 1;
    public static final String CREATOR = "Joseph Marchand";
    public static final String PACKAGE_NAME =
            "com.josephmarchand.englishjoe";

    private AppVersion() {
    }

    public static String getDisplayVersion() {
        return NAME + " v" + VERSION;
    }

    public static String getCredits() {
        return "Créé par " + CREATOR;
    }
}
