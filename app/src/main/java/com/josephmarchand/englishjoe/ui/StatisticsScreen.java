package com.josephmarchand.englishjoe.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.josephmarchand.englishjoe.data.AppData;

public class StatisticsScreen extends LinearLayout {

    private AppData appData;

    public StatisticsScreen(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {

        appData = new AppData(context);

        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER_HORIZONTAL);
        setPadding(24, 30, 24, 30);
        setBackgroundColor(Color.rgb(247, 248, 252));

        TextView title = new TextView(context);

        title.setText("Statistiques");
        title.setTextSize(28);
        title.setTextColor(Color.rgb(17, 24, 39));
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        addView(title);

        addStat(
                "Points XP",
                String.valueOf(appData.getXp())
        );

        addStat(
                "Série actuelle",
                appData.getStreak() + " jours"
        );

        addStat(
                "Leçons terminées",
                String.valueOf(
                        appData.getCompletedLessons()
                )
        );

        addStat(
                "Niveau",
                appData.getLevel()
        );
    }

    private void addStat(
            String label,
            String value
    ) {

        TextView stat = new TextView(getContext());

        stat.setText(
                label + "\n" + value
        );

        stat.setTextSize(18);
        stat.setTextColor(Color.rgb(31, 41, 55));
        stat.setGravity(Gravity.CENTER);
        stat.setPadding(20, 20, 20, 20);

        addView(stat);
    }
      }
