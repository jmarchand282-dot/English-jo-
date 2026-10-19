package com.josephmarchand.englishjoe.courses.B1;

import com.josephmarchand.englishjoe.models.Lesson;
import java.util.ArrayList;
import java.util.List;

public class B1Course {
    public static final String LEVEL = "B1";
    public static List<Lesson> getLessons() {
        List<Lesson> lessons = new ArrayList<>();
        lessons.add(new Lesson(11, "Present perfect", "Relier une expérience passée au présent.", "B1", "Grammar", 20));
        lessons.add(new Lesson(12, "Past continuous", "Décrire une action en cours dans le passé.", "B1", "Grammar", 20));
        lessons.add(new Lesson(13, "First conditional", "Parler d'une conséquence possible.", "B1", "Grammar", 20));
        lessons.add(new Lesson(14, "Giving opinions", "Exprimer et justifier son opinion.", "B1", "Speaking", 20));
        lessons.add(new Lesson(15, "Travel problems", "Résoudre des problèmes pendant un voyage.", "B1", "Conversation", 20));
        return lessons;
    }
    public static int getTotalLessons() { return getLessons().size(); }
}