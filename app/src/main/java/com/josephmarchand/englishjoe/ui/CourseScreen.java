package com.josephmarchand.englishjoe.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.josephmarchand.englishjoe.courses.A1.A1Course;
import com.josephmarchand.englishjoe.models.Lesson;

import java.util.List;

public class CourseScreen extends LinearLayout {

    private LinearLayout lessonContainer;

    public CourseScreen(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {

        setOrientation(VERTICAL);
        setPadding(20, 20, 20, 20);
        setBackgroundColor(Color.rgb(247, 248, 252));

        TextView title = new TextView(context);
        title.setText("Cours A1");
        title.setTextSize(28);
        title.setTextColor(Color.rgb(17, 24, 39));
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        addView(title);

        TextView subtitle = new TextView(context);
        subtitle.setText("Commence ton parcours d’anglais.");
        subtitle.setTextSize(16);
        subtitle.setTextColor(Color.rgb(107, 114, 128));
        subtitle.setPadding(0, 6, 0, 20);

        addView(subtitle);

        lessonContainer = new LinearLayout(context);
        lessonContainer.setOrientation(VERTICAL);

        addView(lessonContainer);

        loadLessons();
    }

    private void loadLessons() {

        lessonContainer.removeAllViews();

        List<Lesson> lessons = A1Course.getLessons();

        for (Lesson lesson : lessons) {

            TextView item = new TextView(getContext());

            item.setText(
                    lesson.getId() + ". " +
                    lesson.getTitle() +
                    "\n" +
                    lesson.getDescription() +
                    "\n+" +
                    lesson.getXpReward() +
                    " XP"
            );

            item.setTextSize(16);
            item.setTextColor(Color.rgb(31, 41, 55));
            item.setGravity(Gravity.CENTER_VERTICAL);
            item.setPadding(18, 18, 18, 18);
            item.setBackgroundColor(Color.WHITE);

            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(
                            -1,
                            -2
                    );

            params.setMargins(0, 0, 0, 12);

            lessonContainer.addView(item, params);
        }
    }
  }
