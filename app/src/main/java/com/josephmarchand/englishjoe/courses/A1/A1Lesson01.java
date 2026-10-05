package com.josephmarchand.englishjoe.courses.A1;

import com.josephmarchand.englishjoe.models.Question;

import java.util.ArrayList;
import java.util.List;

public class A1Lesson01 {

    public static final int LESSON_ID = 1;
    public static final String TITLE = "Greetings";

    public static List<Question> getQuestions() {

        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "How do you say « Bonjour » in English?",
                new String[]{
                        "Goodbye",
                        "Hello",
                        "Thanks",
                        "Sorry"
                },
                1,
                "Hello is a common English greeting."
        ));

        questions.add(new Question(
                "Which expression means « Au revoir »?",
                new String[]{
                        "Good morning",
                        "Goodbye",
                        "Welcome",
                        "Please"
                },
                1,
                "Goodbye is used when leaving someone."
        ));

        questions.add(new Question(
                "Which greeting is commonly used in the morning?",
                new String[]{
                        "Good night",
                        "Goodbye",
                        "Good morning",
                        "See you"
                },
                2,
                "Good morning is used as a morning greeting."
        ));

        questions.add(new Question(
                "What does « Hi » mean?",
                new String[]{
                        "Hello",
                        "Thank you",
                        "Sorry",
                        "Good night"
                },
                0,
                "Hi is an informal way to say hello."
        ));

        return questions;
    }

    public static int getQuestionCount() {
        return getQuestions().size();
    }
}
