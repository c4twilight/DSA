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
}
