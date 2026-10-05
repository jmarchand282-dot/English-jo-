package com.josephmarchand.englishjoe.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.josephmarchand.englishjoe.data.AppData;

public class SettingsScreen extends LinearLayout {

    private AppData appData;

    public SettingsScreen(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {

        appData = new AppData(context);

        setOrientation(VERTICAL);
        setPadding(24, 30, 24, 30);
        setBackgroundColor(Color.rgb(247, 248, 252));

        TextView title = new TextView(context);

        title.setText("Paramètres");
        title.setTextSize(28);
        title.setTextColor(Color.rgb(17, 24, 39));
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        addView(title);

        addSetting("🔔  Notifications");
        addSetting("⏰  Rappels d’étude");
        addSetting("🔊  Son");
        addSetting("🌐  Langue");
        addSetting("🔄  Réinitialiser la progression");

        TextView creator = new TextView(context);

        creator.setText(
                "✦ CRÉÉ PAR JOSEPH MARCHAND ✦"
        );

        creator.setTextSize(17);
        creator.setTextColor(Color.rgb(79, 70, 229));
        creator.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        creator.setGravity(Gravity.CENTER);
        creator.setPadding(10, 40, 10, 20);

        addView(creator);
    }

    private void addSetting(String text) {

        TextView item = new TextView(getContext());

        item.setText(text);
        item.setTextSize(17);
        item.setTextColor(Color.rgb(31, 41, 55));
        item.setPadding(18, 18, 18, 18);
        item.setBackgroundColor(Color.WHITE);

        LayoutParams params =
                new LayoutParams(-1, -2);

        params.setMargins(0, 8, 0, 0);

        addView(item, params);
    }
}
