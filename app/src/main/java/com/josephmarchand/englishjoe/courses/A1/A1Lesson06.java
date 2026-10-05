package com.josephmarchand.englishjoe.courses.A1;

import com.josephmarchand.englishjoe.models.Question;

import java.util.ArrayList;
import java.util.List;

public class A1Lesson06 {

    public static final int LESSON_ID = 6;
    public static final String TITLE = "Family";

    public static List<Question> getQuestions() {

        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "What does « mother » mean?",
                new String[]{
                        "Père",
                        "Mère",
                        "Frère",
                        "Sœur"
                },
                1,
                "Mother means mère."
        ));

        questions.add(new Question(
                "What does « father » mean?",
                new String[]{
                        "Père",
                        "Mère",
                        "Fils",
                        "Fille"
                },
                0,
                "Father means père."
        ));

        questions.add(new Question(
                "What does « brother » mean?",
                new String[]{
                        "Sœur",
                        "Frère",
                        "Mère",
                        "Cousine"
                },
                1,
                "Brother means frère."
        ));

        questions.add(new Question(
                "What does « sister » mean?",
                new String[]{
                        "Frère",
                        "Père",
                        "Sœur",
                        "Fils"
                },
                2,
                "Sister means sœur."
        ));

        return questions;
    }

    public static int getQuestionCount() {
        return getQuestions().size();
    }
}
