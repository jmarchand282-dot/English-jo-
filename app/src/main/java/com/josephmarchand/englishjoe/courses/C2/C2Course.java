package com.josephmarchand.englishjoe.courses.C2;

import com.josephmarchand.englishjoe.models.Lesson;
import java.util.ArrayList;
import java.util.List;

public class C2Course {
    public static final String LEVEL = "C2";
    public static List<Lesson> getLessons() {
        List<Lesson> lessons = new ArrayList<>();
        lessons.add(new Lesson(26, "Subtle meaning", "Interpréter les nuances implicites du discours.", "C2", "Advanced Comprehension", 35));
        lessons.add(new Lesson(27, "Rhetorical devices", "Analyser l'ironie, l'emphase et la rhétorique.", "C2", "Rhetoric", 35));
        lessons.add(new Lesson(28, "Register and style", "Adapter son style au public et à la situation.", "C2", "Writing", 35));
        lessons.add(new Lesson(29, "Complex discussion", "Défendre une position sur des sujets complexes.", "C2", "Speaking", 35));
        lessons.add(new Lesson(30, "Precision and reformulation", "Reformuler une idée sans perdre ses nuances.", "C2", "Communication", 35));
                lessons.add(new Lesson(56, "Pragmatics and implication", "Interpréter les intentions au-delà du sens littéral.", "C2", "Advanced Comprehension", 35));
        lessons.add(new Lesson(57, "Metaphor and imagery", "Analyser les métaphores et leur effet sur le lecteur.", "C2", "Literature", 35));
        lessons.add(new Lesson(58, "Argument structure", "Évaluer la logique, les présupposés et les objections d'un argument.", "C2", "Critical Thinking", 35));
        lessons.add(new Lesson(59, "Style transformation", "Adapter une même idée à plusieurs publics et registres.", "C2", "Writing", 35));
        lessons.add(new Lesson(60, "Precision in complex speech", "Formuler une position complexe avec clarté et nuances.", "C2", "Speaking", 35));

        return lessons;
    }
    public static int getTotalLessons() { return getLessons().size(); }
}