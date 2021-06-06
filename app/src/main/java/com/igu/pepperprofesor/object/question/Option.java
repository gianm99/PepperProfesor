package com.igu.pepperprofesor.object.question;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class Option implements Serializable {
    private final char letter;
    private final String text;

    public Option(char letter, String text) {
        this.letter = letter;
        this.text = text;
    }

    public char getLetter() {
        return letter;
    }

    public String getText() {
        return text;
    }

    @NonNull
    @NotNull
    @Override
    public String toString() {
        return String.format("%c) %s\n", Character.toUpperCase(letter), text);
    }
}
