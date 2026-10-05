package com.josephmarchand.englishjoe.courses.A1;

import com.josephmarchand.englishjoe.models.Question;

import java.util.ArrayList;
import java.util.List;

public class A1Lesson09 {

    public static final int LESSON_ID = 9;
    public static final String TITLE = "Days of the week";

    public static List<Question> getQuestions() {

        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "What day comes after Monday?",
                new String[]{
                        "Sunday",
                        "Tuesday",
                        "Wednesday",
                        "Friday"
                },
                1,
                "Tuesday comes after Monday."
        ));

        questions.add(new Question(
                "What day comes before Friday?",
                new String[]{
                        "Wednesday",
                        "Thursday",
                        "Saturday",
                        "Sunday"
                },
                1,
                "Thursday comes before Friday."
        ));

        questions.add(new Question(
                "What does « Sunday » mean?",
                new String[]{
                        "Lundi",
                        "Samedi",
                        "Dimanche",
                        "Vendredi"
                },
                2,
                "Sunday means dimanche."
        ));

        questions.add(new Question(
                "What does « Wednesday » mean?",
                new String[]{
                        "Mercredi",
                        "Mardi",
                        "Jeudi",
                        "Vendredi"
                },
                0,
                "Wednesday means mercredi."
        ));

        return questions;
    }

    public static int getQuestionCount() {
        return getQuestions().size();
    }
}
