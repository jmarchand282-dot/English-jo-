package com.josephmarchand.englishjoe.courses.A1;

import com.josephmarchand.englishjoe.models.Question;

import java.util.ArrayList;
import java.util.List;

public class A1Lesson05 {

    public static final int LESSON_ID = 5;
    public static final String TITLE = "I am / You are";

    public static List<Question> getQuestions() {

        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "Complete: « I ___ a student. »",
                new String[]{
                        "am",
                        "is",
                        "are",
                        "be"
                },
                0,
                "The correct form with I is am."
        ));

        questions.add(new Question(
                "Complete: « You ___ my friend. »",
                new String[]{
                        "am",
                        "is",
                        "are",
                        "be"
                },
                2,
                "The correct form with you is are."
        ));

        questions.add(new Question(
                "Complete: « He ___ happy. »",
                new String[]{
                        "am",
                        "are",
                        "is",
                        "be"
                },
                2,
                "The correct form with he is is."
        ));

        questions.add(new Question(
                "Complete: « They ___ students. »",
                new String[]{
                        "is",
                        "am",
                        "are",
                        "be"
                },
                2,
                "The correct form with they is are."
        ));

        return questions;
    }

    public static int getQuestionCount() {
        return getQuestions().size();
    }
          }
