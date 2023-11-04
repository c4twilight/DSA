package com.example.test.problem.collectionframework.collectionQueueAndSet;
import java.util.ArrayDeque;
public class LearnDeque {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        ArrayDeque<Integer> q = new ArrayDeque();
        q.offer(10);
        q.offer(20);
        q.offer(30);
        System.out.println("queue " + q);
        System.out.println(q.poll());
    }
}
