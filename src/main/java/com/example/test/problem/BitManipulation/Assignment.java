package com.example.test.problem.BitManipulation;

import java.util.Collections;
import java.util.List;

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
    /*
    Divide Integers
    Divide two integers, dividend and divisor, without using multiplication, division, or mod operator and return the quotient.
    The integer division should truncate towards zero and if the quotient is outside the 32-bit signed integer range, return the maximum or minimum value of the range.
    For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
    */
    public int divide(int dividend, int divisor){

//        int sign = (dividend < 0) ^ (divisor < 0) ?  -1 :1;
//        dividend = Math.abs(dividend);
//        divisor = Math.abs(divisor);
//        int ans  = 0;
//        while(dividend > divisor){
//            int i = 0, temp = divisor;
//            while(dividend > (temp<<1)){
//                temp = temp <<1;
//                i++;
//            }
//            ans += (1<<i);
//            dividend = dividend - temp;
//        }
//        return sign < 0 ? (0-ans): ans;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = (dividend < 0) ^ (divisor < 0) ?  -1 :1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int result = 0;
        while (dividend- divisor >= 0) {
            int i = 0;
            int temp = divisor;
            while (dividend - (temp << 1) >= 0) {
                temp = temp<<1;
                i++;
            }
            result += 1 << i;
            dividend -= temp;
        }
        return (sign > 0) ? result : 0-result;
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
        // long colNum = 0,postionValue = 1;
        // int n= s.length();
        // for(int i=n-1; i>=0; i--){
        //    int charValue = (int)(s.charAt(i) - 'A')+1;
        //    colNum += postionValue *charValue;
        //    postionValue *= 26;
        // }
        // return  colNum;
        long res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = (long) (res * 26 + s.charAt(i) - 'A' + 1);
        }
        return res;
    }
    /*
    Find Location
    Implement a function that takes two strings as input (s and x) and returns the first 0-based index of x within s. Return -1 if x is not found.
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
    Add Binary String
    Given two binary strings a and b of length m and n respectively, return their sum as a binary string.
    A binary string is a string which consists of only ‘0’ and ‘1’ as characters. Each string does not
    contain leading zeros except for the zero itself.
     */
    public String addBinary(String a, String b){
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
    Length of The Last Word
    Given a string s consisting of words and spaces, return the length of the last word in the string.
    A word is a maximal substring consisting of non-space characters only
     */
    public static int lengthOfLastWord(String s) {
        int end = s.length()-1;
        int lastlen =0;
        while(end >= 0 && s.charAt(end) ==' '){
            end--;
        }

        while(end >= 0 && s.charAt(end) !=' '){
            lastlen++;
            end--;
        }
        return lastlen;
    }

    /*
    Trailing Zeroes in Factorial
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


    /*
    Leetcode version
    29. Divide Two Integers
    Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

     */
    public int divideLeetcode(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = (dividend < 0) ^ (divisor < 0) ?  -1 :1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int result = 0;
        while (dividend- divisor >= 0) {
            int i = 0;
            int temp = divisor;
            while (dividend - (divisor <<1 <<i) >= 0) {
                // edge case divisor << i+1 there is chance of i to overflow and may be that why we get tle so don't use i+1 better to use this  (divisor <<1 <<i);
                i++;
            }
            result += 1 << i;
            dividend -= divisor<<i;
        }
        return (sign > 0) ? result : 0-result;

    }

    /*
    Number of Open Doors
    Consider a long alley with N doors on one side. All the doors are closed initially. You move to and fro in the alley changing the states of the doors as follows:

You open a door that is already closed, and you close a door that is already opened.
You start at one end go on altering the state of the doors till you reach the other end, and then you come back and start altering the states of the doors again.
In the first go, you alter the states of doors numbered 1, 2, 3, …, N.
In the second go, you alter the states of doors numbered 2, 4, 6, ….
In the third go, you alter the states of doors numbered 3, 6, 9 ….
and so on…
The above procedure will continue till the Nth turn in which you alter the state of the door numbered N. The task is to find the number of open doors at the end of the procedure.
     */
    public static int countOpenDoors(int N) {
      /*
      The logic behind the solution is based on the observation that a door will change its state (open/close) when it is visited by a number. And a number will visit a door if the door number is a multiple of the visiting number.

      Here are the key points to understand why this solution works:

      Initial State: Initially, all doors are closed. A door will only open if it is visited an odd number of times.

      Factors: Each door is visited by its factors. For example, Door 6 is visited by 1, 2, 3, and 6.

      Pairing Factors: Factors always come in pairs, except when the number is a perfect square. For example, the factors of 6 are (1,6) and (2,3). The factors of 16 (a perfect square) are (1,16), (2,8), and (4,4).

      Odd Visits: Since factors come in pairs, a door is usually visited an even number of times - which means the door will end up closed. However, perfect squares have one unpaired factor (like (4,4) for 16), so they’re visited an odd number of times - which means those doors will end up open.

      Counting Open Doors: Since only doors with numbers that are perfect squares end up open, we just need to count the number of perfect squares less than or equal to N. This can be done by calculating the square root of N and rounding down to the nearest integer.

      So, the function return (int)(Math.sqrt(N)); works because it effectively counts the number of perfect squares less than or equal to N, which is exactly the number of doors that will remain open.
      */
        return (int)(Math.sqrt(N));
    }


    /*
    Finding Position
    N people are standing in a queue. A selection process follows a rule where people standing on even positions
    are selected. Of the selected people a queue is formed and again out of these only people in even position
     are selected. This continues until we are left with one person. Find out the position of that person
      in the original queue.
     */
    public static long nthPosition(long n) {
        //You can code here
        int i=0;
        while(n != 1){
            n = n>>1;
            i++;
        }
        return (1<<i);

    }
    /*
    Strange Equality
    Given a positive integer N, find the count of positive integers i such that 0 <= i <= N and N+i = N^i

     */
    public int countValues(int n) {
        //You can code here]
        //concept
        //(n+i) = (n^i) + 2*(n&i)  so to make it (n+i) = (n^i) , n&i must be 0;
       //The code calculates the number of unset bits in n because each unset bit in n can correspond to either a set or unset bit in i, giving two possibilities per unset bit.
      // The total number of possible i values is 2^unset_bits, representing all combinations of set and unset bits corresponding to the unset bits in n.
        int unset_bits = 0;

        while (n != 0) {
            if ((n & 1) == 0) {
                unset_bits++;
            }
            n = n >> 1;
        }

        return 1 << unset_bits;
    }

    /*
     2429. Minimize XOR
     //https://leetcode.com/problems/minimize-xor/
     */
    public int minimizeXor(int num1, int num2) {
        //fill the code and understand again.
        int a = Integer.bitCount(num1), b = Integer.bitCount(num2), res = num1;
        for (int i = 0; i < 32; ++i) {
            if (a > b && ((1 << i) & num1) > 0) {
                res ^= 1 << i;
                a--;
            }
            if (a < b && ((1 << i) & num1) == 0) {
                res ^= 1 << i;
                a++;
            }
        }
        return res;
    }

    /*
    Min Xor
    Given an array of N integers, find the two numbers within the array with the lowest XOR value and return that value.
     */
    public int findMinXor(List<Integer> A){
        // if we sort them corresponding element xor will give min value
        //ex: 100 ^ 011 => 3^4 =0 this was the concept.
        Collections.sort(A);

        int n = A.size();

        int min_xor = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++)
        {

            int xor_val = A.get(i) ^ A.get(i + 1);
            if (xor_val < min_xor)
            {
                min_xor = xor_val;
            }
        }

        return min_xor;
    }

    /*
    Integer to Roman
    Given an integer n, convert it to a roman numeral.


NOTE:
                Symbol : I V X L C D M
                Vaue : 1 5 10 50 100 500 1000


For example, 3 is written as III in Roman numeral, just three one's added together. 13 is written as XIII, which is simply X + III.

But 4 is not IIII , it is IV(1 subtract from 5).

There are some rules for roman numerals also for some numbers

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400
and 900.

     */
    public String intToRoman(int n){
        //You can code here
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC",
                "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX",
                "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI",
                "VII", "VIII", "IX"};
        return thousands[n / 1000] + hundreds[(n % 1000) / 100] +
                tens[(n % 100) / 10] + ones[n % 10];
        // 2nd approch
        /*
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    StringBuilder sb = new StringBuilder();

    for(int i=0;i<values.length;i++) {
        while(num >= values[i]) {
            num -= values[i];
            sb.append(strs[i]);
        }
    }
    return sb.toString();

         */
    }
    /*
    Roman to Integer
    Given a Roman numeral (String of length n), convert it to an integer.

Symbol: I V X L C D M

Value: 1 5 10 50 100 500 1000

For example, 3 is written as III in Roman numeral, 13 is written as XIII, which is simply X + III.
But 4 is not IIII , it is IV (1 subtract from 5).


There are some rules for Roman numerals also for some numbers
- I can be placed before V (5) and X (10) to make 4 and 9.
- X can be placed before L (50) and C (100) to make 40 and 90.
- C can be placed before D (500) and M (1000) to make 400
and 900.
     */
    public int romanToInt(String s){
        int value[] = new int[26];
        value['I' -'A'] = 1;
        value['V' -'A'] = 5;
        value['X' -'A'] = 10;
        value['L' -'A'] = 50;
        value['C' -'A'] = 100;
        value['D' -'A'] = 500;
        value['M' -'A'] = 1000;

        int n = s.length(), sum = value[s.charAt(n-1)-'A'];

        for(int i=n-2; i>=0; i--){

            if( value[s.charAt(i)-'A'] >=  value[s.charAt(i+1)-'A']){
                sum +=  value[s.charAt(i)-'A'];
            }
            else{
                sum -= value[s.charAt(i)-'A'];
            }
        }
        return sum;
    }
    /*
    Compare Version Numbers
    Given two version numbers, version1 and version2, compare them.

Return 1 if version1 > version2

Return -1 if version1 < version2

Return 0 if version1 = version2

Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists of digits and may contain leading zeros. Every revision contains at least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on.

For example, 2.5.33 and 0.1 are valid version numbers.

To compare version numbers, compare their revisions in left-to-right order
. Revisions are compared using their integer value ignoring any leading zeros.
This means that revisions 1 and 001 are considered equal. If a version number does not specify
a revision at an index, then treat the revision as 0. For example, version 1.0 is less than version
1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.
     */
    public static int compareVersion(String version1, String version2) {
        //You can code here
        int n =version1.length(),m=  version2.length();
        int i=0, j=0;
        while(i<n && j<m){
            int num1 = 0, num2=0;
            while(i<n && version1.charAt(i) != '.'){
                num1 = num1*10 + (version1.charAt(i)-'0');
                i++;
            }
            // System.out.println(i);
            while(j<m && version2.charAt(j) != '.'){
                num2 = num2*10 + (version2.charAt(j)-'0');
                j++;
            }
            // System.out.println("num1"+num1+"num2"+num2);
            if(num1 != num2){
                return num1 > num2 ? 1 : -1;
            }
            i++; j++;

        }
        return 0;
    }
    /*
    Day of the Week for a Given Date
    Given a date, return the corresponding day of the week for that date.
Return '1' for Monday, '2' for Tuesday, '3' for Wednesday, '4' for Thursday,
'5' for Friday, '6' for 'Saturday' and '7' for Sunday.
     */
    static int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] dayOfWeek = {"Sunday","Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    public static int dayofweek(int day, int month, int year){
      /*The formula for this problem is Zelle formula
        if (m < 3) {
            m += 12;
            y -= 1;
        }
        int c = y / 100;
        y = y % 100;
        int w = (c / 4 - 2 * c + y + y / 4 + 13 * (m + 1) / 5 + d - 1) % 7;
        return (w + 7) % 7;
        */
        /*
        // todays date
        // java.time.LocalDate date = java.time.LocalDate.now();
       // So my first step is to get day for 31st Dec 1970 which is Thrusday ( check in your calender)
        // Initialize count as 4 because 31st Dec 1970 is Thrusday, which is 4.
// In all we are calculating total number of day till the required Input Date. After the we can simply find particular day name.

        int d = 4;

        d += daysSinceStart(day, month, year);
        //int knownDays = daysSinceStart(date.getDayOfMonth(), date.getMonthValue(), date.getYear());
        //int daysShiftFromToday = d - knownDays + date.getDayOfWeek().getValue(); // date.getDayOfWeek().getValue() tells which day of week is today 4 means thrusday.


        String week = dayOfWeek[(d % 7 + 7) % 7];
        return week;
         */
        // todays date
        java.time.LocalDate date = java.time.LocalDate.now();

        int d = daysSinceStart(day, month, year);
        int knownDays = daysSinceStart(date.getDayOfMonth(), date.getMonthValue(), date.getYear());
        int daysShiftFromToday = d - knownDays + date.getDayOfWeek().getValue(); // date.getDayOfWeek().getValue() tells which day of week is today 4 means thrusday.
        //String week = dayOfWeek[(daysShiftFromToday % 7 + 7) % 7];
        return (daysShiftFromToday % 7 + 7) % 7;
    }
    private static int daysSinceStart(int d, int m, int y){
        int days = 0;
        for(int i = 1971; i < y; i++){
            days += 365 + isLeap(i);
        }

        for(int i = 1; i < m; i++){
            days += daysInMonth[i - 1];
        }

        days += d;
        if(m > 2 && isLeap(y) == 1){
            days += 1;
        }
        return days;
    }

    private static int isLeap(int year){
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) ? 1 : 0;
    }

/* String Substring
Given a string ‘str’, check if it can be constructed by taking a substring of it
 and appending multiple copies of the substring together.
 */
    public boolean repeatedSubstringPattern(String str)
    {
        //You can code here
        // String s = str + str;
        // return (s.substring(1, s.length() - 1).contains(str));

        int n = str.length();
        for (int i = n / 2; i >= 1; i--)
        {
            if (n % i == 0 && str.charAt(i-1) == str.charAt(n-1))
            {
                int m = n / i;
                StringBuilder sb = new StringBuilder();
                String sub = str.substring(0, i);
                for (int j = 0; j < m; j++)
                {
                    sb.append(sub);
                }
                if (sb.toString().equals(str)) return true;
            }
        }
        return false;
    }

    // by lps way KMP alogo need to learn again then do it.
    public boolean LPSrepeatedSubstringPattern(String str) {

        int n = str.length();
        //The LPS array contains for each prefix of s the length of the longest proper prefix which is also a suffix.
        int lps[] = new int[n];
        computelps(lps,str);
        int ans = lps[n-1];
        return (ans > 0 && n % (n - ans) == 0);
        /*
        The line return (ans > 0 && n % (n - ans) == 0); checks if there’s a repeated substring pattern in the string. If ans > 0, it means there’s a proper prefix which is also suffix. And if n % (n - ans) == 0, it means the rest of the string can be divided evenly by this prefix/suffix, so it’s made up of repeated patterns of this substring.
        */
    }

    private void computelps(int [] lps, String s){
        int n = lps.length;
        int i = 1, len = 0;
        while(i<n){
            if(s.charAt(i) == s.charAt(len)){
                lps[i++] = ++len;
            }
            else{
                if(len == 0){
                    lps[i++] = len;
                }
                else{
                    int previousMatchIndex = len-1;
                    len = lps[previousMatchIndex];

                }
            }
        }
    }

}
