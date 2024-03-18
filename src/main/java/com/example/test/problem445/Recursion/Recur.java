package com.example.test.problem445.Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recur {
    public static void main(String[] args) {
        int ans = countOccurrences("hi world, hi leetcoder ","hi");
        System.out.println(ans);
    }

    // Problem statement Count occurrences of a word in string
    public static int countOccurrences(String text, String word){
        return countOccurrences(text, word, 0);
    }

    public static int countOccurrences(String text, String word, int index) {
        if(index > text.length()-word.length()){
            return 0;
        }
        int subProblem = countOccurrences(text, word, index+1);
        if(checkStartingSubString(index, text,word)){
            return 1 + subProblem;
        }
        return subProblem;

    }

    private static boolean checkStartingSubString(int index, String text, String word){
        for(int i = 0; i<word.length(); i++){
            if(text.charAt(i+index) != word.charAt(i)){
                return false;
            }
        }
        return true;
    }

    /*2.Problem Statement
    Given a string, write a program to output every non-empty substring of the given string in a Lexographically sorted order.
            Input: s = abc
    Output: [a, ab, abc, ac, b, bc, c] */
    public static List<String> findSubstrings(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(0, s, ans, sb);
        Collections.sort(ans);
        return ans;
    }
    private static void helper(int index, String s, List<String>ans, StringBuilder sb){
        if(index >= s.length()){
            if(sb.length() != 0)
                ans.add(new StringBuilder(sb).toString());
            return;
        }
        //take
        sb.append(s.charAt(index));
        helper(index+1, s, ans, sb);
        sb.deleteCharAt(sb.length()-1);

        //not take
        helper(index+1, s, ans, sb);
    }

    //Problem statement: find nCr using recursion
    public int findnCr(int n, int r){
        if(n==r || r == 0){
            return 1;
        }
        return findnCr( n-1, r-1) + findnCr(n-1, r);
    }

    //find nCr without recurr
    public static long nCr(int n, int r) {
        long res = 1;

        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }
}
