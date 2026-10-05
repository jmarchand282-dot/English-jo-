package com.josephmarchand.englishjoe.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PlanningScreen extends LinearLayout {

    public PlanningScreen(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {

        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        setPadding(30, 30, 30, 30);
        setBackgroundColor(Color.rgb(247, 248, 252));

        TextView title = new TextView(context);

        title.setText("Planning");
        title.setTextSize(28);
        title.setTextColor(Color.rgb(17, 24, 39));
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        TextView schedule = new TextView(context);

        schedule.setText(
                "Ton objectif quotidien\n\n" +
                "50 XP par jour\n\n" +
                "Temps recommandé : 15 à 30 minutes"
        );

        schedule.setTextSize(17);
        schedule.setTextColor(Color.rgb(107, 114, 128));
        schedule.setGravity(Gravity.CENTER);
        schedule.setPadding(0, 25, 0, 0);

        addView(title);
        addView(schedule);
    }
}
