package com.josephmarchand.englishjoe.lessons;

import com.josephmarchand.englishjoe.AppConstants;
import com.josephmarchand.englishjoe.models.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LessonSession {

    private final String lessonId;
    private final List<Question> questions;

    private int currentIndex;
    private int correctAnswers;
    private int wrongAnswers;
    private int earnedXp;
    private boolean finished;

    public LessonSession(String lessonId, List<Question> questions) {
        this.lessonId = lessonId == null ? "" : lessonId;

        if (questions == null) {
            this.questions = new ArrayList<>();
        } else {
            this.questions = new ArrayList<>(questions);
        }

        this.currentIndex = 0;
        this.correctAnswers = 0;
        this.wrongAnswers = 0;
        this.earnedXp = 0;
        this.finished = false;
    }

    public String getLessonId() {
        return lessonId;
    }

    public List<Question> getQuestions() {
        return Collections.unmodifiableList(questions);
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public Question getCurrentQuestion() {
        if (currentIndex < 0 || currentIndex >= questions.size()) {
            return null;
        }

        return questions.get(currentIndex);
    }

    public boolean hasNextQuestion() {
        return currentIndex + 1 < questions.size();
    }

    public void moveNext() {
        if (hasNextQuestion()) {
            currentIndex++;
        } else {
            finished = true;
        }
    }

    public AnswerResult answer(String answer) {
        Question question = getCurrentQuestion();

        if (question == null) {
            return new AnswerResult(
                    false,
                    answer,
                    "",
                    "Cette leçon ne contient plus de question.",
                    0
            );
        }

        boolean correct = question.isCorrect(answer);

        if (correct) {
            correctAnswers++;
            earnedXp += AppConstants.DEFAULT_LESSON_XP;
        } else {
            wrongAnswers++;
        }

        return new AnswerResult(
                correct,
                answer,
                question.getCorrectAnswer(),
                question.getExplanation(),
                correct ? AppConstants.DEFAULT_LESSON_XP : 0
        );
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getWrongAnswers() {
        return wrongAnswers;
    }

    public int getEarnedXp() {
        return earnedXp;
    }

    public int getTotalQuestions() {
        return questions.size();
    }

    public int getProgressPercent() {
        if (questions.isEmpty()) {
            return 0;
        }

        int answered = correctAnswers + wrongAnswers;
        return Math.min(100, (answered * 100) / questions.size());
    }

    public int getScorePercent() {
        if (questions.isEmpty()) {
            return 0;
        }

        return (correctAnswers * 100) / questions.size();
    }

    public boolean isPassed() {
        return getScorePercent() >= AppConstants.PASS_PERCENT;
    }

    public boolean isFinished() {
        return finished;
    }

    public void finish() {
        finished = true;
    }

    public void reset() {
        currentIndex = 0;
        correctAnswers = 0;
        wrongAnswers = 0;
        earnedXp = 0;
        finished = false;
    }
          }
