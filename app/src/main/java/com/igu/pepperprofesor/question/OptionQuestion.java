package com.igu.pepperprofesor.question;

import com.igu.pepperprofesor.Subject;

import java.util.List;

public class OptionQuestion extends Question {
    private final List<Option> optionList;

    public OptionQuestion(Subject subject, int id, String question, List<Option> optionList) {
        super(subject, id, question);
        this.optionList = optionList;
    }

    @Override
    public QuestionType getQuestionType() {
        return QuestionType.OPTION;
    }

    public List<Option> getOptionList() {
        return optionList;
    }
}
