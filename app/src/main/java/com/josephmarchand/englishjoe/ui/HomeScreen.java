package com.josephmarchand.englishjoe.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.josephmarchand.englishjoe.data.AppData;
import com.josephmarchand.englishjoe.data.LessonProgress;

public class HomeScreen extends ScrollView {
    private final AppData data;
    private final LinearLayout page;
    private TextView xpValue, streakValue, completedValue;

    public HomeScreen(Context context) {
        super(context);
        data = new AppData(context);
        setFillViewport(true);
        setBackgroundColor(Color.rgb(246,247,252));
        page = new LinearLayout(context);
        page.setOrientation(LinearLayout.VERTICAL);
        page.setPadding(dp(20),dp(22),dp(20),dp(28));
        addView(page);

        TextView brand = text("JOENGLISH",12,Color.rgb(79,70,229),true);
        brand.setLetterSpacing(.16f);
        page.addView(brand);
        TextView welcome = text(data.getFirstName().isEmpty() ? "Bonjour 👋" : "Bonjour, "+data.getFirstName()+" 👋",29,Color.rgb(20,25,45),true);
        LinearLayout.LayoutParams wp = params(-1,-2); wp.topMargin=dp(7); page.addView(welcome,wp);
        TextView subtitle = text("Un petit pas chaque jour, un grand progrès demain.",14,Color.rgb(104,110,130),false);
        LinearLayout.LayoutParams sp=params(-1,-2);sp.topMargin=dp(5);page.addView(subtitle,sp);

        LinearLayout hero = new LinearLayout(context);
        hero.setOrientation(LinearLayout.VERTICAL);
        hero.setPadding(dp(20),dp(20),dp(20),dp(20));
        hero.setBackground(round(Color.rgb(79,70,229),22));
        LinearLayout.LayoutParams hp=params(-1,-2);hp.topMargin=dp(22);page.addView(hero,hp);
        TextView level = text("TON PARCOURS  •  "+data.getLevel(),12,Color.rgb(224,222,255),true);hero.addView(level);
        TextView heroTitle = text("Prêt à progresser ?",24,Color.WHITE,true);
        LinearLayout.LayoutParams htp=params(-1,-2);htp.topMargin=dp(8);hero.addView(heroTitle,htp);
        TextView heroSub = text("Apprends du vocabulaire, comprends la grammaire et entraîne-toi avec des questions.",14,Color.rgb(239,238,255),false);
        LinearLayout.LayoutParams hsp=params(-1,-2);hsp.topMargin=dp(7);hero.addView(heroSub,hsp);
        Button start=button(context,"Continuer mon apprentissage",Color.WHITE,Color.rgb(79,70,229));
        LinearLayout.LayoutParams bp=params(-1,dp(52));bp.topMargin=dp(18);hero.addView(start,bp);
        start.setOnClickListener(v->openCourses(context));

        TextView statsTitle=text("TA PROGRESSION",12,Color.rgb(90,96,118),true);
        LinearLayout.LayoutParams stp=params(-1,-2);stp.topMargin=dp(24);page.addView(statsTitle,stp);
        LinearLayout stats=new LinearLayout(context);stats.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams statsp=params(-1,-2);statsp.topMargin=dp(10);page.addView(stats,statsp);
        xpValue=text(String.valueOf(data.getXp())+" XP",22,Color.rgb(79,70,229),true);
        streakValue=text(data.getStreak()+" jours",22,Color.rgb(220,120,30),true);
        completedValue=text(String.valueOf(data.getCompletedLessons()),22,Color.rgb(22,140,90),true);
        stats.addView(statCard(context,"⭐ EXPÉRIENCE",xpValue),weightParams());
        stats.addView(statCard(context,"🔥 SÉRIE",streakValue),weightParamsWithMargin());
        stats.addView(statCard(context,"✓ LEÇONS",completedValue),weightParamsWithMargin());

        TextView actionsTitle=text("TON ESPACE D’APPRENTISSAGE",12,Color.rgb(90,96,118),true);
        LinearLayout.LayoutParams atp=params(-1,-2);atp.topMargin=dp(24);page.addView(actionsTitle,atp);
        addAction(context,"📚","Mes cours","Leçons et exercices guidés",()->openCourses(context));
        addAction(context,"🧠","Révision intelligente","Teste ce que tu as appris",()->((Activity)context).setContentView(new ReviewScreen(context)));
        addAction(context,"⚙️","Paramètres","Personnalise ton apprentissage",()->((Activity)context).setContentView(new SettingsScreen(context)));
        TextView footer=text("Créé pour apprendre à ton rythme • JoEnglish",12,Color.rgb(135,140,157),false);
        footer.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams fp=params(-1,-2);fp.topMargin=dp(24);page.addView(footer,fp);
    }

    private void addAction(Context c,String icon,String title,String desc,Runnable action){
        LinearLayout card=new LinearLayout(c);card.setOrientation(LinearLayout.HORIZONTAL);card.setGravity(Gravity.CENTER_VERTICAL);card.setPadding(dp(15),dp(14),dp(12),dp(14));card.setBackground(round(Color.WHITE,16));
        LinearLayout.LayoutParams cp=params(-1,-2);cp.topMargin=dp(10);page.addView(card,cp);
        TextView ico=text(icon,25,Color.rgb(79,70,229),true);card.addView(ico);
        LinearLayout copy=new LinearLayout(c);copy.setOrientation(LinearLayout.VERTICAL);LinearLayout.LayoutParams copyP=new LinearLayout.LayoutParams(0,-2,1);copyP.leftMargin=dp(13);card.addView(copy,copyP);
        copy.addView(text(title,16,Color.rgb(30,35,55),true));TextView d=text(desc,12,Color.rgb(110,115,135),false);LinearLayout.LayoutParams dp=params(-1,-2);dp.topMargin=dp(3);copy.addView(d,dp);
        TextView arrow=text("›",28,Color.rgb(125,130,150),false);card.addView(arrow);
        card.setClickable(true);card.setFocusable(true);card.setOnClickListener(v->action.run());
    }
    private LinearLayout statCard(Context c,String label,TextView value){
        LinearLayout box=new LinearLayout(c);box.setOrientation(LinearLayout.VERTICAL);box.setPadding(dp(10),dp(14),dp(8),dp(14));box.setBackground(round(Color.WHITE,15));
        box.addView(text(label,9,Color.rgb(110,115,135),true));LinearLayout.LayoutParams vp=params(-1,-2);vp.topMargin=dp(8);box.addView(value,vp);return box;
    }
    private Button button(Context c,String label,int bg,int fg){Button b=new Button(c);b.setText(label);b.setAllCaps(false);b.setTextSize(15);b.setTypeface(Typeface.DEFAULT,Typeface.BOLD);b.setTextColor(fg);b.setBackground(round(bg,14));return b;}
    private TextView text(String value,int size,int color,boolean bold){TextView t=new TextView(getContext());t.setText(value);t.setTextSize(size);t.setTextColor(color);if(bold)t.setTypeface(Typeface.DEFAULT,Typeface.BOLD);return t;}
    private GradientDrawable round(int color,int radius){GradientDrawable d=new GradientDrawable();d.setColor(color);d.setCornerRadius(dp(radius));return d;}
    private LinearLayout.LayoutParams params(int w,int h){return new LinearLayout.LayoutParams(w,h);}
    private LinearLayout.LayoutParams weightParams(){return new LinearLayout.LayoutParams(0,-2,1);}
    private LinearLayout.LayoutParams weightParamsWithMargin(){LinearLayout.LayoutParams p=weightParams();p.leftMargin=dp(7);return p;}
    private int dp(int value){return (int)(value*getResources().getDisplayMetrics().density+.5f);}
    private void openCourses(Context c){((Activity)c).setContentView(new CourseScreen(c));}
}
