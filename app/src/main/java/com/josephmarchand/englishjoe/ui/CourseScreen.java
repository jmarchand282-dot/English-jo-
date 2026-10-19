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
import com.josephmarchand.englishjoe.courses.B1.B1Course;
import com.josephmarchand.englishjoe.courses.B2.B2Course;
import com.josephmarchand.englishjoe.courses.C1.C1Course;
import com.josephmarchand.englishjoe.courses.C2.C2Course;
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
        page.addView(text("ENGLISH JOE  /  MON APPRENTISSAGE",11,Color.rgb(79,70,229),true));
        TextView title=text("Mes cours 📚",29,Color.rgb(24,29,50),true);LinearLayout.LayoutParams tp=lp(-1,-2);tp.topMargin=dp(8);page.addView(title,tp);
        TextView sub=text("Six niveaux, des bases jusqu'à la maîtrise avancée.",14,Color.rgb(105,111,132),false);LinearLayout.LayoutParams sp=lp(-1,-2);sp.topMargin=dp(5);page.addView(sub,sp);
        String[][] rows={{"A1","A2","B1"},{"B2","C1","C2"}};
        for(String[] row:rows){levelButtons=new LinearLayout(context);levelButtons.setOrientation(LinearLayout.HORIZONTAL);LinearLayout.LayoutParams rp=lp(-1,-2);rp.topMargin=dp(12);page.addView(levelButtons,rp);for(String level:row)addLevelButton(level);}
        banner=new LinearLayout(context);banner.setOrientation(LinearLayout.VERTICAL);banner.setPadding(dp(18),dp(18),dp(18),dp(18));LinearLayout.LayoutParams bp=lp(-1,-2);bp.topMargin=dp(14);page.addView(banner,bp);
        TextView section=text("PARCOURS DU NIVEAU",12,Color.rgb(90,96,118),true);LinearLayout.LayoutParams secp=lp(-1,-2);secp.topMargin=dp(24);page.addView(section,secp);
        lessons=new LinearLayout(context);lessons.setOrientation(LinearLayout.VERTICAL);LinearLayout.LayoutParams lsp=lp(-1,-2);lsp.topMargin=dp(10);page.addView(lessons,lsp);
        Button back=new Button(context);back.setText("← Accueil");back.setAllCaps(false);LinearLayout.LayoutParams backp=lp(-1,-2);backp.topMargin=dp(10);page.addView(back,backp);back.setOnClickListener(v->((Activity)context).setContentView(new HomeScreen(context)));
        renderLevel();
    }
    private void addLevelButton(String level){
        Button b=new Button(context);b.setText(level);b.setAllCaps(false);b.setTextSize(14);b.setMinWidth(0);b.setPadding(dp(2),0,dp(2),0);
        LinearLayout.LayoutParams p=new LinearLayout.LayoutParams(0,dp(46),1);p.setMargins(dp(3),0,dp(3),0);levelButtons.addView(b,p);
        b.setOnClickListener(v->{selectedLevel=level;renderLevel();});
    }
    private List<Lesson> getLessons(){
        switch(selectedLevel){case "A2":return A2Course.getLessons();case "B1":return B1Course.getLessons();case "B2":return B2Course.getLessons();case "C1":return C1Course.getLessons();case "C2":return C2Course.getLessons();default:return A1Course.getLessons();}
    }
    private String levelName(){switch(selectedLevel){case "A1":return "DÉBUTANT";case "A2":return "ÉLÉMENTAIRE";case "B1":return "INTERMÉDIAIRE";case "B2":return "INTERMÉDIAIRE AVANCÉ";case "C1":return "AVANCÉ";default:return "MAÎTRISE";}
    }
    private int levelColor(){switch(selectedLevel){case "A1":return Color.rgb(79,70,229);case "A2":return Color.rgb(15,118,110);case "B1":return Color.rgb(37,99,235);case "B2":return Color.rgb(180,83,9);case "C1":return Color.rgb(157,23,77);default:return Color.rgb(75,85,99);}}
    private void renderLevel(){
        banner.removeAllViews();banner.setBackground(round(levelColor(),20));
        banner.addView(text("NIVEAU "+selectedLevel+"  •  "+levelName(),12,Color.rgb(240,239,255),true));
        TextView bt=text("Parcours "+selectedLevel,21,Color.WHITE,true);LinearLayout.LayoutParams btp=lp(-1,-2);btp.topMargin=dp(7);banner.addView(bt,btp);
        TextView bd=text(getLessons().size()+" leçons disponibles dans ce parcours. Étudie le cours avant de répondre au quiz.",14,Color.WHITE,false);LinearLayout.LayoutParams bdp=lp(-1,-2);bdp.topMargin=dp(5);banner.addView(bd,bdp);
        List<Lesson> list=getLessons();lessons.removeAllViews();String[] icons={"📘","🗣️","✍️","🎯","🌍"};
        for(int i=0;i<list.size();i++){Lesson lesson=list.get(i);boolean done=LessonProgress.isCompleted(context,String.valueOf(lesson.getId()));
            LinearLayout card=new LinearLayout(context);card.setOrientation(LinearLayout.HORIZONTAL);card.setGravity(Gravity.CENTER_VERTICAL);card.setPadding(dp(14),dp(14),dp(12),dp(14));card.setBackground(round(Color.WHITE,17));card.setElevation(dp(1));
            LinearLayout.LayoutParams cp=lp(-1,-2);cp.bottomMargin=dp(11);lessons.addView(card,cp);
            TextView icon=text(done?"✓":icons[i%icons.length],24,done?Color.rgb(22,130,70):levelColor(),true);icon.setGravity(Gravity.CENTER);icon.setBackground(round(done?Color.rgb(220,249,232):Color.rgb(239,240,255),14));card.addView(icon,lp(dp(48),dp(48)));
            LinearLayout details=new LinearLayout(context);details.setOrientation(LinearLayout.VERTICAL);LinearLayout.LayoutParams dpms=new LinearLayout.LayoutParams(0,-2,1);dpms.leftMargin=dp(12);card.addView(details,dpms);
            details.addView(text(lesson.getTitle(),17,Color.rgb(29,34,54),true));TextView desc=text(lesson.getDescription(),13,Color.rgb(105,111,132),false);LinearLayout.LayoutParams descp=lp(-1,-2);descp.topMargin=dp(4);details.addView(desc,descp);
            TextView meta=text(lesson.getLevel()+"  •  "+lesson.getXpReward()+" XP"+(done?"  •  Terminée":""),11,done?Color.rgb(22,130,70):levelColor(),true);LinearLayout.LayoutParams mp=lp(-1,-2);mp.topMargin=dp(6);details.addView(meta,mp);
            card.setOnClickListener(v->{if(context instanceof Activity)((Activity)context).setContentView(new LessonScreen(context,lesson));});
        }
    }
    private TextView text(String s,int size,int color,boolean bold){TextView t=new TextView(context);t.setText(s);t.setTextSize(size);t.setTextColor(color);if(bold)t.setTypeface(Typeface.DEFAULT,Typeface.BOLD);return t;}
    private GradientDrawable round(int color,int r){GradientDrawable d=new GradientDrawable();d.setColor(color);d.setCornerRadius(dp(r));return d;}
    private int dp(int n){return (int)(n*getResources().getDisplayMetrics().density+.5f);}
    private LinearLayout.LayoutParams lp(int w,int h){return new LinearLayout.LayoutParams(w,h);}
}
