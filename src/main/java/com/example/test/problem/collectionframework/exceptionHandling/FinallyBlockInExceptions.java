package com.example.test.problem.collectionframework.exceptionHandling;

public class FinallyBlockInExceptions {
    public static void main(String[] args) {
        int[] a = new int[5];

        try {
            getNumberFromArray(a);
        } catch (Exception var3) {
            System.out.println("catched the exception " + var3.getMessage());
        }

    }

    static int getNumberFromArray(int[] a) throws ArithmeticException {
        return a[8];
    }
}
