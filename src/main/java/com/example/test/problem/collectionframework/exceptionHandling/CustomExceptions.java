package com.example.test.problem.collectionframework.exceptionHandling;

import java.util.Scanner;

public class CustomExceptions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter age");

        try {
            int age = sc.nextInt();
            if (age > 100) {
                throw new ArithmeticException();
            }
        } catch (Exception var3) {
            System.out.println(var3);
        }

    }
}
