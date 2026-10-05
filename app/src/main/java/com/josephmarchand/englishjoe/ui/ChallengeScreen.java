package com.josephmarchand.englishjoe.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChallengeScreen extends LinearLayout {

    public ChallengeScreen(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {

        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        setPadding(30, 30, 30, 30);
        setBackgroundColor(Color.rgb(247, 248, 252));

        TextView title = new TextView(context);

        title.setText("Défis");
        title.setTextSize(28);
        title.setTextColor(Color.rgb(17, 24, 39));
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);

        TextView daily = new TextView(context);

        daily.setText(
                "Défi quotidien\n\n" +
                "Gagne 50 XP aujourd’hui."
        );

        daily.setTextSize(18);
        daily.setTextColor(Color.rgb(245, 158, 11));
        daily.setGravity(Gravity.CENTER);
        daily.setPadding(0, 30, 0, 0);

        addView(title);
        addView(daily);
    }
}
