package com.josephmarchand.englishjoe.courses.B2;

import com.josephmarchand.englishjoe.models.Lesson;
import java.util.ArrayList;
import java.util.List;

public class B2Course {
    public static final String LEVEL = "B2";
    public static List<Lesson> getLessons() {
        List<Lesson> lessons = new ArrayList<>();
        lessons.add(new Lesson(16, "Second conditional", "Imaginer des situations hypothétiques.", "B2", "Grammar", 25));
        lessons.add(new Lesson(17, "Passive voice", "Mettre l'accent sur l'action ou son résultat.", "B2", "Grammar", 25));
        lessons.add(new Lesson(18, "Reported speech", "Rapporter les paroles d'une autre personne.", "B2", "Grammar", 25));
        lessons.add(new Lesson(19, "Argumentation", "Construire un argument clair et nuancé.", "B2", "Speaking", 25));
        lessons.add(new Lesson(20, "Workplace communication", "Communiquer avec précision au travail.", "B2", "Professional English", 25));
                lessons.add(new Lesson(46, "Third conditional", "Parler d'un passé différent et de ses conséquences imaginaires.", "B2", "Grammar", 25));
        lessons.add(new Lesson(47, "Modal verbs of deduction", "Déduire une possibilité ou une certitude à partir d'indices.", "B2", "Grammar", 25));
        lessons.add(new Lesson(48, "Linking devices", "Relier les idées et montrer cause, conséquence et concession.", "B2", "Writing", 25));
        lessons.add(new Lesson(49, "Job interviews", "Répondre avec précision aux questions professionnelles.", "B2", "Professional English", 25));
        lessons.add(new Lesson(50, "Problem-solving discussions", "Proposer, comparer et justifier des solutions.", "B2", "Speaking", 25));

        return lessons;
    }
    public static int getTotalLessons() { return getLessons().size(); }
}