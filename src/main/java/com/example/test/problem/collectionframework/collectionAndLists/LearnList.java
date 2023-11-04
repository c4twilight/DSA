package com.example.test.problem.collectionframework.collectionAndLists;

import java.util.*;

public class LearnList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(10);
        list.add(20);
        list.add(1);


        Stack<String> fruits = new Stack();
        fruits.push("A");
        fruits.push("B");
        fruits.push("C");
        fruits.push("D");
        System.out.println((String)fruits.pop());
        System.out.println(fruits);
        System.out.println((String)fruits.peek());
        System.out.println(fruits);
        System.out.println(fruits.isEmpty());
    }
}
