package com.example.test.problem.arrays;

import java.util.*;

public class ArraysL3 {
    public static void main(String[] args) {
        int[] a = new int[]{4, 2, 2, 2, 1, 1, 1, -1, -3, 0, 1, 2, 3, 3, 3};
        Arrays.sort(a);
        List<List<Integer>> triplets = new ArrayList();

        for(int i = 0; i < a.length - 2; ++i) {
            if (i <= 0 || a[i] != a[i - 1]) {
                List<List<Integer>> temp = twoSum(a, -a[i], i + 1);
                Iterator var5 = temp.iterator();

                while(var5.hasNext()) {
                    List<Integer> list = (List)var5.next();
                    list.add(0, a[i]);
                    triplets.add(list);
                }
            }
        }

        System.out.println(triplets);
    }

    static List<List<Integer>> twoSum(int[] a, int sum, int startFrom) {
        int l = startFrom;
        int r = a.length - 1;
        List<List<Integer>> ans = new ArrayList();

        while(true) {
            while(l < r) {
                if (l > startFrom && a[l] == a[l - 1]) {
                    ++l;
                } else if (r < a.length - 1 && a[r] == a[r + 1]) {
                    --r;
                } else if (a[l] + a[r] > sum) {
                    --r;
                } else if (a[l] + a[r] < sum) {
                    ++l;
                } else {
                    List<Integer> temp = new ArrayList();
                    temp.add(a[l]);
                    temp.add(a[r]);
                    ans.add(temp);
                    ++l;
                    --r;
                }
            }

            return ans;
        }
    }
}
