package com.example.test.problem445;

public class Kmp_Algo {
    private int[] computeTemporaryArray(char pattern[]){
        int patterntLen = pattern.length;
        int [] lps = new int[pattern.length];
        int index =0;
        for(int i=1; i < patterntLen;){
            if(pattern[i] == pattern[index]){
                lps[i] = index + 1;
                index++;
                i++;
            }else{
                if(index != 0){
                    index = lps[index-1];
                }else{
                    lps[i] =0;
                    i++;
                }
            }
        }
        return lps;
    }

    /**
     * KMP algorithm of pattern matching.
     */
    public boolean KMP(char []text, char []pattern){
        int textLen = text.length, patterntLen = pattern.length;
        int lps[] = computeTemporaryArray(pattern);
        int i=0;
        int j=0;
        while(i < textLen && j < patterntLen){
            if(text[i] == pattern[j]){
                i++;
                j++;
            }else{
                if(j!=0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        if(j == pattern.length){
            return true;
        }
        return false;
    }
}
