package com.example.test.problem445;

import java.util.HashMap;
import java.util.Map;

public class LRUPaging {

    class DLinkedNode {
        int page;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode(int page) {
            this.page = page;
        }
    }

    private Map<Integer, DLinkedNode> pageTable = new HashMap<>();
    private int capacity;
    private DLinkedNode head, tail;

    public LRUPaging(int capacity) {
        this.capacity = capacity;
        head = new DLinkedNode(-1); // Dummy head
        tail = new DLinkedNode(-1); // Dummy tail
        head.next = tail;
        tail.prev = head;
    }

    public int accessPage(int page) {
        if (pageTable.containsKey(page)) {
            // Page is already in memory, move it to the front
            DLinkedNode node = pageTable.get(page);
            moveToHead(node);
            return 0; // No page fault
        } else {
            // Page is not in memory
            if (pageTable.size() >= capacity) {
                // Memory is full, remove the least recently used page
                int removedPage = removeTail();
                pageTable.remove(removedPage);
            }

            // Add the new page to the front of the list
            DLinkedNode newNode = new DLinkedNode(page);
            addToHead(newNode);
            pageTable.put(page, newNode);

            return 1; // Page fault occurred
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private int removeTail() {
        DLinkedNode removedNode = tail.prev;
        removeNode(removedNode);
        return removedNode.page;
    }

    public static void main(String[] args) {
        LRUPaging lruPaging = new LRUPaging(4);

        int[] pages = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
        int pageFaults = 0;

        for (int page : pages) {
            pageFaults += lruPaging.accessPage(page);
        }

        System.out.println("Page Faults: " + pageFaults);
    }
}

