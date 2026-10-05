package com.josephmarchand.englishjoe.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WelcomeScreen extends LinearLayout {

    private TextView title;
    private TextView subtitle;

    public WelcomeScreen(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {

        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        setPadding(32, 32, 32, 32);
        setBackgroundColor(Color.rgb(247, 248, 252));

        title = new TextView(context);
        title.setText("Bienvenue sur English Joe");
        title.setTextSize(28);
        title.setTextColor(Color.rgb(17, 24, 39));
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);

        subtitle = new TextView(context);
        subtitle.setText(
                "Apprends l’anglais progressivement, " +
                "de A1 à C2."
        );
        subtitle.setTextSize(17);
        subtitle.setTextColor(Color.rgb(107, 114, 128));
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setPadding(0, 16, 0, 0);

        addView(title);
        addView(subtitle);
    }
    }
