package com.example.test.problem445;
import java.util.ArrayList;
import java.util.Collections;
public class SmallestNuberFormedFromArray {
    //Given a list of non-negative integers nums, arrange them such that they form the smallest number and return it.
    //it should be valid number 001 is not valid number, 100 is valid number.
    //Since the result may be very large, so you need to return a string instead of an integer.
    public String validsmallestNumber(int[] nums) {
        // Convert numbers to strings and sort based on custom comparator
        ArrayList<String> list = new ArrayList<>();
        int zeroCnt = 0;
        for (int num : nums) {
            if (num != 0) {
                list.add(String.valueOf(num));
            } else {
                zeroCnt++;
            }
        }

        list.sort((a, b) -> (a + b).compareTo((b + a)));

        // Concatenate sorted strings to form the smallest number
        StringBuilder result = new StringBuilder();
        if(!list.isEmpty()) {
            result.append(list.get(0));
        }
        result.append("0".repeat(zeroCnt));
        for (int i=1; i<list.size(); i++) {
            result.append(list.get(i));
        }

        return result.toString();
    }
}
