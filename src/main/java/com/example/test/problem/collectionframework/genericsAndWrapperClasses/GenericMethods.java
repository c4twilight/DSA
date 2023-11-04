package com.example.test.problem.collectionframework.genericsAndWrapperClasses;

public class GenericMethods {
    public static void main(String[] args) {
        printData("Hello");
        printData(123);
        GenericMethods obj = new GenericMethods();
        obj.doubleData(123);
    }

    static <E> void printData(E data) {
        System.out.println(data);
    }

    <E extends Number> void doubleData(E data) {
        System.out.println(data);
    }
}
