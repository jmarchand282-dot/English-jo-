package com.josephmarchand.englishjoe.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
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
    private final List<Question> questions = new ArrayList<>();
    private LinearLayout content;
    private TextView title;
    private TextView counter;
    private TextView prompt;
    private TextView feedback;
    private final Button[] choices = new Button[4];
    private Button nextButton;
    private int current = 0;
    private boolean answered = false;
    private int correctCount = 0;

    public LessonScreen(Context context, Lesson lesson) {
        super(context);
        this.lesson = lesson;
        buildQuestions();
        buildUi(context);
        showQuestion();
    }

    private void buildQuestions() {
        int id = lesson.getId();
        if (id == 1) {
            add("How do you say « Bonjour » in English?", new String[]{"Goodbye", "Hello", "Please", "Sorry"}, 1, "« Bonjour » se traduit par “Hello”.");
            add("How do you greet someone in the morning?", new String[]{"Good morning", "Good night", "See you", "Thanks"}, 0, "Le matin, on dit “Good morning”.");
            add("What does “Thank you” mean?", new String[]{"Pardon", "Au revoir", "Merci", "Bonjour"}, 2, "“Thank you” signifie « merci ».");
        } else if (id == 2) {
            add("Complete: My name ___ Ana.", new String[]{"are", "am", "is", "be"}, 2, "Avec “my name”, on utilise “is”.");
            add("Complete: Nice to ___ you.", new String[]{"meet", "name", "am", "good"}, 0, "L’expression correcte est “Nice to meet you”.");
            add("Choose a way to introduce yourself.", new String[]{"How old?", "My name is Ana.", "Good night you.", "I fine thanks."}, 1, "“My name is…” permet de donner son nom.");
        } else if (id == 3) {
            add("How do you write le nombre 5 in English?", new String[]{"Four", "Five", "Fifteen", "Fine"}, 1, "5 s’écrit “five”.");
            add("What number is “twelve”?", new String[]{"20", "2", "12", "22"}, 2, "“Twelve” signifie douze (12).");
            add("What comes after nineteen?", new String[]{"Ninety", "Eighteen", "Thirty", "Twenty"}, 3, "Après nineteen (19), vient twenty (20).");
        } else if (id == 4) {
            add("Which letter comes after B?", new String[]{"D", "A", "C", "E"}, 2, "Dans l’alphabet, C vient après B.");
            add("What is the first letter of the English alphabet?", new String[]{"A", "Z", "B", "E"}, 0, "L’alphabet anglais commence par A.");
            add("Which letter comes before Z?", new String[]{"X", "Y", "W", "V"}, 1, "Y vient juste avant Z.");
        } else {
            add("Complete: I ___ a student.", new String[]{"is", "are", "am", "be"}, 2, "Avec “I”, on utilise “am”: I am a student.");
            add("Complete: You ___ my friend.", new String[]{"am", "are", "is", "be"}, 1, "Avec “you”, on utilise “are”.");
            add("Choose the correct sentence.", new String[]{"I are happy.", "I is happy.", "I be happy.", "I am happy."}, 3, "La bonne forme est “I am happy”.");
        }
    }

    private void add(String text, String[] options, int answer, String explanation) {
        questions.add(new Question(text, options, answer, explanation));
    }

    private void buildUi(Context context) {
        content = new LinearLayout(context);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(24, 24, 24, 28);
        content.setBackgroundColor(Color.rgb(247, 248, 252));
        addView(content);

        title = new TextView(context);
        title.setText(lesson.getTitle());
        title.setTextSize(26);
        title.setTextColor(Color.rgb(17, 24, 39));
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        content.addView(title);

        counter = new TextView(context);
        counter.setTextSize(15);
        counter.setTextColor(Color.rgb(107, 114, 128));
        counter.setPadding(0, 8, 0, 18);
        content.addView(counter);

        prompt = new TextView(context);
        prompt.setTextSize(21);
        prompt.setTextColor(Color.rgb(31, 41, 55));
        prompt.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        prompt.setPadding(0, 12, 0, 22);
        content.addView(prompt);

        for (int i = 0; i < choices.length; i++) {
            final int choiceIndex = i;
            Button button = new Button(context);
            button.setAllCaps(false);
            button.setTextSize(16);
            button.setOnClickListener(v -> answer(choiceIndex));
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(-1, -2);
            p.setMargins(0, 0, 0, 10);
            content.addView(button, p);
            choices[i] = button;
        }

        feedback = new TextView(context);
        feedback.setTextSize(16);
        feedback.setTextColor(Color.rgb(31, 41, 55));
        feedback.setPadding(4, 12, 4, 16);
        content.addView(feedback);

        nextButton = new Button(context);
        nextButton.setAllCaps(false);
        nextButton.setText("Question suivante");
        nextButton.setOnClickListener(v -> next());
        content.addView(nextButton);

        Button back = new Button(context);
        back.setAllCaps(false);
        back.setText("Retour aux cours");
        back.setOnClickListener(v -> {
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).setContentView(new CourseScreen(getContext()));
            }
        });
        content.addView(back);
    }

    private void showQuestion() {
        answered = false;
        Question q = questions.get(current);
        counter.setText("Question " + (current + 1) + " sur " + questions.size() + "  •  " + correctCount + " bonne(s) réponse(s)");
        prompt.setText(q.getQuestionText());
        String[] options = q.getOptions();
        for (int i = 0; i < choices.length; i++) {
            choices[i].setVisibility(i < options.length ? View.VISIBLE : View.GONE);
            if (i < options.length) {
                choices[i].setText(options[i]);
                choices[i].setEnabled(true);
                choices[i].setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.WHITE));
            }
        }
        feedback.setText("");
        nextButton.setEnabled(false);
        nextButton.setText(current == questions.size() - 1 ? "Terminer la leçon" : "Question suivante");
    }

    private void answer(int index) {
        if (answered) return;
        answered = true;
        Question q = questions.get(current);
        boolean correct = q.isCorrect(index);
        if (correct) correctCount++;
        for (int i = 0; i < choices.length; i++) choices[i].setEnabled(false);
        feedback.setText((correct ? "✓ Bonne réponse !\n" : "✗ Pas tout à fait.\n")
                + q.getExplanation());
        feedback.setTextColor(correct ? Color.rgb(22, 130, 70) : Color.rgb(185, 45, 45));
        nextButton.setEnabled(true);
    }

    private void next() {
        if (!answered) {
            feedback.setText("Choisis une réponse avant de continuer.");
            return;
        }
        if (current + 1 < questions.size()) {
            current++;
            showQuestion();
            return;
        }
        boolean firstCompletion = LessonProgress.complete(getContext(), String.valueOf(lesson.getId()), lesson.getXpReward());
        content.removeAllViews();
        TextView result = new TextView(getContext());
        result.setText("Leçon terminée !\n\nTu as répondu correctement à " + correctCount + " question(s) sur " + questions.size()
                + ".\n\n" + (firstCompletion ? "+" + lesson.getXpReward() + " XP gagnés !" : "Cette leçon est déjà terminée : aucun XP supplémentaire.")
                + "\n\nContinue à pratiquer chaque jour !");
        result.setTextSize(22);
        result.setTextColor(Color.rgb(17, 24, 39));
        result.setPadding(0, 20, 0, 28);
        content.addView(result);
        Button back = new Button(getContext());
        back.setAllCaps(false);
        back.setText("Retour aux cours");
        back.setOnClickListener(v -> {
            if (getContext() instanceof Activity) ((Activity) getContext()).setContentView(new CourseScreen(getContext()));
        });
        content.addView(back);
    }
}
