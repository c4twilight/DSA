package com.example.test.problem.collectionframework;

import java.util.Arrays;

public class TwoDSort {
    public static void main(String[] args) {
        int[][] array = {
                {4, 2, 3},
                {1, 2, 3},
                {3, 1},
                {1, 2, 1},
                {4, 1, 5}
        };

        // Sort the 2D array based on columns
        Arrays.sort(array, (o1, o2) -> {
            int minLength = Math.min(o1.length, o2.length);
            for (int i = 0; i < minLength; i++) {
                if (o1[i] != o2[i]) {
                    return Integer.compare(o1[i], o2[i]);
                }
            }
            return Integer.compare(o1.length, o2.length);
        });

        // Print the sorted array
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
    }
}
