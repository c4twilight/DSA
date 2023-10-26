package com.example.test.problem.arrayfunctionstring;

public class BasicArrayProblems {
    public static void main(String[] args) {
        int[] a = new int[]{2, 5, 6, 8, 9, 1};
        lastNumberInSortedPosition(a);
        int[] var2 = a;
        int var3 = a.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            int e = var2[var4];
            System.out.print("" + e + " ");
        }

    }

    static void lastNumberInSortedPosition(int[] a) {
        int n = a.length;
        int last = a[n - 1];

        int swapIndex = n - 2;
        while (swapIndex >= 0 && a[swapIndex] > last) {
            a[swapIndex + 1] = a[swapIndex];
            swapIndex--;
        }

        a[swapIndex + 1] = last;


        //cnt + alt+L for formating the selected block of code in intellij
    }
}
