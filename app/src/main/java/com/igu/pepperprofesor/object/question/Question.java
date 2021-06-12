package com.igu.pepperprofesor.object.question;

import com.igu.pepperprofesor.object.Subject;

import java.io.Serializable;

public class Question implements Serializable {
    private final int id;
    private final Subject subject;
    private final String question;

    public Question(Subject subject, int id, String question) {
        this.id = id;
        this.subject = subject;
        this.question = question;
    }

    public String getBookmark() {
        return subject.name() + id;
    }

    public QuestionType getQuestionType() {
        return QuestionType.NORMAL;
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
