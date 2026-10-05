package com.josephmarchand.englishjoe.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PlacementScreen extends LinearLayout {

    public PlacementScreen(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {

        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        setPadding(28, 28, 28, 28);
        setBackgroundColor(Color.rgb(247, 248, 252));

        TextView title = new TextView(context);

        title.setText("Test de niveau");
        title.setTextSize(28);
        title.setTextColor(Color.rgb(17, 24, 39));
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);

        TextView description = new TextView(context);

        description.setText(
                "Réponds à quelques questions " +
                "pour déterminer ton niveau d’anglais."
        );

        description.setTextSize(16);
        description.setTextColor(Color.rgb(107, 114, 128));
        description.setGravity(Gravity.CENTER);
        description.setPadding(0, 16, 0, 0);

        TextView levels = new TextView(context);

        levels.setText(
                "A1  •  A2  •  B1  •  B2  •  C1  •  C2"
        );

        levels.setTextSize(17);
        levels.setTextColor(Color.rgb(79, 70, 229));
        levels.setGravity(Gravity.CENTER);
        levels.setPadding(0, 30, 0, 0);

        addView(title);
        addView(description);
        addView(levels);
    }
}
