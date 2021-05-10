package com.igu.pepperprofesor;

public enum Subject {
    CASTELLANO(1, 40), MATEMATICAS(41, 81), SOCIALES(82, 135);

    private final int lower;
    private final int upper;

    Subject(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public int getLower() {
        return lower;
    }

    public int getUpper() {
        return upper;
    }
}
