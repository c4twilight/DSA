package com.example.test.problem445;

import java.util.Scanner;

public class Basic1 {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);
        System.out.print(isAlpha(ch));
    }
    /*
    
     */
    private static int isAlpha(char ch){
        if(ch>='A' && ch <= 'Z'){
            return 1;
        }
        else if(ch>='a' && ch <= 'z'){
            return 0;
        }
        return -1;
    }

    /*Sum of all divisors
    Problem Statement
    Send feedback
    You are given an integer 'n'
    Function 'sumOfDivisors (n)' is defined as the sum of all divisors of 'n'.
    Find the sum of 'sumOfDivisors (i)' for all 'i' from 1 to 'n'.
    Example:
    Input: 'n' = 5
    Output: 21
    Explanation:
    We need to find the sum of 'sumOfDivisors (i)' for all i' from 1 to
            5.
            'sumOfDivisors (1)' = 1
            'sumOfDivisors (2) = 2 + 1 = 3
            'sumOfDivisors (3)' = 3 + 1 = 4
            'sumOfDivisors (4) = 4+2 +1 = 7
            'sumOfDivisors (5) = 5 + 1 = 6
    Therefore our answer is sumOfDivisors (1) + sumOfDivisors (2) + sumOfDivisors (3) + sumOfDivisors (4) + sumOfDivisors (5) = 1 + 3 + 4 +7 +6 = 21.*/
    public static int sumOfAllDivisors(int n){
        // Write your code here.
        /*
        2nd approch
        int sum = 0;
        for(int i=1; i<=n; i++){
            sum += i * (n/i);
        }
        return sum;
        */

        //optimize O(logn)
        int ans = 0;
        int l = 1;

        // Iterating over all values of 'l' such that 'n/l' is distinct.
        // There at most 2*sqrt(n) such values.
        while (l <= n)
        {
            int val = n / l;

            // 'r' = maximum value of 'i' such that 'n/i' is val.
            int r = n / val;

            ans += ((r * (r + 1)) / 2 - (l * (l - 1)) / 2) * val;

            // moving on to next range.
            l = r + 1;
        }

        return ans;

    }
    private static int sumofDivisor(int n){
        int sum = 0;
         for(int i=1; i*i <= n; i++){
             if(n%i == 0){
                 sum += i + ((i != n/i)? n/i :0);
             }
         }
         return sum;
    }
    public static int leastWeightCapacity(int[] weights, int days) {
        int sum =0,maxLoad =0;
        for(int weight : weights){
            sum += weight;
            maxLoad = Math.max(maxLoad, weight);
        }
        int low = maxLoad, high = sum;

        while(low < high){
            int  mid  = low + (high - low)/2;

            if(canShipAllWithinDays(weights,mid ,days)){
                // this mid can be the ans but we check for better ans that why we include mid in high
                high = mid ;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
    private static boolean canShipAllWithinDays(int[] weights, int capacity, int days) {
        int currentDay = 1, currentWeight = 0;
        for (int weight : weights) {
            if (currentWeight + weight <= capacity) {
                currentWeight += weight;
            } else {
                currentWeight = weight;
                currentDay++;
            }
            if (currentDay > days) {
                return false;
            }
        }
        return true;
    }

}
