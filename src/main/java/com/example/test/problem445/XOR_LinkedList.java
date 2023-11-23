package com.example.test.problem445;
import java.util.*;

public class XOR_LinkedList{

    private static List<List<Integer>> findPairsWithGivenSum(int target, Node head) {
        List<List<Integer>> pairs = new ArrayList<>();

        Node first = head;
        Node second = convertToXORDoublyLinkedList(head);;

        // Traverse the XOR doubly linked list until the last node
        while (first != null && second != null && first != second && first.npx != null) {
            int sum = first.data + second.data;

            if (sum == target) {
                List<Integer> temp = new ArrayList<>();
                temp.add(first.data);
                temp.add(second.data);
                pairs.add(temp);
                first = first.npx; // Move first in forward direction
                second = second.npx; // Move second in backward direction
            } else if (sum < target) {
                first = first.npx; // Move first in forward direction
            } else {
                second = second.npx; // Move second in backward direction
            }
        }

        convertBackToOriginalLinkedList(head);
        return pairs;
    }

    // Function to convert XOR doubly linked list back to original doubly linked list
    private static void convertBackToOriginalLinkedList(Node head) {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = XOR(prev, current.npx);
            current.npx = prev;
            prev = current;
            current = next;
        }
    }

    private static Node XOR(Node a, Node b) {
        /* return (Node) (a ^ b);    this logic works on c++ not in java
        (Node) (a ^ b) this doesn't work in java, so it will fail to execute it,
        if you add new node(a.data^b.data) it might work but the complexity of adding
        new nodes each time makes it O(n) space. So please come up with some other solution
        that works in java.
         */
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }
        return new Node(a.data ^ b.data);
    }

    private static Node convertToXORDoublyLinkedList(Node head) {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.npx;
            current.npx = XOR(prev, next);
            prev = current;
            current = next;
        }

        return prev;  // Return the last node of the doubly linked list
    }
}
class  Node {
    int data;
    Node npx; // XOR of next and prev

    // Constructor
    public Node(int data) {
        this.data = data;
        this.npx = null;
    }
}