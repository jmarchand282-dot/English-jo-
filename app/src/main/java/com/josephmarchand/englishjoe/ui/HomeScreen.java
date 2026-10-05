package com.josephmarchand.englishjoe.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.josephmarchand.englishjoe.data.AppData;
import com.josephmarchand.englishjoe.components.StatCard;
import com.josephmarchand.englishjoe.components.XpBar;

public class HomeScreen extends LinearLayout {

    private TextView welcomeText;
    private TextView levelText;

    private StatCard xpCard;
    private StatCard streakCard;

    private XpBar xpBar;

    private AppData appData;

    public HomeScreen(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {

        appData = new AppData(context);

        setOrientation(VERTICAL);
        setPadding(20, 20, 20, 20);
        setBackgroundColor(Color.rgb(247, 248, 252));

        welcomeText = new TextView(context);
        welcomeText.setTextSize(26);
        welcomeText.setTextColor(Color.rgb(17, 24, 39));
        welcomeText.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        String firstName = appData.getFirstName();

        if (firstName.isEmpty()) {
            welcomeText.setText("Bienvenue !");
        } else {
            welcomeText.setText("Bonjour, " + firstName + " !");
        }

        addView(welcomeText);

        levelText = new TextView(context);
        levelText.setText(
                "Niveau " + appData.getLevel()
        );
        levelText.setTextSize(16);
        levelText.setTextColor(Color.rgb(107, 114, 128));
        levelText.setPadding(0, 6, 0, 20);

        addView(levelText);

        LinearLayout stats = new LinearLayout(context);
        stats.setOrientation(HORIZONTAL);
        stats.setGravity(Gravity.CENTER);

        xpCard = new StatCard(context);
        xpCard.setTitle("XP");
        xpCard.setValue(String.valueOf(appData.getXp()));

        streakCard = new StatCard(context);
        streakCard.setTitle("Série");
        streakCard.setValue(
                appData.getStreak() + " jours"
        );

        stats.addView(
                xpCard,
                new LinearLayout.LayoutParams(
                        0,
                        120,
                        1
                )
        );

        LinearLayout.LayoutParams streakParams =
                new LinearLayout.LayoutParams(
                        0,
                        120,
                        1
                );

        streakParams.setMargins(12, 0, 0, 0);

        stats.addView(streakCard, streakParams);

        addView(stats);

        xpBar = new XpBar(context);
        xpBar.setXp(appData.getXp(), 500);

        LinearLayout.LayoutParams xpParams =
                new LinearLayout.LayoutParams(
                        -1,
                        80
                );

        xpParams.setMargins(0, 24, 0, 0);

        addView(xpBar, xpParams);
    }

    public void refresh() {

        String firstName = appData.getFirstName();

        if (firstName.isEmpty()) {
            welcomeText.setText("Bienvenue !");
        } else {
            welcomeText.setText("Bonjour, " + firstName + " !");
        }

        levelText.setText(
                "Niveau " + appData.getLevel()
        );

        xpCard.setValue(
                String.valueOf(appData.getXp())
        );

        streakCard.setValue(
                appData.getStreak() + " jours"
        );

        xpBar.setXp(
                appData.getXp(),
                500
        );
    }
          }
