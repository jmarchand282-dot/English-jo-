package com.josephmarchand.englishjoe.data;

import com.josephmarchand.englishjoe.models.Achievement;

import java.util.ArrayList;
import java.util.List;

public class AchievementBank {

    private AchievementBank() {
    }

    public static List<Achievement> getAchievements() {

        List<Achievement> achievements =
                new ArrayList<>();

        achievements.add(
                new Achievement(
                        "first_lesson",
                        "Premier pas",
                        "Termine ta première leçon.",
                        1
                )
        );

        achievements.add(
                new Achievement(
                        "five_lessons",
                        "Apprenant motivé",
                        "Termine cinq leçons.",
                        5
                )
        );

        achievements.add(
                new Achievement(
                        "ten_lessons",
                        "Régulier",
                        "Termine dix leçons.",
                        10
                )
        );

        achievements.add(
                new Achievement(
                        "fifty_xp",
                        "Premier objectif",
                        "Gagne 50 XP.",
                        50
                )
        );

        achievements.add(
                new Achievement(
                        "five_hundred_xp",
                        "Passionné",
                        "Gagne 500 XP.",
                        500
                )
        );

        achievements.add(
                new Achievement(
                        "seven_day_streak",
                        "Une semaine",
                        "Maintiens une série de sept jours.",
                        7
                )
        );

        return achievements;
    }
}
