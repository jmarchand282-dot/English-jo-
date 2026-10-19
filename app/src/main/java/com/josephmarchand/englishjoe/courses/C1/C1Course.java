package com.josephmarchand.englishjoe.courses.C1;

import com.josephmarchand.englishjoe.models.Lesson;
import java.util.ArrayList;
import java.util.List;

public class C1Course {
    public static final String LEVEL = "C1";
    public static List<Lesson> getLessons() {
        List<Lesson> lessons = new ArrayList<>();
        lessons.add(new Lesson(21, "Inversion for emphasis", "Utiliser l'inversion dans un registre soutenu.", "C1", "Advanced Grammar", 30));
        lessons.add(new Lesson(22, "Hedging and nuance", "Nuancer une affirmation avec précision.", "C1", "Academic English", 30));
        lessons.add(new Lesson(23, "Idiomatic language", "Comprendre les expressions idiomatiques en contexte.", "C1", "Vocabulary", 30));
        lessons.add(new Lesson(24, "Synthesising sources", "Résumer et relier plusieurs idées.", "C1", "Writing", 30));
        lessons.add(new Lesson(25, "Negotiation", "Négocier avec tact et clarté.", "C1", "Professional English", 30));
        return lessons;
    }
    public static int getTotalLessons() { return getLessons().size(); }
}