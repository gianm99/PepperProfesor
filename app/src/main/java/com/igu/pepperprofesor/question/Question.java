package com.igu.pepperprofesor.question;

import android.annotation.SuppressLint;

import com.igu.pepperprofesor.Subject;

import java.util.Locale;

public class Question {
    private final int id;
    private final Subject subject;
    private final String question;

    Question(Subject subject, int id, String question) {
        this.id = id;
        this.subject = subject;
        this.question = question;
    }

    public String getBookmark() {
        return String.format(Locale.ENGLISH, "%%%s%d", subject, id);
    }

    public QuestionType getQuestionType() {
        return QuestionType.NORMAL;
    }

    public String getQuestionText() {
        return question;
    }

    public Subject getSubject() {
        return subject;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }
}
