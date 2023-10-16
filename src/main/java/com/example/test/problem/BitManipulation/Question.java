package com.example.test.problem.BitManipulation;

public class Question {
    /*

  XOR Queries
  1.Problem Statement
   Given an array of positive integers and a set of queries, where each query consists of a range
   [lefti, righti], find the XOR of all elements within that range for each query and return
   an array of the answers.
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        //You can code here
        int n =queries.length, len = arr.length, k=0;
        int [] res = new int [n];
        int [] xor = new int [len];
        xor[0] = arr[0];
        for(int i=1; i<len; i++){
            xor[i] = xor[i-1]^ arr[i];
        }
        for(int [] querie : queries){
            res[k++] = xorFromLtR(xor, querie[0], querie[1]);
        }
        return res;

    }
    private int xorFromLtR(int[] xor,int l, int r){
        int left = l == 0 ? 0 : xor[l-1];
        int right = xor[r];
        return right ^ left;
    }

    /* Power of Three
2.Problem Statement
Given an integer n, return true if it is a power of three. Otherwise, return false.
An integer n is a power of three, if there exists an integer x such that n == 3x.
     */
    public static boolean isPowerOfThree(int n) {
        //You can code here
        if (n <= 0) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    /*

     */
}

