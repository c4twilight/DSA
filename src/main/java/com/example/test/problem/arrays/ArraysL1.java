package com.example.test.problem.arrays;

import java.util.Arrays;

public class ArraysL1 {
    public static void main(String[] args) {
        int[] a = new int[]{6, 1, 2, 9, 4, 7};
        waveArrayNotLexographic(a);
        printArray(a);
    }

    static void waveArray(int[] a) {
        Arrays.sort(a);
        int n = a.length;

        for(int i = 1; i < n; i += 2) {
            swap(a, i, i - 1);
        }

    }

    static void waveArrayNotLexographic(int[] a) {
        int n = a.length;

        for(int i = 1; i < n; i += 2) {
            if (a[i] > a[i - 1]) {
                swap(a, i, i - 1);
            }

            if (i < n - 1 && a[i] > a[i + 1]) {
                swap(a, i, i + 1);
            }
        }

    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static int[][] multipleRotations(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int[][] ans = new int[m][n];
        int[] temp = new int[2 * n];

        for(int i = 0; i < n; ++i) {
            temp[i] = a[i];
            temp[i + n] = a[i];
        }

        for(int i = 0; i < m; ++i) {
            int offset = b[i] % n;

            for(int j = 0; j < n; ++j) {
                ans[i][j] = temp[j + offset];
            }
        }

        return ans;
    }

    static void printArray(int[] a) {
        int[] var1 = a;
        int var2 = a.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            int e = var1[var3];
            System.out.print("" + e + " ");
        }

    }

    static void rotateByK(int[] a, int k) {
        int n = a.length;

        for(int i = 0; i < k; ++i) {
            int temp = a[0];

            for(int j = 0; j < n - 1; ++j) {
                a[j] = a[j + 1];
            }
            a[n - 1] = temp;
        }

    }
     int[][] multipleRotationsMyWay(int[] a, int[] b) {
        //without extra space.
        int n = a.length;
        int m = b.length;
        int[][] ans = new int[m][n];
        for(int i=0; i<m; i++){
            ans[i] = a.clone();
            rotate(ans[i], b[i]);
        }
        return ans;
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        // clockwise
        reverse(nums,0, n-1);
        reverse(nums,0, k-1);
        reverse(nums,k, n-1);

        // if it was anticlock wise rotation  question
        // reverse(nums,0, n-1);
        // reverse(nums,0, n-1-k);
        // reverse(nums,n-k, n-1);

    }
    public void reverse(int[] nums,int s, int e){
        while(s<e){
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;

            s++; e--;
        }

    }
}
