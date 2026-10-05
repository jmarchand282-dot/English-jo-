package com.josephmarchand.englishjoe.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LanguageScreen extends LinearLayout {

    public LanguageScreen(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {

        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        setPadding(30, 30, 30, 30);
        setBackgroundColor(Color.rgb(247, 248, 252));

        TextView title = new TextView(context);

        title.setText("Choisis ta langue");
        title.setTextSize(27);
        title.setTextColor(Color.rgb(17, 24, 39));
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);

        TextView english = new TextView(context);

        english.setText("🇬🇧  English");
        english.setTextSize(20);
        english.setTextColor(Color.rgb(79, 70, 229));
        english.setGravity(Gravity.CENTER);
        english.setPadding(30, 20, 30, 20);

        TextView french = new TextView(context);

        french.setText("🇫🇷  Français");
        french.setTextSize(20);
        french.setTextColor(Color.rgb(17, 24, 39));
        french.setGravity(Gravity.CENTER);
        french.setPadding(30, 20, 30, 20);

        addView(title);
        addView(english);
        addView(french);
    }
}
