package com.josephmarchand.englishjoe.courses.A1;

import com.josephmarchand.englishjoe.models.Question;

import java.util.ArrayList;
import java.util.List;

public class A1Lesson08 {

    public static final int LESSON_ID = 8;
    public static final String TITLE = "Colors";

    public static List<Question> getQuestions() {

        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "What does « red » mean?",
                new String[]{
                        "Bleu",
                        "Rouge",
                        "Vert",
                        "Jaune"
                },
                1,
                "Red means rouge."
        ));

        questions.add(new Question(
                "What does « blue » mean?",
                new String[]{
                        "Bleu",
                        "Noir",
                        "Blanc",
                        "Orange"
                },
                0,
                "Blue means bleu."
        ));

        questions.add(new Question(
                "What does « green » mean?",
                new String[]{
                        "Rose",
                        "Violet",
                        "Vert",
                        "Gris"
                },
                2,
                "Green means vert."
        ));

        questions.add(new Question(
                "What does « yellow » mean?",
                new String[]{
                        "Jaune",
                        "Marron",
                        "Rouge",
                        "Bleu"
                },
                0,
                "Yellow means jaune."
        ));

        return questions;
    }

    public static int getQuestionCount() {
        return getQuestions().size();
    }
}
