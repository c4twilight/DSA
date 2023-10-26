package com.example.test.problemofday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Problems {
    /*
    Longest Substring Without Repeating Character
    Given a string s, find the length of the longest
     substring without repeating characters.
     */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();

        int left = 0, right = 0, length = 0, n = s.length();
        while (right < n) {
            if (hm.containsKey(s.charAt(right))) {
                left = Math.max(hm.get(s.charAt(right)) + 1, left);
            }
            length = Math.max(length, right - left + 1);
            hm.put(s.charAt(right), right);
            right++;
        }
        return length;
    }
    /*
    Generate Binary Numbers
    Given a number N. The task is to generate all the binary numbers with from 1 to N.
     */
    public static ArrayList<String> generate(int N){
        ArrayList<String>  ans = new ArrayList<>();
        Queue<String> que = new LinkedList<>();
        que.offer("1");
        for(int i=0; i<N; i++){
            String ansValues = que.poll();
            ans.add(ansValues);
            que.offer(ansValues+"0");
            que.offer(ansValues+"1");
        }
        return ans;
    }
    /*Balanced Parantheses                   date: 26-10-23
    Given a string A consisting only of '(' and ')'.
    You need to find whether parentheses in A are balanced or not, if it is balanced
     then return 1 else return 0.
     */
    public int isBalanced(String A) {
        //You can code here
        int openBracketCnt = 0;

        for(char ch : A.toCharArray()){
            if( ch == '('){
                openBracketCnt++;
            }
            else{
                if(openBracketCnt == 0){
                    return 0;
                }
                openBracketCnt--;
            }
        }
        return (openBracketCnt == 0) ? 1 : 0;
    }
    /*
    Trailing Zeroes in Factorial            date: 27-10-23
    Given an integer n, return the number of trailing zeroes in n!.
     */
    public int trailingZeroes(int n) {
        int zero =0;
        while(n != 0){
            n /= 5;
            zero += n;
        }
        return zero;
    }

}
