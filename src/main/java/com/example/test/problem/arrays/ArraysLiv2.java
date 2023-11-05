package com.example.test.problem.arrays;

public class ArraysLiv2 {
    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 2, 4, 3};
        System.out.println(maxChunks2(a));
    }

    static int maxChunks2(int[] a) {
        int n = a.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = a[0];
        right[n - 1] = a[n - 1];

        int count;
        for(count = 1; count < n; ++count) {
            left[count] = Math.max(left[count - 1], a[count]);
        }

        for(count = n - 2; count >= 0; --count) {
            right[count] = Math.min(right[count + 1], a[count]);
        }

        count = 0;

        for(int i = 0; i < n - 1; ++i) {
            if (left[i] <= right[i + 1]) {
                ++count;
            }
        }

        return count + 1;
    }

    static int maxChunk1(int[] a) {
        if (a.length == 0) {
            return 0;
        } else {
            int chunks = 0;
            int maxSoFar = a[0];

            for(int i = 0; i < a.length; ++i) {
                maxSoFar = Math.max(maxSoFar, a[i]);
                if (i == maxSoFar) {
                    ++chunks;
                }
            }

            return chunks;
        }
    }

    static void sortArray(int[] a) {
        int low = 0;
        int mid = 0;
        int high = a.length - 1;

        while(mid <= high) {
            if (a[mid] == 2) {
                a[mid] = a[high];
                a[high] = 2;
                --high;
            } else if (a[mid] == 1) {
                ++mid;
            } else if (a[mid] == 0) {
                a[mid] = a[low];
                a[low] = 0;
                ++low;
                ++mid;
            }
        }

    }
}
