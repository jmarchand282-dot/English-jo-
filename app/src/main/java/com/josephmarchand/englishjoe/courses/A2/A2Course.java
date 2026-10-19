package com.josephmarchand.englishjoe.courses.A2;

import com.josephmarchand.englishjoe.models.Lesson;
import java.util.ArrayList;
import java.util.List;

public class A2Course {
    public static final String LEVEL = "A2";

    public static List<Lesson> getLessons() {
        List<Lesson> lessons = new ArrayList<>();
        lessons.add(new Lesson(6, "Was / Were", "Parler de situations et d’états dans le passé.", "A2", "Grammar", 15));
        lessons.add(new Lesson(7, "Past simple", "Raconter des actions terminées avec des verbes réguliers.", "A2", "Grammar", 15));
        lessons.add(new Lesson(8, "Future with going to", "Parler de projets et d’intentions.", "A2", "Grammar", 15));
        lessons.add(new Lesson(9, "Comparatives", "Comparer des personnes, des lieux et des choses.", "A2", "Grammar", 15));
        lessons.add(new Lesson(10, "Some / Any", "Parler de quantités dans des phrases simples.", "A2", "Grammar", 15));
        return lessons;
    }

    public static int getTotalLessons() {
        return getLessons().size();
    }
}