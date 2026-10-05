package com.josephmarchand.englishjoe.courses.A1;

import com.josephmarchand.englishjoe.models.Question;

import java.util.ArrayList;
import java.util.List;

public class A1Lesson03 {

    public static final int LESSON_ID = 3;
    public static final String TITLE = "Numbers";

    public static List<Question> getQuestions() {

        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "What number is « five »?",
                new String[]{
                        "3",
                        "4",
                        "5",
                        "6"
                },
                2,
                "Five is the number 5."
        ));

        questions.add(new Question(
                "What number is « ten »?",
                new String[]{
                        "8",
                        "9",
                        "10",
                        "11"
                },
                2,
                "Ten is the number 10."
        ));

        questions.add(new Question(
                "How do you say 7 in English?",
                new String[]{
                        "Six",
                        "Seven",
                        "Eight",
                        "Nine"
                },
                1,
                "The English word for 7 is Seven."
        ));

        questions.add(new Question(
                "How do you say 20 in English?",
                new String[]{
                        "Twelve",
                        "Fifteen",
                        "Twenty",
                        "Thirty"
                },
                2,
                "The English word for 20 is Twenty."
        ));

        return questions;
    }

    public static int getQuestionCount() {
        return getQuestions().size();
    }
}
