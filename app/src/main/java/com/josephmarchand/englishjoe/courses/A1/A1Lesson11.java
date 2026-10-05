package com.josephmarchand.englishjoe.courses.A1;

import com.josephmarchand.englishjoe.models.Question;

import java.util.ArrayList;
import java.util.List;

public class A1Lesson11 {

    public static final int LESSON_ID = 11;
    public static final String TITLE = "Basic verbs";

    public static List<Question> getQuestions() {

        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "What does « eat » mean?",
                new String[]{
                        "Boire",
                        "Manger",
                        "Dormir",
                        "Courir"
                },
                1,
                "Eat means manger."
        ));

        questions.add(new Question(
                "What does « drink » mean?",
                new String[]{
                        "Boire",
                        "Manger",
                        "Lire",
                        "Écrire"
                },
                0,
                "Drink means boire."
        ));

        questions.add(new Question(
                "What does « sleep » mean?",
                new String[]{
                        "Marcher",
                        "Parler",
                        "Dormir",
                        "Écouter"
                },
                2,
                "Sleep means dormir."
        ));

        questions.add(new Question(
                "What does « read » mean?",
                new String[]{
                        "Lire",
                        "Écrire",
                        "Parler",
                        "Chanter"
                },
                0,
                "Read means lire."
        ));

        return questions;
    }

    public static int getQuestionCount() {
        return getQuestions().size();
    }
}
