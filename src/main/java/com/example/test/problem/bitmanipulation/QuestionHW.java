package com.example.test.problem.bitmanipulation;

import java.util.HashSet;
import java.util.Set;

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
    Excel Column Number
    Given a column title A as appears in an Excel sheet, return its corresponding column number.
    For example:
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...
     */
    public long titleToNumber(String s) {
        //You can code here
        long colNum = 0, postionValue = 1;
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            int charValue = (int) (s.charAt(i) - 'A') + 1;
            colNum += postionValue * charValue;
            postionValue *= 26;
        }
        return colNum;
    }
    /*
    Add Binary String
    Given two binary strings a and b of length m and n respectively,
    return their sum as a binary string. A binary string is a string which consists of
    only ‘0’ and ‘1’ as characters. Each string does not contain leading zeros except for the zero itself.
     */
    public String addBinary(String a, String b) {
        //You can code here
        StringBuilder sb = new StringBuilder();
        int i= a.length()-1, j = b.length()-1, carry = 0;
        while(i >=0 || j>= 0 || carry != 0){
            int sum =0;
            sum += (i>= 0) ? (int)(a.charAt(i--) -'0'):0;
            sum += j >= 0 ? (int)(b.charAt(j--) -'0') :0;
            sum += carry;
            carry = sum/2;
            char anspart = (char)(sum%2 + '0');
            sb.append(anspart);
        }
        sb.reverse();
        return sb.toString();
    }
    /*
    Find Location
    Implement a function that takes two strings as input (s and x) and returns the first 0-based
    index of x within s. Return -1 if x is not found.
    You are not allowed to use any in-built functions to solve this problem.
     */
    public static int findLocation(String s, String x){
        int n = s.length(), m = x.length();

        for(int i=0; i<n; i++){
            int j=0;
            for(; j<m; j++){
                if(s.charAt(i+j) != x.charAt(j)){
                    break;
                }
            }
            if(j == m){
                return i;
            }
        }
        return -1;
    }

    /*
    Unique Number II                                    date : 27-10-23
    Find the unique number that appears only once in an array where all other elements appear three times,
     using a linear runtime complexity and constant extra space.
     */
    public int singleNumberII(int[] nums){
        //You can code here
        int ans = 0, n = nums.length;
        for(int i=0; i<32; i++){
            int count = 0;
            for(int num : nums){
                if((num & (1<< i)) != 0){
                    count++;
                }
            }
            if(count % 3 != 0){
                ans = ans | 1 << i;
            }
        }
        return ans;
    }
    /*
    Set the kth Bit
    Problem Statement
Given a number N and a value K. From the right, set the Kth bit in the binary representation of N.
 The position of the Least Significant Bit(or last bit) is 0, the second last bit is 1 and so on.
     */
    public static int setKthBit(int N,int K){
        //You can code here
        return N | (1<<K);

    }
    /*
    Get the kth Bit
    Problem Statement
Given a number N and a bit number K, check if Kth index bit of N is set or not.
 A bit is called set if it is 1. Position of set bit '1' should be indexed starting with
  0 from LSB side in binary representation of the number.
     */
    public static boolean getKthBit(int N,int K){
        return (N & (1 << K)) != 0;
    }

    /*
    Different Sum Bits Pairwise
    Problem Statement
We define f(X, Y) as the number of different corresponding bits in the binary representation of X and Y.



For example, f(2, 7) = 2, since the binary representations of 2 and 7 are 010 and 111, respectively. The first and the third bits differ, so f(2, 7) = 2.



You are given an array of N positive integers, A1, A2,..., AN. Find the sum of f(Ai, Aj)
for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.
     */
    static int mod = (int) (1e9+7);
    public int cntBits(int[] nums){

        long ans = 0; // Use long to avoid integer overflow
        int n = nums.length;
        for (int i = 0; i < 32; i++) {
            long k = 0;
            for (int num : nums) {
                if ((num & (1 << i)) != 0) {
                    k++;
                }
            }
            ans += (k * (n - k) * 2) % mod; // Take modulo operation
            ans %= mod; // Take modulo operation
        }
        return (int) ans; // Cast long to int before returning
    }

    /*
    Count the Number of Set Bits
    Problem Statement
    Given a positive integer N, return the number of set bits in it.
     */
    public static int getCountofSetBits(int N) {
        int count = 0;
        while (N != 0) {
            N = N & (N - 1);
            count++;
        }
        return count;
    }
    /*
    Clear Bits in the Given Range
    Problem Statement
Given a non-negative number n and two values l and r, where l and r are based on 1-based indexing.
 The problem is to unset the bits in the range l to r in the binary representation of n, i.e,
  to unset bits from the rightmost lth bit to the lefttmost rth bit.
     */
    public static int clearBitsInGivenRange(int n, int l, int r){
        int a = (~0 << (r));
        int b = (1<< l-1) -1;
        int mask  = a | b;
        return n & mask;

    }

    /*
    Check Prime Number
    Problem Statement
For a given number N check if it is prime or not. A prime number is a number
which is only divisible by 1 and itself.
Return 1 if the number is prime else return 0.
     */
    public static int isPrime(int n){
        //You can code here
        if(n <2){
            return 0;
        }
        for(int i=2; i*i<=n; i++){
            if(n%i == 0){
                return 0;
            }
        }
        return 1;
    }

    /*
    Check if the number is Power of 2
    Problem Statement
Given a non-negative integer N. The task is to check if N is a power of 2.
 More formally, check if N can be expressed as 2x for some integer x.
  Return true if N is power of 2 else return false.
     */
    public static boolean isPowerofTwo(long n){
        return (n & (n-1)) == 0 ;
    }

    /*
    Decimal to Binary
    Problem Statement
     Given a decimal number N, compute its binary equivalent and return as a String.
     */
    public static String toBinary(int N) {
        //You can code here
        StringBuilder sb = new StringBuilder();
        while(N != 0){
            int bit = N & 1;
            N = N >> 1;
            sb.append(bit);
        }
        sb.reverse();
        return sb.toString();
    }

    /*
    Flight Range Bookings imp.
    Problem Statement
There are n flights that are labeled from 1 to n.
You are given an array of flight  bookings, where bookings[i] = [firsti, lasti, seatsi] represents
 a booking for flights firsti through lasti (inclusive) with seatsi seats reserved for each flight
  in the range.
Return an array answer of length n, where answer[i] is the total number of seats reserved for flight i.
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int ans[] = new int[n];
        for(int [] booking : bookings){
            ans[booking[0]-1] += booking[2];
            if(booking[1] < n){
                ans[booking[1]] -= booking[2];
            }
        }

        for(int i=1; i< n; i++){
            ans[i] += ans[i-1];
        }
        return ans;
    }

    /*
    Power of Two Integers
    Given a positive integer that fits in a 32-bit signed integer, find if it can be expressed as A^P
     where P > 1 and A > 0. A and P both should be integers.
     */
    public boolean isPowerTwoInteger(int x) {
        double p = 2;
        double i;
        if (x == 1) return true;
        for (i = 2; (i < 33) && (p <= (double) (Math.pow(2, 16))); i++) {
            if (Math.pow(p, i) == (double) x) return true;
            if (Math.pow(p, i) >= (Math.pow(2, 32))) {
                i = 1;
                p++;
            }
        }
        return false;
      /*
      easy way but more time
      if(x==1) return true;
      for (int a = 2; a <= Math.sqrt(x); a++) {
          int p = 2;
          int curr = (int) Math.pow(a, p);
          while (curr <= x && curr > 0) {
              if (curr == x) return true;
              p++;
              curr = (int) Math.pow(a, p);
          }
      }
      return false;
      */
    }
        /*
        Sorted Permutation Rank
        Problem Statement
       Given a String, A. Find the rank of the string amongst its permutations sorted lexicographically.
      Assume that no characters are repeated.
       Note: The answer might not fit in an integer, so return your answer % 105+3
         */
        public static int findRank(String A) {
            int mod = (int) (1e5+3);
            int len = A.length();
            int rank = 1;

            if (len <= 1) {
                return 1;
            }

            int factorial = 1;

            for (int i = len - 2; i >= 0; i--) {
                int smallerCharsCount = countSmallerCharsOnRt(A, len - 1, i);
                rank = (rank + (smallerCharsCount * factorial) % mod) % mod;

                // Update factorial for the next iteration
                factorial = (factorial * (len - i)) % mod;
            }

            return rank;

        }

    private static int countSmallerCharsOnRt(final String A, final int end, final int start) {
        int i = start + 1, count = 0;
        while (i <= end) {
            if ((int) A.charAt(i) < (int) A.charAt(start)) {
                count += 1;
            }
            i += 1;
        }
        return (count);
    }

    private static int fact(int n) {
        if ((n == 0) || (n == 1)) {
            return (1);
        }
        if (n < 0) {
            n = -n;
        }
        int f = 1;
        while (n > 0) {
            f = (f * n) % mod;
            n -= 1;
        }
        return (f);
    }
    /*
    Maximum AND Value
    Given an array arr[] of N positive elements. The task is to find the Maximum AND Value generated by any pair(arri, arrj) from the array such that i != j.
Note: AND is bitwise '&' operator.
     */
    public int maxAND (int arr[], int N) {
       //fill the code
        return 1;
    }

    /*
    Max Xor
    Given an array of N integers, fnd the two numbers within the set that
     have the maximum XOR value and return that value.
     */
    public int findMaximumXOR(int[] nums){
        int maxResult = 0;
        int mask = 0;
        /*The maxResult is a record of the largest XOR we got so far. if it's 11100 at i = 2, it means
        before we reach the last two bits, 11100 is the biggest XOR we have, and we're going to explore
        whether we can get another two '1's and put them into maxResult

        This is a greedy part, since we're looking for the largest XOR, we start
        from the very begining, aka, the 31st postition of bits. */
        for (int i = 31; i >= 0; i--) {

            //The mask will grow like  100..000 , 110..000, 111..000,  then 1111...111
            //for each iteration, we only care about the left parts
            mask = mask | (1 << i);

            Set<Integer> set = new HashSet<>();
            for (int num : nums) {

/*                we only care about the left parts, for example, if i = 2, then we have
                {1100, 1000, 0100, 0000} from {1110, 1011, 0111, 0010}*/
                int leftPartOfNum = num & mask;
                set.add(leftPartOfNum);
            }

            // if i = 1 and before this iteration, the maxResult we have now is 1100,
            // my wish is the maxResult will grow to 1110, so I will try to find a candidate
            // which can give me the greedyTry;
            int greedyTry = maxResult | (1 << i);

            for (int leftPartOfNum : set) {
                //This is the most tricky part, coming from a fact that if a ^ b = c, then a ^ c = b;
                // now we have the 'c', which is greedyTry, and we have the 'a', which is leftPartOfNum
                // If we hope the formula a ^ b = c to be valid, then we need the b,
                // and to get b, we need a ^ c, if a ^ c exisited in our set, then we're good to go
                int anotherNum = leftPartOfNum ^ greedyTry;
                if (set.contains(anotherNum)) {
                    maxResult= greedyTry;
                    break;
                }
            }

            // If unfortunately, we didn't get the greedyTry, we still have our max,
            // So after this iteration, the max will stay at 1100.
        }

        return maxResult;
    }

    /*
    Decimal to Binary for negative number
    Problem Statement
     Given a decimal number N, compute its binary equivalent and return as a String.
     */
    public static String toBinaryForNegative(int N) {
        // fill the code
        return null;
    }
}

