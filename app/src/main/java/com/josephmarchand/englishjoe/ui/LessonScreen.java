package com.josephmarchand.englishjoe.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.josephmarchand.englishjoe.models.Question;

import java.util.List;

public class LessonScreen extends LinearLayout {

    private TextView title;
    private TextView questionText;

    private List<Question> questions;

    private int currentQuestion = 0;

    public LessonScreen(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {

        setOrientation(VERTICAL);
        setPadding(24, 24, 24, 24);
        setBackgroundColor(Color.rgb(247, 248, 252));

        title = new TextView(context);

        title.setText("Leçon");
        title.setTextSize(26);
        title.setTextColor(Color.rgb(17, 24, 39));
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        questionText = new TextView(context);

        questionText.setText(
                "La question apparaîtra ici."
        );

        questionText.setTextSize(20);
        questionText.setTextColor(Color.rgb(31, 41, 55));
        questionText.setGravity(Gravity.CENTER);
        questionText.setPadding(10, 40, 10, 40);

        addView(title);
        addView(questionText);
    }

    public void setQuestions(List<Question> questions) {

        this.questions = questions;
        currentQuestion = 0;

        showCurrentQuestion();
    }

    private void showCurrentQuestion() {

        if (questions == null || questions.isEmpty()) {
            questionText.setText(
                    "Aucune question disponible."
            );
            return;
        }

        Question question =
                questions.get(currentQuestion);

        questionText.setText(
                question.getQuestionText()
        );
    }

    public boolean nextQuestion() {

        if (questions == null) {
            return false;
        }

        if (currentQuestion + 1 >= questions.size()) {
            return false;
        }

        currentQuestion++;

        showCurrentQuestion();

        return true;
    }

    public int getCurrentQuestionIndex() {
        return currentQuestion;
    }
}
