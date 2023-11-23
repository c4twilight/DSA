package com.example.test.problem445;

public class LinkedListQuestion {
    class Node
    {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
    /*
    Given a sorted linked list, delete all nodes that have duplicate numbers (all occurrences),
    leaving only numbers that appear once in the original list.
     */
    public  Node removeAllDuplicates(Node head){
        if (head == null || head.next == null) return head;

        Node dummy = new Node(-1);
        Node dummyTail = dummy;
        Node curr = head;

        while (curr != null) {
            // Skip all nodes with the same data
            boolean duplicateFound = false;
            while (curr.next != null && curr.data == curr.next.data) {
                duplicateFound = true;
                curr = curr.next;
            }

            // Move to the next node
            if (!duplicateFound) {
                dummyTail.next = curr;
                dummyTail = curr;
            }
            curr = curr.next;
        }

        dummyTail.next = null;
        return dummy.next;
    }
}

