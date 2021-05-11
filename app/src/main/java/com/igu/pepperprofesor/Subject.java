package com.igu.pepperprofesor;

public enum Subject {
    CASTELLANO(40),
    MATEMATICAS(40),
    SOCIALES(53);

    private final int size;

    Subject(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
