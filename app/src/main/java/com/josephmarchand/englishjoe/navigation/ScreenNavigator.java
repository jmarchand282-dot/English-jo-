package com.josephmarchand.englishjoe.navigation;

import android.content.Context;

public interface ScreenNavigator {

    void open(ScreenType screen);

    void open(ScreenType screen, Object data);

    void goBack();

    ScreenType getCurrentScreen();

    Context getContext();
}
