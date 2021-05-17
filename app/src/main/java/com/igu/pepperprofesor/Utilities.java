package com.igu.pepperprofesor;

import java.util.Random;

public class Utilities {
    public static int[] randomNumbers(int lower, int upper, int count) {
        Random rng = new Random();
        int[] result = new int[count];
        int current = 0;
        int remaining = upper - lower;
        for (int i = lower; i < upper && count > 0; i++) {
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
