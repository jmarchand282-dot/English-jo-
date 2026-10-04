package com.josephmarchand.englishjoe.components;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StatCard extends LinearLayout {

    private TextView titleView;
    private TextView valueView;

    public StatCard(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        setPadding(16, 16, 16, 16);
        setBackgroundColor(Color.WHITE);

        titleView = new TextView(context);
        titleView.setTextSize(13);
        titleView.setTextColor(Color.rgb(107, 114, 128));
        titleView.setGravity(Gravity.CENTER);

        valueView = new TextView(context);
        valueView.setTextSize(22);
        valueView.setTextColor(Color.rgb(79, 70, 229));
        valueView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        valueView.setGravity(Gravity.CENTER);

        addView(titleView);
        addView(valueView);
    }

    public void setTitle(String title) {
        titleView.setText(title);
    }

    public void setValue(String value) {
        valueView.setText(value);
    }
}
