package com.example.test.problem445;

import java.util.*;

public class Longest_K_unique_characters_substring {
    public int longestkSubstr(String str, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int n = str.length(), j =0, maxLength = -1;
        for(int i=0; i<n; i++){
            hm.put(str.charAt(i), hm.getOrDefault(str.charAt(i), 0)+1);
            if(hm.size() == k){
                maxLength = Math.max(maxLength, i -j +1);
            }
            else if(hm.size() > k){
                while(i>=0 && hm.size() > k){
                    hm.put(str.charAt(j), hm.getOrDefault(str.charAt(j), 0)-1);
                    if(hm.get(str.charAt(j)) == 0){
                        hm.remove(str.charAt(j));
                    }
                    j++;
                }
            }
        }
        return maxLength;
    }

    public static int maxLenAtMostKdistinctChar(int k, String str) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int n = str.length(), leftIndex =0, maxLength = 0;
        for(int i=0; i<n; i++){
            hm.put(str.charAt(i), hm.getOrDefault(str.charAt(i), 0)+1);
            while(hm.size() > k){
                hm.put(str.charAt(leftIndex), hm.getOrDefault(str.charAt(leftIndex), 0)-1);
                if(hm.get(str.charAt(leftIndex)) == 0){
                    hm.remove(str.charAt(leftIndex));
                }
                leftIndex++;
            }
            maxLength = Math.max(maxLength, i -leftIndex +1);
        }
        return maxLength;
    }
}
