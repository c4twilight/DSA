package com.example.test.problem.collectionframework.genericsAndWrapperClasses;

public class LearnGenerics {
    public static void main(String[] args) {
        new Dog("asdf123", "Leo");
        new Dog("oeiur12", 123);
        Dog<Integer, String> d3 = new Dog(12, "Leo");
        System.out.println(d3.getId());
    }
}
