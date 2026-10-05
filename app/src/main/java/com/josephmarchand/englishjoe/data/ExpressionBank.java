package com.josephmarchand.englishjoe.data;

import com.josephmarchand.englishjoe.models.Expression;

import java.util.ArrayList;
import java.util.List;

public class ExpressionBank {

    private ExpressionBank() {
    }

    public static List<Expression> getBasicExpressions() {

        List<Expression> expressions = new ArrayList<>();

        expressions.add(
                new Expression(
                        "Hello",
                        "Bonjour",
                        "heh-LOH",
                        "Hello, how are you?"
                )
        );

        expressions.add(
                new Expression(
                        "Good morning",
                        "Bonjour",
                        "good MOR-ning",
                        "Good morning, teacher."
                )
        );

        expressions.add(
                new Expression(
                        "Good evening",
                        "Bonsoir",
                        "good EE-vning",
                        "Good evening!"
                )
        );

        expressions.add(
                new Expression(
                        "How are you?",
                        "Comment vas-tu ?",
                        "how ar yoo",
                        "How are you today?"
                )
        );

        expressions.add(
                new Expression(
                        "I am fine",
                        "Je vais bien",
                        "ai am fain",
                        "I am fine, thank you."
                )
        );

        expressions.add(
                new Expression(
                        "Thank you",
                        "Merci",
                        "thank yoo",
                        "Thank you very much."
                )
        );

        expressions.add(
                new Expression(
                        "You're welcome",
                        "De rien",
                        "yor WEL-kum",
                        "You're welcome!"
                )
        );

        expressions.add(
                new Expression(
                        "See you later",
                        "À plus tard",
                        "see yoo LAY-ter",
                        "See you later!"
                )
        );

        expressions.add(
                new Expression(
                        "What is your name?",
                        "Comment t'appelles-tu ?",
                        "what iz yor naym",
                        "What is your name?"
                )
        );

        expressions.add(
                new Expression(
                        "My name is...",
                        "Je m'appelle...",
                        "mai naym iz",
                        "My name is Joseph."
                )
        );

        return expressions;
    }
          }
