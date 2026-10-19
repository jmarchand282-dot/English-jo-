package com.josephmarchand.englishjoe.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.josephmarchand.englishjoe.data.AppData;

public class SettingsScreen extends ScrollView {
    private final Context context;
    private final AppData data;
    private final SharedPreferences prefs;
    private LinearLayout page;
    private final int ink = Color.rgb(30, 35, 60);
    private final int muted = Color.rgb(111, 117, 139);
    private final int purple = Color.rgb(79, 70, 229);
    private final int bg = Color.rgb(246, 247, 253);

    public SettingsScreen(Context c) {
        super(c);
        context = c;
        data = new AppData(c);
        prefs = c.getSharedPreferences("english_joe_data", Context.MODE_PRIVATE);
        setFillViewport(true);
        setBackgroundColor(bg);
        page = new LinearLayout(c);
        page.setOrientation(LinearLayout.VERTICAL);
        page.setPadding(dp(20), dp(24), dp(20), dp(30));
        addView(page);
        build();
    }

    private void build() {
        TextView eyebrow = txt("TON ESPACE", 12, purple, true);
        page.addView(eyebrow);
        TextView title = txt("Paramètres", 30, ink, true);
        LinearLayout.LayoutParams tp = lp(-1, -2); tp.topMargin = dp(5); page.addView(title, tp);
        TextView sub = txt("Personnalise ton expérience d’apprentissage.", 14, muted, false);
        LinearLayout.LayoutParams sp = lp(-1, -2); sp.topMargin = dp(5); page.addView(sub, sp);

        LinearLayout profile = new LinearLayout(context);
        profile.setOrientation(LinearLayout.VERTICAL);
        profile.setPadding(dp(18), dp(17), dp(18), dp(17));
        profile.setBackground(round(purple, 20));
        LinearLayout.LayoutParams pp = lp(-1, -2); pp.topMargin = dp(22); page.addView(profile, pp);
        TextView pLabel = txt("MON NIVEAU", 11, Color.rgb(220, 218, 255), true);
        profile.addView(pLabel);
        TextView pLevel = txt(data.getLevel(), 28, Color.WHITE, true);
        LinearLayout.LayoutParams lv = lp(-1, -2); lv.topMargin = dp(4); profile.addView(pLevel, lv);
        TextView pHint = txt("Continue à progresser à ton rythme.", 13, Color.WHITE, false);
        LinearLayout.LayoutParams ph = lp(-1, -2); ph.topMargin = dp(3); profile.addView(pHint, ph);

        section("PRÉFÉRENCES", "Choisis comment tu apprends");
        Switch notifications = new Switch(context);
        notifications.setText("Notifications et rappels");
        notifications.setTextSize(15);
        notifications.setTextColor(ink);
        notifications.setShowText(false);
        notifications.setChecked(prefs.getBoolean("notifications_enabled", true));
        row(notifications);
        notifications.setOnCheckedChangeListener((b, on) -> {
            prefs.edit().putBoolean("notifications_enabled", on).apply();
            Toast.makeText(context, on ? "Préférence de rappel activée" : "Préférence de rappel désactivée", Toast.LENGTH_SHORT).show();
        });

        Switch sound = new Switch(context);
        sound.setText("Son des exercices");
        sound.setTextSize(15);
        sound.setTextColor(ink);
        sound.setShowText(false);
        sound.setChecked(prefs.getBoolean("sound_enabled", true));
        row(sound);
        sound.setOnCheckedChangeListener((b, on) -> prefs.edit().putBoolean("sound_enabled", on).apply());

        section("MON PROFIL", "Ton parcours d’anglais");
        LinearLayout levelRow = card();
        levelRow.setOrientation(LinearLayout.VERTICAL);
        TextView level = txt("Niveau actuel : " + data.getLevel(), 16, ink, true);
        levelRow.addView(level);
        TextView levelDesc = txt("Tu peux choisir un niveau adapté à tes connaissances.", 12, muted, false);
        LinearLayout.LayoutParams ld = lp(-1, -2); ld.topMargin = dp(5); levelRow.addView(levelDesc, ld);
        page.addView(levelRow, spaced(-1, -2, 0, 0, 0, 10));

        Button changeLevel = button("Changer mon niveau", purple, Color.WHITE);
        page.addView(changeLevel, spaced(-1, dp(50), 0, 0, 0, 0));
        changeLevel.setOnClickListener(v -> new AlertDialog.Builder(context)
            .setTitle("Choisir ton niveau")
            .setItems(new String[]{"A1 — Débutant", "A2 — Élémentaire", "B1 — Intermédiaire", "B2 — Intermédiaire avancé", "C1 — Avancé", "C2 — Maîtrise"},
                (dialog, which) -> {
                    String[] levels = {"A1", "A2", "B1", "B2", "C1", "C2"};
                    data.setLevel(levels[which]);
                    Toast.makeText(context, "Niveau choisi : " + levels[which], Toast.LENGTH_SHORT).show();
                    ((Activity) context).setContentView(new SettingsScreen(context));
                }).setNegativeButton("Annuler", null).show());

        section("DONNÉES", "Gère ta progression");
        LinearLayout dataCard = card();
        dataCard.setOrientation(LinearLayout.VERTICAL);
        TextView resetTitle = txt("Repartir à zéro", 16, ink, true);
        dataCard.addView(resetTitle);
        TextView resetDesc = txt("Efface les données de progression enregistrées sur cet appareil.", 12, muted, false);
        LinearLayout.LayoutParams rd = lp(-1, -2); rd.topMargin = dp(5); dataCard.addView(resetDesc, rd);
        page.addView(dataCard, spaced(-1, -2, 0, 0, 0, 10));

        Button reset = button("Réinitialiser ma progression", Color.rgb(255, 238, 239), Color.rgb(184, 45, 58));
        page.addView(reset, spaced(-1, dp(50), 0, 0, 0, 0));
        reset.setOnClickListener(v -> new AlertDialog.Builder(context)
            .setTitle("Réinitialiser la progression ?")
            .setMessage("Ton XP et les leçons terminées seront effacés. Cette action est irréversible.")
            .setNegativeButton("Annuler", null)
            .setPositiveButton("Réinitialiser", (dialog, which) -> {
                data.resetAll();
                Toast.makeText(context, "Progression réinitialisée.", Toast.LENGTH_SHORT).show();
                ((Activity) context).setContentView(new HomeScreen(context));
            }).show());

        LinearLayout footer = new LinearLayout(context);
        footer.setOrientation(LinearLayout.VERTICAL);
        footer.setGravity(Gravity.CENTER);
        footer.setPadding(dp(12), dp(18), dp(12), dp(18));
        footer.setBackground(round(Color.WHITE, 18));
        LinearLayout.LayoutParams fp = lp(-1, -2); fp.topMargin = dp(24); page.addView(footer, fp);
        TextView brand = txt("JOENGLISH", 16, purple, true); brand.setGravity(Gravity.CENTER); footer.addView(brand);
        TextView creator = txt("Créé par Joseph Marchand", 13, muted, false); creator.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams cp = lp(-1, -2); cp.topMargin = dp(4); footer.addView(creator, cp);

        Button back = button("←  Retour à l’accueil", ink, Color.WHITE);
        page.addView(back, spaced(-1, dp(52), 0, dp(14), 0, 0));
        back.setOnClickListener(v -> ((Activity) context).setContentView(new HomeScreen(context)));
    }

    private void section(String title, String subtitle) {
        LinearLayout block = new LinearLayout(context);
        block.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams bp = lp(-1, -2); bp.topMargin = dp(23); bp.bottomMargin = dp(10);
        page.addView(block, bp);
        block.addView(txt(title, 13, ink, true));
        TextView sub = txt(subtitle, 12, muted, false);
        LinearLayout.LayoutParams p = lp(-1, -2); p.topMargin = dp(3); block.addView(sub, p);
    }

    private LinearLayout card() {
        LinearLayout box = new LinearLayout(context);
        box.setPadding(dp(16), dp(15), dp(16), dp(15));
        box.setBackground(round(Color.WHITE, 16));
        return box;
    }

    private void row(View v) {
        LinearLayout box = card();
        box.setGravity(Gravity.CENTER_VERTICAL);
        if (v instanceof Switch) ((Switch) v).setPadding(0, 0, 0, 0);
        box.addView(v, new LinearLayout.LayoutParams(-1, -2));
        page.addView(box, spaced(-1, -2, 0, 0, 0, 9));
    }

    private Button button(String label, int background, int foreground) {
        Button b = new Button(context);
        b.setText(label);
        b.setAllCaps(false);
        b.setTextSize(15);
        b.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        b.setTextColor(foreground);
        b.setBackground(round(background, 15));
        b.setElevation(dp(1));
        return b;
    }

    private TextView txt(String text, int size, int color, boolean bold) {
        TextView t = new TextView(context);
        t.setText(text);
        t.setTextSize(size);
        t.setTextColor(color);
        if (bold) t.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        return t;
    }

    private GradientDrawable round(int color, int radius) {
        GradientDrawable d = new GradientDrawable();
        d.setColor(color);
        d.setCornerRadius(dp(radius));
        return d;
    }

    private LinearLayout.LayoutParams lp(int w, int h) { return new LinearLayout.LayoutParams(w, h); }
    private LinearLayout.LayoutParams spaced(int w, int h, int left, int top, int right, int bottom) {
        LinearLayout.LayoutParams p = lp(w, h);
        p.setMargins(dp(left), dp(top), dp(right), dp(bottom));
        return p;
    }
    private int dp(int value) { return (int) (value * getResources().getDisplayMetrics().density + 0.5f); }
}