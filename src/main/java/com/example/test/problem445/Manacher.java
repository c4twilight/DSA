package com.example.test.problem445;

/**
 * refer : https://www.youtube.com/watch?v=ei7qghJEj4Y&t=220s&ab_channel=VivekGupta
 */
public class Manacher {
    private final StringBuilder processedString;
    private final int[] palindromeLengths;
    private int longestPalindromeStart, longestPalindromeLength;

    public Manacher(String inputString) {
        int n = inputString.length();
        this.processedString = preprocessInputString(inputString);
        this.longestPalindromeLength = 0;
        this.longestPalindromeStart = 0;
        palindromeLengths = new int[2*n+1];
        precomputePalindromeLengths();
    }

    private StringBuilder preprocessInputString(String inputString) {
        StringBuilder processed = new StringBuilder();
        for (char ch : inputString.toCharArray()) {
            processed.append("#").append(ch);
        }
        processed.append('#');
        return processed;
    }

    private void precomputePalindromeLengths() {

        int n = processedString.length();
        int left = 1, right = 1;

        for (int i = 1; i < n; i++) {
            if (left + right - i >= 0) {
                int value = Math.max(1, Math.min(right - i, palindromeLengths[left + right - i]));
                palindromeLengths[i] = value;
            }

            while ((i - palindromeLengths[i] >= 0 && i + palindromeLengths[i] < n) &&
                    processedString.charAt(i - palindromeLengths[i]) == processedString.charAt(i + palindromeLengths[i])) {
                palindromeLengths[i]++;
            }

            if (i + palindromeLengths[i] > right) {
                left = i - palindromeLengths[i];
                right = i + palindromeLengths[i];
                //System.out.println(longestPalindromeStart +"  "+longestPalindromeLength +" " +palindromeLengths[i]);
                if (longestPalindromeLength < palindromeLengths[i]-1) {
                    longestPalindromeStart = left + 2;
                    longestPalindromeLength = palindromeLengths[i] - 1;
                }
            }
        }
    }

    public int getPalindromeLength(int center, boolean isOddLength) {
        int position = 2 * center + 1 + (isOddLength ? 0 : 1);
        return palindromeLengths[position] - 1;
    }

    public boolean isPalindrome(int originalLeft, int originalRight) {
        int processedLeft = 2 * originalLeft + 1;
        int processedRight = 2 * originalRight + 1;
        return (processedRight - processedLeft + 1) <= getPalindromeLength((originalLeft + originalRight) / 2, originalLeft % 2 == originalRight % 2);
    }

    public String findLongestPalindromeSubstring() {
        //System.out.println(longestPalindromeStart +"  "+longestPalindromeLength);
        int n = processedString.length();
        StringBuilder longestPalindrome = new StringBuilder();
        for (int i = longestPalindromeStart; (i < n && longestPalindromeLength-- > 0); i += 2) {
            longestPalindrome.append(processedString.charAt(i));
        }
        return longestPalindrome.toString();
    }
    public int countSubstrings() {
        int count = 0;
        int n = processedString.length();
        for(int i = 1; i < n - 1; i++) {
            count += func(palindromeLengths[i]-1);
        }
        return count;
    }
    public int func(int n) {
        return (n + 1) >> 1;
    }

}
