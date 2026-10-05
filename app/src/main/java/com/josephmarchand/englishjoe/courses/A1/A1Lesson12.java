package com.josephmarchand.englishjoe.courses.A1;

import com.josephmarchand.englishjoe.models.Question;

import java.util.ArrayList;
import java.util.List;

public class A1Lesson12 {

    public static final int LESSON_ID = 12;
    public static final String TITLE = "Daily routines";

    public static List<Question> getQuestions() {

        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "What does « wake up » mean?",
                new String[]{
                        "Se réveiller",
                        "S'habiller",
                        "Travailler",
                        "Manger"
                },
                0,
                "Wake up means se réveiller."
        ));

        questions.add(new Question(
                "What does « go to school » mean?",
                new String[]{
                        "Rentrer à la maison",
                        "Aller à l'école",
                        "Dormir",
                        "Faire du sport"
                },
                1,
                "Go to school means aller à l'école."
        ));

        questions.add(new Question(
                "What does « go home » mean?",
                new String[]{
                        "Aller au travail",
                        "Aller à l'école",
                        "Rentrer à la maison",
                        "Sortir"
                },
                2,
                "Go home means rentrer à la maison."
        ));

        questions.add(new Question(
                "What does « go to bed » mean?",
                new String[]{
                        "Se lever",
                        "Aller au lit",
                        "Manger",
                        "Étudier"
                },
                1,
                "Go to bed means aller au lit."
        ));

        return questions;
    }

    public static int getQuestionCount() {
        return getQuestions().size();
    }
}
