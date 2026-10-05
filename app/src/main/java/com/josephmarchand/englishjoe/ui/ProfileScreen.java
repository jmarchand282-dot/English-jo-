package com.josephmarchand.englishjoe.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.josephmarchand.englishjoe.data.AppData;

public class ProfileScreen extends LinearLayout {

    private AppData appData;

    public ProfileScreen(Context context) {
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
        title.setText("Ton profil");
        title.setTextSize(28);
        title.setTextColor(Color.rgb(17, 24, 39));
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        addView(title);

        TextView name = createInfo(
                "Prénom",
                appData.getFirstName()
        );

        TextView username = createInfo(
                "Nom d'utilisateur",
                appData.getUsername()
        );

        TextView level = createInfo(
                "Niveau",
                appData.getLevel()
        );

        addView(name);
        addView(username);
        addView(level);
    }

    private TextView createInfo(
            String label,
            String value
    ) {

        TextView text = new TextView(getContext());

        text.setText(
                label + "\n" +
                (value.isEmpty() ? "Non défini" : value)
        );

        text.setTextSize(17);
        text.setTextColor(Color.rgb(31, 41, 55));
        text.setPadding(20, 18, 20, 18);

        return text;
    }
}
