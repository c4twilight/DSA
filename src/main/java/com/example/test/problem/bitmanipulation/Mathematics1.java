package com.example.test.problem.bitmanipulation;

import java.util.Arrays;

public class Mathematics1 {
    public static void main(String[] args) {
//        System.out.println(isPrime(17));
//        int n = 1000;
//        boolean isPrime[] = sieveOfEratosthenes(n);
//        for(int i = 0; i<=n; i++) {
//            if(isPrime[i]) {
//                System.out.println(i);
//            }
//        }
        int a = 240;
        int b = 360;
        System.out.println(gcd(a, b));
    }

    static int gcd(int a , int b) {
//        if(b == 0) return a;
//        return gcd(b, a%b);

        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    static boolean isPrime(int n) {
        for(int i = 2; i*i <= n; i++) {
            if(n % i  == 0) return false;
        }
        return true;
    }

    static int[] primeQueries(int q[][]) {
        int n = q.length;
        int length = 0;
        for(int i = 0; i<n; i++) {
            length = Math.max(length, q[i][1]);
        }
        boolean isPrime[] = sieveOfEratosthenes(length);
        int count[] = new int[length+1];
        for(int i = 1; i<=length; i++) {
            count[i] = isPrime(i) ? count[i-1]+1 : count[i-1];
        }
        int ans[] = new int[n];
        for(int i = 0; i<n; i++) {
            int leftCount = count[q[i][0]-1];
            int rightCount = count[q[i][1]];
            ans[i] = rightCount - leftCount;
        }
        return ans;
    }

    static boolean[] sieveOfEratosthenes(int n) {
        boolean isPrime[] = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i*i <= n; i++) { // O(n * log log n)
            for(int j = i*i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
        return isPrime;
    }
}
