package com.igu.pepperprofesor.question;

import android.annotation.SuppressLint;

import com.igu.pepperprofesor.Subject;

public class Question {
    private final int id;
    private final Subject subject;
    private final String question;

    Question(Subject subject, int id, String question) {
        this.id = id;
        this.subject = subject;
        this.question = question;
    }

    public QuestionType getQuestionType() {
        return QuestionType.NORMAL;
    }

    public String getQuestionText() {
        return question;
    }

    @SuppressLint("DefaultLocale")
    public String getBookmark() {
        return String.format("%%%s%d", subject, id);
    }
}
