package com.josephmarchand.englishjoe.navigation;

import android.content.Context;

public class NavigationManager implements ScreenNavigator {

    public interface ScreenRenderer {
        void render(ScreenType screen, Object data);
    }

    private final Context context;
    private final ScreenRenderer renderer;
    private final NavigationHistory history;

    private ScreenType currentScreen;
    private NavigationEvent lastEvent;

    public NavigationManager(
            Context context,
            ScreenRenderer renderer,
            ScreenType initialScreen
    ) {
        if (context == null || renderer == null) {
            throw new IllegalArgumentException(
                    "Le contexte et le moteur d'affichage sont obligatoires."
            );
        }

        this.context = context.getApplicationContext();
        this.renderer = renderer;
        this.history = new NavigationHistory();
        this.currentScreen = initialScreen;
    }

    @Override
    public void open(ScreenType screen) {
        open(screen, null);
    }

    @Override
    public void open(ScreenType screen, Object data) {
        if (screen == null) {
            return;
        }

        if (currentScreen != null && currentScreen != screen) {
            history.push(currentScreen);
        }

        currentScreen = screen;
        lastEvent = new NavigationEvent(screen, data);
        renderer.render(screen, data);
    }

    @Override
    public void goBack() {
        ScreenType previous = history.pop();

        if (previous != null) {
            currentScreen = previous;
            lastEvent = new NavigationEvent(previous, null);
            renderer.render(previous, null);
        }
    }

    @Override
    public ScreenType getCurrentScreen() {
        return currentScreen;
    }

    @Override
    public Context getContext() {
        return context;
    }

    public NavigationEvent getLastEvent() {
        return lastEvent;
    }

    public boolean canGoBack() {
        return history.canGoBack();
    }

    public void clearHistory() {
        history.clear();
    }
}
