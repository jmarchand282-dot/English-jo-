package com.josephmarchand.englishjoe.components;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class JoHeader extends LinearLayout {

    private TextView title;
    private TextView subtitle;

    public JoHeader(Context context) {
        super(context);
        init(context);
    }

    public JoHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER_VERTICAL);
        setPadding(20, 20, 20, 20);

        title = new TextView(context);
        title.setText("English Joe");
        title.setTextSize(24);
        title.setTextColor(Color.rgb(17, 24, 39));
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        subtitle = new TextView(context);
        subtitle.setText("Apprends aujourd’hui, un meilleur demain !");
        subtitle.setTextSize(14);
        subtitle.setTextColor(Color.rgb(107, 114, 128));

        addView(title);
        addView(subtitle);
    }

    public void setTitle(String text) {
        title.setText(text);
    }

    public void setSubtitle(String text) {
        subtitle.setText(text);
    }
}
