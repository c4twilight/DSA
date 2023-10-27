package com.example.test.problem.BitManipulation;

public class Assignment {
    /*
    Binary to Decimal
    Given a Binary Number B in a String format, return its decimal equivalent.
     */
    public int toDecimal(String str) {
            int dec = 0;
            for (int i = 0; i < str.length(); i++) {
                dec <<= 1;
                dec |= str.charAt(i) - '0'; // Use '0' to convert the character to an integer
            }
            return dec;
        /*int ans =0 , num =1;
        for(int i=str.length() -1 ; i>=0; i--){
            if(str.charAt(i) == '1'){
                ans +=  num;
            }
            num *= 2;
        }
        return ans; */
    }
}
