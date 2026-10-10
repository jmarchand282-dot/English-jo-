package com.josephmarchand.englishjoe.progress;

import android.content.Context;
import java.util.Calendar;

public class StudyStreakManager {

    private final StudyStreakStorage storage;

    public StudyStreakManager(Context context) {
        storage = new StudyStreakStorage(context);
    }

    public synchronized StudyStreak recordToday() {
        StudyStreak streak = storage.load();

        long today = getDayStart(System.currentTimeMillis());
        long yesterday = today - 24L * 60L * 60L * 1000L;

        streak.recordStudyDay(today, yesterday);
        storage.save(streak);

        return streak;
    }

    public StudyStreak getCurrentStreak() {
        return storage.load();
    }

    public void reset() {
        storage.clear();
    }

    private long getDayStart(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }
}
