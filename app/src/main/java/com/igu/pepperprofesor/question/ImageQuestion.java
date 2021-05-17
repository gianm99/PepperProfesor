package com.igu.pepperprofesor.question;

import com.igu.pepperprofesor.Subject;

public class ImageQuestion extends Question {
    private final int imageId;

    public ImageQuestion(Subject subject, int id, String question, int imageId) {
        super(subject, id, question);
        this.imageId = imageId;
    }

    @Override
    public QuestionType getQuestionType() {
        return QuestionType.IMAGE;
    }

    public int getImageId() {
        return imageId;
    }
}
