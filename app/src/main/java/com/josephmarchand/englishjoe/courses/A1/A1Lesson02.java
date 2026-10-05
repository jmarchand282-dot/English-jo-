package com.josephmarchand.englishjoe.courses.A1;

import com.josephmarchand.englishjoe.models.Question;

import java.util.ArrayList;
import java.util.List;

public class A1Lesson02 {

    public static final int LESSON_ID = 2;
    public static final String TITLE = "Introducing yourself";

    public static List<Question> getQuestions() {

        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "How do you say « Je m'appelle Anna »?",
                new String[]{
                        "I am Anna.",
                        "My name is Anna.",
                        "I have Anna.",
                        "Me Anna."
                },
                1,
                "My name is Anna means « Je m'appelle Anna »."
        ));

        questions.add(new Question(
                "Complete: « I ___ from Canada. »",
                new String[]{
                        "am",
                        "is",
                        "are",
                        "be"
                },
                0,
                "With I, we use am."
        ));

        questions.add(new Question(
                "How do you ask someone's name?",
                new String[]{
                        "Where are you?",
                        "How old are you?",
                        "What is your name?",
                        "Where do you live?"
                },
                2,
                "What is your name? asks for someone's name."
        ));

        questions.add(new Question(
                "What does « Nice to meet you » mean?",
                new String[]{
                        "Enchanté(e).",
                        "À demain.",
                        "Bonne nuit.",
                        "Merci beaucoup."
                },
                0,
                "Nice to meet you is used when meeting someone."
        ));

        return questions;
    }

    public static int getQuestionCount() {
        return getQuestions().size();
    }
}
