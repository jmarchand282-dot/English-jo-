package com.josephmarchand.englishjoe.progress;

public class LevelManager {

    private static final String[] LEVELS = {
            "A1",
            "A2",
            "B1",
            "B2",
            "C1",
            "C2"
    };

    private LevelManager() {
    }

    public static boolean isValidLevel(String level) {

        if (level == null) {
            return false;
        }

        for (String item : LEVELS) {

            if (item.equalsIgnoreCase(level)) {
                return true;
            }
        }

        return false;
    }

    public static String getNextLevel(String currentLevel) {

        if (currentLevel == null) {
            return "A1";
        }

        for (int i = 0; i < LEVELS.length; i++) {

            if (LEVELS[i].equalsIgnoreCase(currentLevel)) {

                if (i < LEVELS.length - 1) {
                    return LEVELS[i + 1];
                }

                return "C2";
            }
        }

        return "A1";
    }

    public static String getPreviousLevel(String currentLevel) {

        if (currentLevel == null) {
            return "A1";
        }

        for (int i = 0; i < LEVELS.length; i++) {

            if (LEVELS[i].equalsIgnoreCase(currentLevel)) {

                if (i > 0) {
                    return LEVELS[i - 1];
                }

                return "A1";
            }
        }

        return "A1";
    }

    public static int getLevelIndex(String level) {

        if (level == null) {
            return 0;
        }

        for (int i = 0; i < LEVELS.length; i++) {

            if (LEVELS[i].equalsIgnoreCase(level)) {
                return i;
            }
        }

        return 0;
    }

    public static String[] getAllLevels() {
        return LEVELS.clone();
    }
}
