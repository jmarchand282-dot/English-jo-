package com.josephmarchand.englishjoe.courses.A1;

import com.josephmarchand.englishjoe.models.Question;

import java.util.ArrayList;
import java.util.List;

public class A1Lesson10 {

    public static final int LESSON_ID = 10;
    public static final String TITLE = "Food and drinks";

    public static List<Question> getQuestions() {

        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "What does « water » mean?",
                new String[]{
                        "Lait",
                        "Eau",
                        "Jus",
                        "Pain"
                },
                1,
                "Water means eau."
        ));

        questions.add(new Question(
                "What does « bread » mean?",
                new String[]{
                        "Riz",
                        "Viande",
                        "Pain",
                        "Poisson"
                },
                2,
                "Bread means pain."
        ));

        questions.add(new Question(
                "What does « milk » mean?",
                new String[]{
                        "Lait",
                        "Eau",
                        "Café",
                        "Thé"
                },
                0,
                "Milk means lait."
        ));

        questions.add(new Question(
                "What does « apple » mean?",
                new String[]{
                        "Orange",
                        "Banane",
                        "Pomme",
                        "Raisin"
                },
                2,
                "Apple means pomme."
        ));

        return questions;
    }

    public static int getQuestionCount() {
        return getQuestions().size();
    }
}
