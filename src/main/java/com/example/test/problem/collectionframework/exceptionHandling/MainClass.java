package com.example.test.problem.collectionframework.exceptionHandling;

public class MainClass {
    public static void main(String[] args) {
        int[] a = new int[5];
        System.out.println("Hello guys");

        try {
            int result = 5 / 0;
            System.out.println(a[8]);
        } catch (Exception var3) {
            System.out.println("all exception handled");
        }

        System.out.println("Bye guys");
    }
}
