package com.igu.pepperprofesor.object;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

public enum Subject {
    CASTELLANO(40){
        @NonNull
        @NotNull
        @Override
        public String toString() {
            return "CASTELLANO";
        }
    },
    MATEMATICAS(38){
        @NonNull
        @NotNull
        @Override
        public String toString() {
            return "MATEMATICAS";
        }
    },
    SOCIALES(50){
        @NonNull
        @NotNull
        @Override
        public String toString() {
            return "SOCIALES";
        }
    };

    private final int size;

    Subject(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public static int getCombinedSize() {
        int size = 0;
        for (Subject s : Subject.values()) {
            size += s.size;
        }
        return size;
    }
}
