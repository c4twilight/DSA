package com.example.test.problem.BitManipulation;

public class QuestionHW {
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
        /*
         trick
         The maximum power of 3 value that
           integer can hold is 1162261467 ( 3^19 )
            return n > 0 && 1162261467 % n == 0;
         */

    }

    /*Unique Number
    Find the unique element in a non-empty array of integers where
    all other elements appear twice, using a linear runtime complexity and constant extra space.
     */
    public int singleNumber(int[] arr)
    {
        //You can code here
        int ans = 0;
        for(int a : arr){
            ans ^= a;
        }
        return ans;
    }
    /*
    Largest Coprime Divisor
    You are given two positive numbers A and B. You need to find the maximum valued integer X such that:
    X divides A i.e. A % X = 0
    X and B are co-prime i.e. gcd(X, B) = 1
     */
    public static int cpFact(int a, int b)
    {
        //You Can Code Here
        while (gcd(a, b) != 1) {
            a = a / gcd(a, b);
        }
        return a;
    }
    private static int gcd(int a, int b){
        if(a > b){
            int temp = a;
            a = b;
            b = temp;
        }
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    /*
    Max Xor
    Given an array of N integers, fnd the two numbers within
    the set that have the maximum XOR value and return that value.
     */
    public int findMaximumXOR(int[] nums){
        //You can code here
        return 1;
    }

}

