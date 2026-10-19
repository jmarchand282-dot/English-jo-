package com.josephmarchand.englishjoe.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.josephmarchand.englishjoe.data.AppData;
import com.josephmarchand.englishjoe.data.LessonProgress;

public class SettingsScreen extends ScrollView {
    private final Context context;
    private final AppData data;
    private final SharedPreferences prefs;
    private LinearLayout page;
    public SettingsScreen(Context c){super(c);context=c;data=new AppData(c);prefs=c.getSharedPreferences("english_joe_data",Context.MODE_PRIVATE);setFillViewport(true);setBackgroundColor(Color.rgb(246,247,252));page=new LinearLayout(c);page.setOrientation(LinearLayout.VERTICAL);page.setPadding(24,26,24,28);addView(page);build();}
    private void build(){
        TextView title=txt("Paramètres",28,Color.rgb(20,25,45),true);page.addView(title);
        TextView sub=txt("Configure ton expérience d’apprentissage.",14,Color.GRAY,false);LinearLayout.LayoutParams sp=lp(-1,-2);sp.topMargin=6;page.addView(sub,sp);
        section("PRÉFÉRENCES");
        Switch notifications=new Switch(context);notifications.setText("Notifications et rappels");notifications.setTextSize(16);notifications.setChecked(prefs.getBoolean("notifications_enabled",true));row(notifications);notifications.setOnCheckedChangeListener((b,on)->{prefs.edit().putBoolean("notifications_enabled",on).apply();Toast.makeText(context,on?"Rappels activés":"Rappels désactivés",Toast.LENGTH_SHORT).show();});
        Switch sound=new Switch(context);sound.setText("Son des exercices");sound.setTextSize(16);sound.setChecked(prefs.getBoolean("sound_enabled",true));row(sound);sound.setOnCheckedChangeListener((b,on)->prefs.edit().putBoolean("sound_enabled",on).apply());
        section("MON PROFIL");
        row(txt("Niveau actuel : "+data.getLevel(),16,Color.rgb(35,40,60),false));
        Button changeLevel=new Button(context);changeLevel.setText("Choisir mon niveau");changeLevel.setAllCaps(false);page.addView(changeLevel,lp(-1,-2));changeLevel.setOnClickListener(v->new AlertDialog.Builder(context).setTitle("Niveau d’anglais").setItems(new String[]{"A1 — Débutant","A2 — Élémentaire","B1 — Intermédiaire","B2 — Intermédiaire avancé","C1 — Avancé","C2 — Maîtrise"},(d,which)->{String[] levels={"A1","A2","B1","B2","C1","C2"};data.setLevel(levels[which]);Toast.makeText(context,"Niveau choisi : "+levels[which],Toast.LENGTH_SHORT).show();((Activity)context).setContentView(new SettingsScreen(context));}).show());
        section("DONNÉES");
        Button reset=new Button(context);reset.setText("Réinitialiser toute ma progression");reset.setAllCaps(false);reset.setTextColor(Color.rgb(185,45,45));page.addView(reset,lp(-1,-2));reset.setOnClickListener(v->new AlertDialog.Builder(context).setTitle("Réinitialiser la progression ?").setMessage("Ton XP, les leçons terminées et les préférences seront effacés. Cette action est irréversible.").setNegativeButton("Annuler",null).setPositiveButton("Réinitialiser",(d,w)->{data.resetAll();Toast.makeText(context,"Progression réinitialisée.",Toast.LENGTH_SHORT).show();((Activity)context).setContentView(new HomeScreen(context));}).show());
        TextView creator=txt("JOENGLISH\nCréé par Joseph Marchand",15,Color.rgb(79,70,229),true);creator.setGravity(Gravity.CENTER);LinearLayout.LayoutParams cr=lp(-1,-2);cr.topMargin=28;page.addView(creator,cr);
        Button back=new Button(context);back.setText("Retour à l’accueil");back.setAllCaps(false);page.addView(back,lp(-1,-2));back.setOnClickListener(v->((Activity)context).setContentView(new HomeScreen(context)));
    }
    private void section(String s){TextView t=txt(s,12,Color.rgb(90,96,118),true);LinearLayout.LayoutParams p=lp(-1,-2);p.topMargin=22;p.bottomMargin=8;page.addView(t,p);}
    private void row(android.view.View v){v.setPadding(14,14,14,14);v.setBackgroundColor(Color.WHITE);LinearLayout.LayoutParams p=lp(-1,-2);p.bottomMargin=8;page.addView(v,p);}
    private TextView txt(String s,int size,int color,boolean bold){TextView t=new TextView(context);t.setText(s);t.setTextSize(size);t.setTextColor(color);if(bold)t.setTypeface(Typeface.DEFAULT,Typeface.BOLD);return t;}
    private LinearLayout.LayoutParams lp(int w,int h){return new LinearLayout.LayoutParams(w,h);}
}