package com.josephmarchand.englishjoe.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class DateTimeUtils {

    private DateTimeUtils() {
    }

    public static String today() {
        return formatDate(System.currentTimeMillis());
    }

    public static String formatDate(long timestamp) {
        return new SimpleDateFormat(
                "dd/MM/yyyy",
                Locale.getDefault()
        ).format(new Date(timestamp));
    }

    public static String formatTime(long timestamp) {
        return new SimpleDateFormat(
                "HH:mm",
                Locale.getDefault()
        ).format(new Date(timestamp));
    }

    public static String formatDateTime(long timestamp) {
        return new SimpleDateFormat(
                "dd/MM/yyyy HH:mm",
                Locale.getDefault()
        ).format(new Date(timestamp));
    }

    public static boolean isSameDay(long first, long second) {
        SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyy-MM-dd",
                Locale.US
        );

        return formatter.format(new Date(first))
                .equals(formatter.format(new Date(second)));
    }

    public static long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }

    public static long getElapsedSeconds(long start, long end) {
        if (end < start) {
            return 0;
        }

        return (end - start) / 1000;
    }
}
