package com.example.test.problem.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysL2 {
    public static void main(String[] args) {
        int[] a = new int[]{12, 9, 8, 2, 11, 5, 4, 5};
        System.out.println(absMaximumDiff(a));
    }

    static int absMaximumDiff(int[] a) {
        int n = a.length;
        int minaipi = Integer.MAX_VALUE;
        int maxaipi = Integer.MIN_VALUE;
        int minaimi = Integer.MAX_VALUE;
        int maxaimi = Integer.MIN_VALUE;

        int diffaipi;
        for(diffaipi = 0; diffaipi < n; ++diffaipi) {
            minaipi = Math.min(minaipi, a[diffaipi] + diffaipi);
            maxaipi = Math.max(maxaipi, a[diffaipi] + diffaipi);
            minaimi = Math.min(minaimi, a[diffaipi] - diffaipi);
            maxaimi = Math.max(maxaimi, a[diffaipi] - diffaipi);
        }

        diffaipi = maxaipi - minaipi;
        int diffaimi = maxaimi - minaimi;
        return Math.max(diffaipi, diffaimi);
    }

    static List<List<Integer>> minimumDiff(int[] a) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(a);
        int n = a.length;
        int minDiff = Integer.MAX_VALUE;

        int i;
        for(i = 1; i < n; ++i) {
            minDiff = Math.min(minDiff, a[i] - a[i - 1]);
        }

        for(i = 1; i < n; ++i) {
            if (a[i] - a[i - 1] == minDiff) {
//                List<Integer> temp = new ArrayList();
//                temp.add(a[i - 1]);
//                temp.add(a[i]);
//                ans.add(temp);
                ans.add(Arrays.asList(a[i - 1], a[i]));
            }
        }

        return ans;
    }
}
