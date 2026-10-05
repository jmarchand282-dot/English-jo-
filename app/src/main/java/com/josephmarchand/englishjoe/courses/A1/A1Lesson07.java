package com.josephmarchand.englishjoe.courses.A1;

import com.josephmarchand.englishjoe.models.Question;

import java.util.ArrayList;
import java.util.List;

public class A1Lesson07 {

    public static final int LESSON_ID = 7;
    public static final String TITLE = "Everyday objects";

    public static List<Question> getQuestions() {

        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "What does « book » mean?",
                new String[]{
                        "Stylo",
                        "Livre",
                        "Chaise",
                        "Table"
                },
                1,
                "Book means livre."
        ));

        questions.add(new Question(
                "What does « pen » mean?",
                new String[]{
                        "Stylo",
                        "Sac",
                        "Livre",
                        "Téléphone"
                },
                0,
                "Pen means stylo."
        ));

        questions.add(new Question(
                "What does « chair » mean?",
                new String[]{
                        "Fenêtre",
                        "Porte",
                        "Chaise",
                        "Table"
                },
                2,
                "Chair means chaise."
        ));

        questions.add(new Question(
                "What does « phone » mean?",
                new String[]{
                        "Ordinateur",
                        "Téléphone",
                        "Livre",
                        "Crayon"
                },
                1,
                "Phone means téléphone."
        ));

        return questions;
    }

    public static int getQuestionCount() {
        return getQuestions().size();
    }
}
