package com.josephmarchand.englishjoe.courses.A1;

import com.josephmarchand.englishjoe.models.Question;

import java.util.ArrayList;
import java.util.List;

public class A1Lesson13 {

    public static final int LESSON_ID = 13;
    public static final String TITLE = "Places in town";

    public static List<Question> getQuestions() {

        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "What does « school » mean?",
                new String[]{
                        "Hôpital",
                        "École",
                        "Banque",
                        "Marché"
                },
                1,
                "School means école."
        ));

        questions.add(new Question(
                "What does « hospital » mean?",
                new String[]{
                        "Hôpital",
                        "École",
                        "Restaurant",
                        "Gare"
                },
                0,
                "Hospital means hôpital."
        ));

        questions.add(new Question(
                "What does « bank » mean?",
                new String[]{
                        "Bibliothèque",
                        "Banque",
                        "Hôpital",
                        "Magasin"
                },
                1,
                "Bank means banque."
        ));

        questions.add(new Question(
                "What does « market » mean?",
                new String[]{
                        "Marché",
                        "Église",
                        "École",
                        "Hôtel"
                },
                0,
                "Market means marché."
        ));

        return questions;
    }

    public static int getQuestionCount() {
        return getQuestions().size();
    }
}
