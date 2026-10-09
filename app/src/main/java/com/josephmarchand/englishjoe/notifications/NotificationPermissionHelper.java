package com.josephmarchand.englishjoe.notifications;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

public final class NotificationPermissionHelper {

    private NotificationPermissionHelper() {
    }

    public static boolean isPermissionRequired() {
        return Build.VERSION.SDK_INT >= 33;
    }

    public static boolean hasPermission(Context context) {
        if (context == null) {
            return false;
        }

        if (Build.VERSION.SDK_INT < 33) {
            return true;
        }

        return context.checkSelfPermission(
                Manifest.permission.POST_NOTIFICATIONS
        ) == PackageManager.PERMISSION_GRANTED;
    }

    public static String getPermissionName() {
        return Manifest.permission.POST_NOTIFICATIONS;
    }
}
