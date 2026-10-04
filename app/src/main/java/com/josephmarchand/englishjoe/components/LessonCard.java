package com.josephmarchand.englishjoe.components;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LessonCard extends LinearLayout {

    private TextView lessonTitle;
    private TextView lessonDescription;
    private TextView lessonProgress;

    public LessonCard(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER_VERTICAL);
        setPadding(20, 18, 20, 18);
        setBackgroundColor(Color.WHITE);

        lessonTitle = new TextView(context);
        lessonTitle.setTextSize(18);
        lessonTitle.setTextColor(Color.rgb(17, 24, 39));
        lessonTitle.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        lessonDescription = new TextView(context);
        lessonDescription.setTextSize(14);
        lessonDescription.setTextColor(Color.rgb(107, 114, 128));

        lessonProgress = new TextView(context);
        lessonProgress.setTextSize(13);
        lessonProgress.setTextColor(Color.rgb(79, 70, 229));

        addView(lessonTitle);
        addView(lessonDescription);
        addView(lessonProgress);
    }

    public void setLessonTitle(String title) {
        lessonTitle.setText(title);
    }

    public void setDescription(String description) {
        lessonDescription.setText(description);
    }

    public void setProgress(String progress) {
        lessonProgress.setText(progress);
    }
}
