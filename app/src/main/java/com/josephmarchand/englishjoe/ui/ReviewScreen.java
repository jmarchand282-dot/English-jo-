package com.josephmarchand.englishjoe.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ReviewScreen extends LinearLayout {

    public ReviewScreen(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {

        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        setPadding(30, 30, 30, 30);
        setBackgroundColor(Color.rgb(247, 248, 252));

        TextView title = new TextView(context);

        title.setText("Révision");
        title.setTextSize(28);
        title.setTextColor(Color.rgb(17, 24, 39));
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);

        TextView description = new TextView(context);

        description.setText(
                "Révise ton vocabulaire, " +
                "ta grammaire et tes expressions."
        );

        description.setTextSize(16);
        description.setTextColor(Color.rgb(107, 114, 128));
        description.setGravity(Gravity.CENTER);
        description.setPadding(0, 16, 0, 0);

        addView(title);
        addView(description);
    }
}
