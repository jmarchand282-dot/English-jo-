package com.josephmarchand.englishjoe.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class ReviewScreen extends ScrollView {
    private final String[][] qs={
        {"How do you say « Merci »?","Please","Thank you","Sorry","1","“Thank you” signifie « merci »."},
        {"Complete: My name ___ John.","are","is","am","1","Avec “my name”, on utilise “is”."},
        {"What number is “five”?","5","15","50","0","“Five” signifie cinq (5)."},
        {"Complete: I ___ happy.","are","is","am","2","Avec “I”, on utilise “am”."},
        {"What does “Good morning” mean?","Bonsoir","Bonjour (le matin)","Bonne nuit","1","On utilise “Good morning” le matin."}
    };
    private int index=0,score=0;
    private LinearLayout page;
    private TextView counter,prompt,feedback;
    private Button[] options=new Button[3];
    private Button next;
    private boolean answered=false;
    public ReviewScreen(Context c){super(c);setFillViewport(true);setBackgroundColor(Color.rgb(246,247,252));page=new LinearLayout(c);page.setOrientation(LinearLayout.VERTICAL);page.setPadding(24,26,24,24);addView(page);build(c);show();}
    private void build(Context c){
        TextView title=txt("Révision intelligente",27,Color.rgb(20,25,45),true);page.addView(title);
        TextView sub=txt("5 questions rapides pour renforcer ta mémoire.",14,Color.GRAY,false);LinearLayout.LayoutParams subp=lp(-1,-2);subp.topMargin=8;page.addView(sub,subp);
        counter=txt("",13,Color.rgb(79,70,229),true);LinearLayout.LayoutParams cp=lp(-1,-2);cp.topMargin=24;page.addView(counter,cp);
        prompt=txt("",21,Color.rgb(30,35,55),true);LinearLayout.LayoutParams pp=lp(-1,-2);pp.topMargin=16;page.addView(prompt,pp);
        for(int i=0;i<3;i++){final int choice=i;options[i]=new Button(c);options[i].setAllCaps(false);options[i].setTextSize(16);LinearLayout.LayoutParams op=lp(-1,-2);op.topMargin=12;page.addView(options[i],op);options[i].setOnClickListener(v->answer(choice));}
        feedback=txt("",16,Color.rgb(22,130,70),false);LinearLayout.LayoutParams fp=lp(-1,-2);fp.topMargin=14;page.addView(feedback,fp);
        next=new Button(c);next.setAllCaps(false);next.setText("Question suivante");LinearLayout.LayoutParams np=lp(-1,-2);np.topMargin=18;page.addView(next,np);next.setOnClickListener(v->advance());
        Button back=new Button(c);back.setAllCaps(false);back.setText("Retour à l’accueil");page.addView(back,lp(-1,-2));back.setOnClickListener(v->((Activity)c).setContentView(new HomeScreen(c)));
    }
    private void show(){answered=false;String[] q=qs[index];counter.setText("QUESTION "+(index+1)+" / "+qs.length+"     •     SCORE "+score);prompt.setText(q[0]);for(int i=0;i<3;i++){options[i].setText(q[i+1]);options[i].setEnabled(true);}feedback.setText("");next.setEnabled(false);next.setText(index==qs.length-1?"Voir mon résultat":"Question suivante");}
    private void answer(int n){if(answered)return;answered=true;boolean ok=n==Integer.parseInt(qs[index][4]);if(ok)score++;for(Button b:options)b.setEnabled(false);feedback.setText((ok?"✓ Bonne réponse ! ":"✗ Réponse à revoir. ")+qs[index][5]);feedback.setTextColor(ok?Color.rgb(22,130,70):Color.rgb(185,45,45));next.setEnabled(true);}
    private void advance(){if(!answered){Toast.makeText(getContext(),"Choisis une réponse.",Toast.LENGTH_SHORT).show();return;}if(index<qs.length-1){index++;show();return;}page.removeAllViews();TextView result=txt("Révision terminée !",27,Color.rgb(20,25,45),true);page.addView(result);TextView scoreText=txt("Ton score : "+score+" / "+qs.length,23,Color.rgb(79,70,229),true);LinearLayout.LayoutParams p=lp(-1,-2);p.topMargin=18;page.addView(scoreText,p);TextView msg=txt(score>=4?"Excellent travail ! Continue comme ça.":"Bon effort ! Relis les leçons puis réessaie.",16,Color.DKGRAY,false);p=lp(-1,-2);p.topMargin=10;page.addView(msg,p);Button again=new Button(getContext());again.setText("Recommencer la révision");again.setAllCaps(false);page.addView(again,lp(-1,-2));again.setOnClickListener(v->{index=0;score=0;page.removeAllViews();build(getContext());show();});Button home=new Button(getContext());home.setText("Accueil");home.setAllCaps(false);page.addView(home,lp(-1,-2));home.setOnClickListener(v->((Activity)getContext()).setContentView(new HomeScreen(getContext())));}
    private TextView txt(String s,int size,int color,boolean bold){TextView t=new TextView(getContext());t.setText(s);t.setTextSize(size);t.setTextColor(color);if(bold)t.setTypeface(Typeface.DEFAULT,Typeface.BOLD);return t;}
    private LinearLayout.LayoutParams lp(int w,int h){return new LinearLayout.LayoutParams(w,h);}
}
