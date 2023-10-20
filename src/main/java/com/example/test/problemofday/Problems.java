package com.example.test.problemofday;

import java.util.HashMap;

public class Problems {
    /*
    Longest Substring Without Repeating Character
    Given a string s, find the length of the longest
     substring without repeating characters.
     */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();

        int left = 0, right = 0, length = 0, n = s.length();
        while(right < n ){
            if(hm.containsKey(s.charAt(right))){
                left = Math.max(hm.get(s.charAt(right))+1 , left);
            }
            length = Math.max(length, right - left + 1);
            hm.put(s.charAt(right),right);
            right++;
        }
        return length;
    }
}
