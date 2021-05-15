package com.igu.pepperprofesor;

import java.util.Random;

public class Utilities {
    public static int[] randomQuestions(int upper, int count) {
        Random rng = new Random();
        int[] result = new int[count];
        int current = 0;
        int remaining = upper - 1;
        for (int i = 1; i < upper && count > 0; i++) {
            double probability = rng.nextDouble();
            if (probability < ((double) count) / (double) remaining) {
                count--;
                result[current++] = i;
            }
            remaining--;
        }
        return result;
    }

}
