package com.josephmarchand.englishjoe.courses.A1;

import com.josephmarchand.englishjoe.models.Lesson;

import java.util.ArrayList;
import java.util.List;

public class A1Course {

    public static final String LEVEL = "A1";

    public static List<Lesson> getLessons() {

        List<Lesson> lessons = new ArrayList<>();

        lessons.add(new Lesson(
                1,
                "Greetings",
                "Learn basic greetings in English.",
                "A1",
                "Vocabulary",
                10
        ));

        lessons.add(new Lesson(
                2,
                "Introducing yourself",
                "Learn how to introduce yourself.",
                "A1",
                "Expressions",
                10
        ));

        lessons.add(new Lesson(
                3,
                "Numbers",
                "Learn numbers from 1 to 20.",
                "A1",
                "Vocabulary",
                10
        ));

        lessons.add(new Lesson(
                4,
                "The alphabet",
                "Learn and pronounce the English alphabet.",
                "A1",
                "Vocabulary",
                10
        ));

        lessons.add(new Lesson(
                5,
                "I am / You are",
                "Learn the verb to be.",
                "A1",
                "Grammar",
                15
        ));

        return lessons;
    }

    public static int getTotalLessons() {
        return getLessons().size();
    }
}
