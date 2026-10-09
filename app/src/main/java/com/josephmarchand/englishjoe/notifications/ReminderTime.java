package com.josephmarchand.englishjoe.notifications;

import java.util.Locale;

public class ReminderTime {

    private int hour;
    private int minute;

    public ReminderTime(int hour, int minute) {
        setTime(hour, minute);
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setTime(int hour, int minute) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Heure invalide.");
        }

        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Minute invalide.");
        }

        this.hour = hour;
        this.minute = minute;
    }

    public String format24Hour() {
        return String.format(Locale.US, "%02d:%02d", hour, minute);
    }

    public static ReminderTime parse(String value) {
        if (value == null || !value.matches("\\d{2}:\\d{2}")) {
            return new ReminderTime(18, 0);
        }

        try {
            String[] parts = value.split(":");
            return new ReminderTime(
                    Integer.parseInt(parts[0]),
                    Integer.parseInt(parts[1])
            );
        } catch (RuntimeException exception) {
            return new ReminderTime(18, 0);
        }
    }

    public boolean equalsTime(ReminderTime other) {
        return other != null
                && hour == other.hour
                && minute == other.minute;
    }
}
