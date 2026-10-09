package com.josephmarchand.englishjoe.navigation;

import com.josephmarchand.englishjoe.onboarding.OnboardingManager;

public final class NavigationGuard {

    private NavigationGuard() {
    }

    public static boolean canOpen(
            ScreenType destination,
            OnboardingManager onboardingManager
    ) {
        if (destination == null) {
            return false;
        }

        if (destination == ScreenType.WELCOME
                || destination == ScreenType.LANGUAGE
                || destination == ScreenType.PROFILE
                || destination == ScreenType.PLACEMENT) {
            return true;
        }

        return onboardingManager != null
                && onboardingManager.isCompleted();
    }

    public static ScreenType getRequiredScreen(
            OnboardingManager onboardingManager
    ) {
        if (onboardingManager == null
                || !onboardingManager.isCompleted()) {
            return ScreenType.WELCOME;
        }

        return ScreenType.HOME;
    }
}
