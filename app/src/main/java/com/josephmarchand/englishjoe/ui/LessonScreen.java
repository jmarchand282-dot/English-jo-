package com.josephmarchand.englishjoe.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.josephmarchand.englishjoe.data.LessonProgress;
import com.josephmarchand.englishjoe.models.Lesson;
import com.josephmarchand.englishjoe.models.Question;
import java.util.ArrayList;
import java.util.List;

public class LessonScreen extends ScrollView {
    private final Lesson lesson;
    private final List<Question> questions=new ArrayList<>();
    private LinearLayout content;
    private TextView counter,prompt,feedback,progressLabel;
    private final Button[] choices=new Button[4];
    private Button nextButton;
    private int current=0,correctCount=0;
    private boolean answered=false;
    private final int purple=Color.rgb(79,70,229);
    public LessonScreen(Context c,Lesson lesson){super(c);this.lesson=lesson;buildQuestions();setFillViewport(true);setBackgroundColor(Color.rgb(246,247,252));buildUi(c);showQuestion();}
    private void buildQuestions(){
        int id=lesson.getId();
        if(id==1){add("How do you say « Bonjour » in English?",new String[]{"Goodbye","Hello","Please","Sorry"},1,"« Bonjour » se traduit par “Hello”.");add("How do you greet someone in the morning?",new String[]{"Good morning","Good night","See you","Thanks"},0,"Le matin, on dit “Good morning”.");add("What does “Thank you” mean?",new String[]{"Pardon","Au revoir","Merci","Bonjour"},2,"“Thank you” signifie « merci ».");}
        else if(id==2){add("Complete: My name ___ Ana.",new String[]{"are","am","is","be"},2,"Avec “my name”, on utilise “is”.");add("Complete: Nice to ___ you.",new String[]{"meet","name","am","good"},0,"L’expression correcte est “Nice to meet you”.");add("Choose a way to introduce yourself.",new String[]{"How old?","My name is Ana.","Good night you.","I fine thanks."},1,"“My name is…” permet de donner son nom.");}
        else if(id==3){add("How do you write le nombre 5 in English?",new String[]{"Four","Five","Fifteen","Fine"},1,"5 s’écrit “five”.");add("What number is “twelve”?",new String[]{"20","2","12","22"},2,"“Twelve” signifie douze (12).");add("What comes after nineteen?",new String[]{"Ninety","Eighteen","Thirty","Twenty"},3,"Après nineteen (19), vient twenty (20).");}
        else if(id==4){add("Which letter comes after B?",new String[]{"D","A","C","E"},2,"Dans l’alphabet, C vient après B.");add("What is the first letter of the English alphabet?",new String[]{"A","Z","B","E"},0,"L’alphabet anglais commence par A.");add("Which letter comes before Z?",new String[]{"X","Y","W","V"},1,"Y vient juste avant Z.");}
        else{add("Complete: I ___ a student.",new String[]{"is","are","am","be"},2,"Avec “I”, on utilise “am”: I am a student.");add("Complete: You ___ my friend.",new String[]{"am","are","is","be"},1,"Avec “you”, on utilise “are”.");add("Choose the correct sentence.",new String[]{"I are happy.","I is happy.","I be happy.","I am happy."},3,"La bonne forme est “I am happy”.");}
    }
    private void add(String q,String[] opts,int answer,String explanation){questions.add(new Question(q,opts,answer,explanation));}
    private void buildUi(Context c){
        content=new LinearLayout(c);content.setOrientation(LinearLayout.VERTICAL);content.setPadding(dp(20),dp(22),dp(20),dp(28));addView(content);
        LinearLayout header=new LinearLayout(c);header.setOrientation(LinearLayout.VERTICAL);header.setPadding(dp(18),dp(18),dp(18),dp(18));header.setBackground(round(purple,20));content.addView(header,lp(-1,-2));
        TextView badge=text("JOENGLISH  •  NIVEAU "+lesson.getLevel(),11,Color.rgb(224,222,255),true);header.addView(badge);
        TextView title=text(lesson.getTitle(),25,Color.WHITE,true);LinearLayout.LayoutParams tp=lp(-1,-2);tp.topMargin=dp(7);header.addView(title,tp);
        TextView subtitle=text("Apprends, réponds et progresse à ton rythme.",13,Color.rgb(240,239,255),false);LinearLayout.LayoutParams subp=lp(-1,-2);subp.topMargin=dp(5);header.addView(subtitle,subp);
        progressLabel=text("",12,Color.rgb(95,100,122),true);LinearLayout.LayoutParams plp=lp(-1,-2);plp.topMargin=dp(20);content.addView(progressLabel,plp);
        android.widget.ProgressBar bar=new android.widget.ProgressBar(c,null,android.R.attr.progressBarStyleHorizontal);bar.setMax(questions.size());bar.setProgress(1);bar.setProgressTintList(android.content.res.ColorStateList.valueOf(purple));bar.setProgressBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.rgb(225,226,238)));LinearLayout.LayoutParams barp=lp(-1,dp(7));barp.topMargin=dp(8);content.addView(bar,barp);
        counter=text("",12,purple,true);LinearLayout.LayoutParams cp=lp(-1,-2);cp.topMargin=dp(18);content.addView(counter,cp);
        LinearLayout questionCard=new LinearLayout(c);questionCard.setOrientation(LinearLayout.VERTICAL);questionCard.setPadding(dp(18),dp(18),dp(18),dp(18));questionCard.setBackground(round(Color.WHITE,18));LinearLayout.LayoutParams qcp=lp(-1,-2);qcp.topMargin=dp(10);content.addView(questionCard,qcp);
        prompt=text("",21,Color.rgb(28,33,53),true);questionCard.addView(prompt);
        for(int i=0;i<4;i++){final int ix=i;Button b=new Button(c);b.setAllCaps(false);b.setTextSize(15);b.setTextColor(Color.rgb(35,40,60));b.setGravity(Gravity.CENTER_VERTICAL);b.setPadding(dp(12),dp(7),dp(12),dp(7));b.setBackground(round(Color.rgb(246,247,252),13));LinearLayout.LayoutParams bp=lp(-1,dp(54));bp.topMargin=dp(10);questionCard.addView(b,bp);b.setOnClickListener(v->answer(ix));choices[i]=b;}
        feedback=text("",15,Color.rgb(31,41,55),false);feedback.setPadding(dp(13),dp(13),dp(13),dp(13));feedback.setBackground(round(Color.WHITE,14));LinearLayout.LayoutParams fp=lp(-1,-2);fp.topMargin=dp(12);content.addView(feedback,fp);
        nextButton=new Button(c);nextButton.setAllCaps(false);nextButton.setText("Question suivante  →");nextButton.setTextSize(15);nextButton.setTextColor(Color.WHITE);nextButton.setBackground(round(purple,14));LinearLayout.LayoutParams np=lp(-1,dp(52));np.topMargin=dp(14);content.addView(nextButton,np);nextButton.setOnClickListener(v->next());
        Button back=new Button(c);back.setAllCaps(false);back.setText("← Retour aux cours");LinearLayout.LayoutParams backp=lp(-1,-2);backp.topMargin=dp(8);content.addView(back,backp);back.setOnClickListener(v->{if(c instanceof Activity)((Activity)c).setContentView(new CourseScreen(c));});
    }
    private void showQuestion(){answered=false;Question q=questions.get(current);progressLabel.setText("TA PROGRESSION     "+(current+1)+" / "+questions.size());counter.setText("QUESTION "+(current+1)+"  •  "+correctCount+" BONNE(S) RÉPONSE(S)");prompt.setText(q.getQuestionText());String[] opts=q.getOptions();for(int i=0;i<choices.length;i++){choices[i].setVisibility(i<opts.length?View.VISIBLE:View.GONE);if(i<opts.length){choices[i].setText(new String[]{"A","B","C","D"}[i]+"     "+opts[i]);choices[i].setEnabled(true);choices[i].setBackground(round(Color.rgb(246,247,252),13));choices[i].setTextColor(Color.rgb(35,40,60));}}feedback.setText("Choisis la réponse qui te semble correcte.");feedback.setTextColor(Color.rgb(110,115,135));nextButton.setEnabled(false);nextButton.setAlpha(.55f);nextButton.setText(current==questions.size()-1?"Terminer la leçon  ✓":"Question suivante  →");}
    private void answer(int index){if(answered)return;answered=true;Question q=questions.get(current);boolean correct=q.isCorrect(index);if(correct)correctCount++;for(int i=0;i<choices.length;i++){choices[i].setEnabled(false);if(i<q.getOptions().length){if(q.isCorrect(i)){choices[i].setBackground(round(Color.rgb(218,249,230),13));choices[i].setTextColor(Color.rgb(20,120,65));}else if(i==index){choices[i].setBackground(round(Color.rgb(255,226,226),13));choices[i].setTextColor(Color.rgb(170,35,35));}}}feedback.setText((correct?"✓ Excellent ! Bonne réponse.\n":"↻ On apprend en se trompant.\n")+q.getExplanation());feedback.setTextColor(correct?Color.rgb(22,130,70):Color.rgb(170,55,55));nextButton.setEnabled(true);nextButton.setAlpha(1f);}
    private void next(){if(!answered){feedback.setText("Choisis d’abord une réponse pour continuer.");return;}if(current+1<questions.size()){current++;showQuestion();return;}boolean first=LessonProgress.complete(getContext(),String.valueOf(lesson.getId()),lesson.getXpReward());content.removeAllViews();LinearLayout resultCard=new LinearLayout(getContext());resultCard.setOrientation(LinearLayout.VERTICAL);resultCard.setGravity(Gravity.CENTER);resultCard.setPadding(dp(22),dp(30),dp(22),dp(30));resultCard.setBackground(round(Color.WHITE,22));content.addView(resultCard,lp(-1,-2));TextView icon=text(correctCount==questions.size()?"🏆":"🎉",48,Color.BLACK,true);icon.setGravity(Gravity.CENTER);resultCard.addView(icon);TextView result=text("Leçon terminée !",27,Color.rgb(24,29,50),true);result.setGravity(Gravity.CENTER);LinearLayout.LayoutParams rp=lp(-1,-2);rp.topMargin=dp(12);resultCard.addView(result,rp);TextView score=text("Ton score : "+correctCount+" / "+questions.size(),20,purple,true);score.setGravity(Gravity.CENTER);rp=lp(-1,-2);rp.topMargin=dp(12);resultCard.addView(score,rp);TextView xp=text(first?"+"+lesson.getXpReward()+" XP gagnés !":"Leçon déjà terminée : pas de XP en double.",16,Color.rgb(22,130,70),true);xp.setGravity(Gravity.CENTER);rp=lp(-1,-2);rp.topMargin=dp(8);resultCard.addView(xp,rp);TextView msg=text("Chaque exercice te rapproche de ton objectif. Continue !",14,Color.GRAY,false);msg.setGravity(Gravity.CENTER);rp=lp(-1,-2);rp.topMargin=dp(12);resultCard.addView(msg,rp);Button back=new Button(getContext());back.setAllCaps(false);back.setText("Retour aux cours");rp=lp(-1,dp(52));rp.topMargin=dp(20);resultCard.addView(back,rp);back.setOnClickListener(v->{if(getContext() instanceof Activity)((Activity)getContext()).setContentView(new CourseScreen(getContext()));});}
    private TextView text(String s,int size,int color,boolean bold){TextView t=new TextView(getContext());t.setText(s);t.setTextSize(size);t.setTextColor(color);if(bold)t.setTypeface(Typeface.DEFAULT,Typeface.BOLD);return t;}
    private GradientDrawable round(int color,int r){GradientDrawable d=new GradientDrawable();d.setColor(color);d.setCornerRadius(dp(r));return d;}
    private int dp(int n){return (int)(n*getResources().getDisplayMetrics().density+.5f);}
    private LinearLayout.LayoutParams lp(int w,int h){return new LinearLayout.LayoutParams(w,h);}
}