package com.example.test.problem.BitManipulation;

public class BitsManipulation2 {
    public static void main(String[] args) {
        int n = 724;
        int i = 2;
        int j = 6;

//        System.out.println(getIthBit(n, i));
//        System.out.println(setIthBit(n, i));
//        System.out.println(clearIthBit(n, i));

        System.out.println(clearBitsInGivenRange(n, i, j));
    }

    static int getIthBit(int n, int i) {
        int mask = 1 << i;
//        int result = (n & mask);
//        if(result == 0) return 0;
//        else return 1;
        return (n & mask) == 0 ? 0 : 1;
    }

    static int setIthBit(int n, int i) {
        int mask = 1 << i;
        return n | mask;
    }

    static int clearIthBit(int n, int i) {
        int mask = ~(1 << i);
        return n & mask;
    }

    // 0 <= i < j < 31
    static int clearBitsInGivenRange(int n, int i, int j) {
        int a = (~0 << (j+1));
        int b = (1 << i) - 1;
        int mask = a | b;
        return n & mask;
    }
}
