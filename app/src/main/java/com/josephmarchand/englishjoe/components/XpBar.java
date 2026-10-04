package com.josephmarchand.englishjoe.components;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class XpBar extends LinearLayout {

    private ProgressBar progressBar;
    private TextView xpText;

    public XpBar(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER_VERTICAL);

        xpText = new TextView(context);
        xpText.setText("0 / 500 XP");
        xpText.setTextSize(14);
        xpText.setTextColor(Color.rgb(17, 24, 39));

        progressBar = new ProgressBar(
                context,
                null,
                android.R.attr.progressBarStyleHorizontal
        );

        progressBar.setMax(500);
        progressBar.setProgress(0);

        GradientDrawable background = new GradientDrawable();
        background.setColor(Color.rgb(229, 231, 235));
        background.setCornerRadius(20);

        progressBar.setBackground(background);

        addView(xpText);
        addView(progressBar);
    }

    public void setXp(int currentXp, int maxXp) {
        progressBar.setMax(maxXp);
        progressBar.setProgress(Math.max(0, Math.min(currentXp, maxXp)));
        xpText.setText(currentXp + " / " + maxXp + " XP");
    }
}
