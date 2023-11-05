package com.example.test.problem.arrays;

public class ArraysL4 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 5, 6, 7, 2};
        int target = 16;
        System.out.println(minimumSumSubArray(a, target));
    }

    public static int minimumSumSubArray(int[] a, int target) {
        int l = 0;
        int r = 0;
        int x = -1;
        int y = -1;
        int curSum = 0;
        int minLength = Integer.MAX_VALUE;

        for(int n = a.length; r < n; ++r) {
            for(curSum += a[r]; curSum >= target; ++l) {
                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    x = l;
                    y = r;
                }

                curSum -= a[l];
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            minLength = 0;
        }

        System.out.println("" + x + " " + y);
        return minLength;
    }
}
