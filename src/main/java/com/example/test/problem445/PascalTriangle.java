package com.example.test.problem445;

import java.util.*;

public class PascalTriangle {
    public static List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1); //inserting the 1st element

        //calculate the rest of the elements:
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int)ans);
        }
        return ansRow;
    }
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>>ans = new ArrayList<>();

        for(int i=1; i<=numRows; i++){
            ans.add(generateRow(i));
        }
        return ans;
    }

    //In this case, we are given the row number r and the column number c,
    // and we need to find out the element at position (r,c).
    public static long nCr(int n, int r) {
        long res = 1;

        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    public static int pascalTriangle(int r, int c) {
        int element = (int) nCr(r - 1, c - 1);
        return element;
    }
}

