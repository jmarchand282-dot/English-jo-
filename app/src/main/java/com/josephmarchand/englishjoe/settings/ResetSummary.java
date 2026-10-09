package com.josephmarchand.englishjoe.settings;

public class ResetSummary {

    private final boolean profileReset;
    private final boolean progressReset;
    private final boolean settingsReset;
    private final boolean coursesReset;

    public ResetSummary(
            boolean profileReset,
            boolean progressReset,
            boolean settingsReset,
            boolean coursesReset
    ) {
        this.profileReset = profileReset;
        this.progressReset = progressReset;
        this.settingsReset = settingsReset;
        this.coursesReset = coursesReset;
    }

    public boolean isProfileReset() {
        return profileReset;
    }

    public boolean isProgressReset() {
        return progressReset;
    }

    public boolean isSettingsReset() {
        return settingsReset;
    }

    public boolean isCoursesReset() {
        return coursesReset;
    }

    public boolean isEverythingReset() {
        return profileReset
                && progressReset
                && settingsReset
                && coursesReset;
    }
}
