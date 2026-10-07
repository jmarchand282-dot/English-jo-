package com.josephmarchand.englishjoe.progress;

import com.josephmarchand.englishjoe.data.AchievementBank;
import com.josephmarchand.englishjoe.data.AppData;
import com.josephmarchand.englishjoe.models.Achievement;

import java.util.ArrayList;
import java.util.List;

public class AchievementManager {

    private final AppData appData;

    public AchievementManager(AppData appData) {
        this.appData = appData;
    }

    public List<Achievement> getAchievements() {

        List<Achievement> achievements =
                AchievementBank.getAchievements();

        int lessons = appData.getCompletedLessons();
        int xp = appData.getXp();
        int streak = appData.getStreak();

        for (Achievement achievement : achievements) {

            int value = 0;

            switch (achievement.getId()) {

                case "first_lesson":
                case "five_lessons":
                case "ten_lessons":
                    value = lessons;
                    break;

                case "fifty_xp":
                case "five_hundred_xp":
                    value = xp;
                    break;

                case "seven_day_streak":
                    value = streak;
                    break;
            }

            achievement.setUnlocked(
                    value >= achievement.getRequiredValue()
            );
        }

        return new ArrayList<>(achievements);
    }

    public int getUnlockedCount() {

        int count = 0;

        for (Achievement achievement : getAchievements()) {

            if (achievement.isUnlocked()) {
                count++;
            }
        }

        return count;
    }

    public int getTotalCount() {
        return getAchievements().size();
    }
}
