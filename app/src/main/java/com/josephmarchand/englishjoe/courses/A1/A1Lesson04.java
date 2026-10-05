package com.josephmarchand.englishjoe.courses.A1;

import com.josephmarchand.englishjoe.models.Question;

import java.util.ArrayList;
import java.util.List;

public class A1Lesson04 {

    public static final int LESSON_ID = 4;
    public static final String TITLE = "The alphabet";

    public static List<Question> getQuestions() {

        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "Which letter comes after A?",
                new String[]{
                        "B",
                        "C",
                        "D",
                        "E"
                },
                0,
                "B comes immediately after A."
        ));

        questions.add(new Question(
                "Which letter comes before D?",
                new String[]{
                        "A",
                        "B",
                        "C",
                        "E"
                },
                2,
                "C comes immediately before D."
        ));

        questions.add(new Question(
                "How many letters are in the English alphabet?",
                new String[]{
                        "24",
                        "25",
                        "26",
                        "27"
                },
                2,
                "The English alphabet has 26 letters."
        ));

        questions.add(new Question(
                "Which one is a vowel?",
                new String[]{
                        "B",
                        "C",
                        "E",
                        "G"
                },
                2,
                "E is a vowel."
        ));

        return questions;
    }

    public static int getQuestionCount() {
        return getQuestions().size();
    }
}
