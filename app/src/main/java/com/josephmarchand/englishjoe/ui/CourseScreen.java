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
import com.josephmarchand.englishjoe.courses.A1.A1Course;
import com.josephmarchand.englishjoe.courses.A2.A2Course;
import com.josephmarchand.englishjoe.data.LessonProgress;
import com.josephmarchand.englishjoe.models.Lesson;
import java.util.List;

public class CourseScreen extends ScrollView {
    private final Context context;
    private LinearLayout page, lessons, levelButtons, banner;
    private String selectedLevel = "A1";
    public CourseScreen(Context context) {
        super(context); this.context=context; setFillViewport(true); setBackgroundColor(Color.rgb(246,247,252));
        page=new LinearLayout(context);page.setOrientation(LinearLayout.VERTICAL);page.setPadding(dp(20),dp(22),dp(20),dp(28));addView(page);
        page.addView(text("JOENGLISH  /  MON APPRENTISSAGE",11,Color.rgb(79,70,229),true));
        TextView title=text("Mes cours 📚",29,Color.rgb(24,29,50),true);LinearLayout.LayoutParams tp=lp(-1,-2);tp.topMargin=dp(8);page.addView(title,tp);
        TextView sub=text("Apprends étape par étape. Chaque petite victoire compte.",14,Color.rgb(105,111,132),false);LinearLayout.LayoutParams sp=lp(-1,-2);sp.topMargin=dp(5);page.addView(sub,sp);
        levelButtons=new LinearLayout(context);levelButtons.setOrientation(LinearLayout.HORIZONTAL);LinearLayout.LayoutParams lvp=lp(-1,-2);lvp.topMargin=dp(20);page.addView(levelButtons,lvp);
        addLevelButton("A1"); addLevelButton("A2");
        banner=new LinearLayout(context);banner.setOrientation(LinearLayout.VERTICAL);banner.setPadding(dp(18),dp(18),dp(18),dp(18));LinearLayout.LayoutParams bp=lp(-1,-2);bp.topMargin=dp(14);page.addView(banner,bp);
        TextView section=text("PARCOURS DU NIVEAU",12,Color.rgb(90,96,118),true);LinearLayout.LayoutParams secp=lp(-1,-2);secp.topMargin=dp(24);page.addView(section,secp);
        lessons=new LinearLayout(context);lessons.setOrientation(LinearLayout.VERTICAL);LinearLayout.LayoutParams lsp=lp(-1,-2);lsp.topMargin=dp(10);page.addView(lessons,lsp);
        TextView note=text("De nouvelles leçons seront ajoutées progressivement.",12,Color.rgb(125,130,150),false);LinearLayout.LayoutParams np=lp(-1,-2);np.topMargin=dp(16);page.addView(note,np);
        Button back=new Button(context);back.setText("← Accueil");back.setAllCaps(false);LinearLayout.LayoutParams backp=lp(-1,-2);backp.topMargin=dp(10);page.addView(back,backp);back.setOnClickListener(v->((Activity)context).setContentView(new HomeScreen(context)));
        renderLevel();
    }
    private void addLevelButton(String level){
        Button b=new Button(context);b.setText(level);b.setAllCaps(false);b.setTextSize(15);b.setOnClickListener(v->{selectedLevel=level;renderLevel();});
        LinearLayout.LayoutParams p=new LinearLayout.LayoutParams(0,dp(48),1);if(levelButtons.getChildCount()>0)p.leftMargin=dp(10);levelButtons.addView(b,p);
    }
    private void renderLevel(){
        banner.removeAllViews();banner.setBackground(round(selectedLevel.equals("A1")?Color.rgb(79,70,229):Color.rgb(15,118,110),20));
        banner.addView(text("NIVEAU "+selectedLevel+(selectedLevel.equals("A1")?"  •  DÉBUTANT":"  •  ÉLÉMENTAIRE"),12,Color.rgb(224,222,255),true));
        TextView bt=text(selectedLevel.equals("A1")?"Construis tes bases en anglais":"Exprime-toi dans plus de situations",21,Color.WHITE,true);LinearLayout.LayoutParams btp=lp(-1,-2);btp.topMargin=dp(7);banner.addView(bt,btp);
        TextView bd=text(selectedLevel.equals("A1")?"Saluer, se présenter, compter et créer tes premières phrases.":"Parler du passé, de projets, comparer et exprimer des quantités.",14,Color.rgb(240,239,255),false);LinearLayout.LayoutParams bdp=lp(-1,-2);bdp.topMargin=dp(5);banner.addView(bd,bdp);
        List<Lesson> list=selectedLevel.equals("A1")?A1Course.getLessons():A2Course.getLessons();
        lessons.removeAllViews();String[] icons=selectedLevel.equals("A1")?new String[]{"👋","🙋","🔢","🔤","✨"}:new String[]{"🕰️","📅","🔮","⚖️","🛒"};
        for(int i=0;i<list.size();i++){Lesson lesson=list.get(i);boolean done=LessonProgress.isCompleted(context,String.valueOf(lesson.getId()));
            LinearLayout card=new LinearLayout(context);card.setOrientation(LinearLayout.HORIZONTAL);card.setGravity(Gravity.CENTER_VERTICAL);card.setPadding(dp(14),dp(14),dp(12),dp(14));card.setBackground(round(Color.WHITE,17));card.setElevation(dp(1));
            LinearLayout.LayoutParams cp=lp(-1,-2);cp.bottomMargin=dp(11);lessons.addView(card,cp);
            TextView icon=text(icons[i%icons.length],25,Color.BLACK,true);icon.setGravity(Gravity.CENTER);icon.setBackground(round(done?Color.rgb(220,249,232):Color.rgb(238,237,255),14));card.addView(icon,lp(dp(54),dp(54)));
            LinearLayout copy=new LinearLayout(context);copy.setOrientation(LinearLayout.VERTICAL);LinearLayout.LayoutParams cop=new LinearLayout.LayoutParams(0,-2,1);cop.leftMargin=dp(12);card.addView(copy,cop);
            copy.addView(text("LEÇON "+String.format(java.util.Locale.US,"%02d",lesson.getId())+"  •  "+lesson.getCategory().toUpperCase(java.util.Locale.ROOT),10,Color.rgb(100,105,130),true));
            TextView name=text(lesson.getTitle(),16,Color.rgb(28,33,53),true);LinearLayout.LayoutParams nmp=lp(-1,-2);nmp.topMargin=dp(4);copy.addView(name,nmp);
            TextView desc=text(lesson.getDescription(),12,Color.rgb(110,115,135),false);LinearLayout.LayoutParams dp=lp(-1,-2);dp.topMargin=dp(3);copy.addView(desc,dp);
            TextView status=text(done?"✓ TERMINÉE  •  +"+lesson.getXpReward()+" XP":"+"+lesson.getXpReward()+" XP  •  APPUYER POUR JOUER",10,done?Color.rgb(22,140,80):Color.rgb(79,70,229),true);LinearLayout.LayoutParams stp=lp(-1,-2);stp.topMargin=dp(7);copy.addView(status,stp);
            card.setClickable(true);card.setFocusable(true);card.setOnClickListener(v->((Activity)context).setContentView(new LessonScreen(context,lesson)));
        }
        for(int i=0;i<levelButtons.getChildCount();i++){Button b=(Button)levelButtons.getChildAt(i);boolean active=b.getText().toString().equals(selectedLevel);b.setTextColor(active?Color.WHITE:Color.rgb(79,70,229));b.setBackground(round(active?Color.rgb(79,70,229):Color.WHITE,13));}
    }
    private TextView text(String s,int size,int color,boolean bold){TextView t=new TextView(context);t.setText(s);t.setTextSize(size);t.setTextColor(color);if(bold)t.setTypeface(Typeface.DEFAULT,Typeface.BOLD);return t;}
    private GradientDrawable round(int color,int r){GradientDrawable d=new GradientDrawable();d.setColor(color);d.setCornerRadius(dp(r));return d;}
    private int dp(int n){return (int)(n*getResources().getDisplayMetrics().density+.5f);}
    private LinearLayout.LayoutParams lp(int w,int h){return new LinearLayout.LayoutParams(w,h);}
}