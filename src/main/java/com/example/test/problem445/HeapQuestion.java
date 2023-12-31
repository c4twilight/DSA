package com.example.test.problem445;

public class HeapQuestion {

    //Q1. Check the given array is minHeap or not.
    // Iterative function to check if a given array represents min-heap or not
    public static boolean checkMinHeap(int[] A)
    {
        // base case
        if (A.length <= 1) {
            return true;
        }

        // check for all internal nodes that their left child and
        // right child (if present) holds min-heap property or not

        // start with index 0 (the root of the heap)
        for (int i = 0; i <= (A.length - 2) / 2; i++) {
            if (A[i] > A[2*i + 1] || (2*i + 2 != A.length && A[i] > A[2*i + 2])) {
                return false;
            }
        }
        return true;
    }

    //Q2. convert the given array into minHeap.
    public void convertArrayIntoMinHeap(int arr[]){
        int size = arr.length;
        // Index of last non-leaf node
        int startIdx = (size / 2) - 1;
        // Perform reverse level order traversal
        // from last non-leaf node and heapify
        // each node
        for (int i = startIdx; i >= 0; i--) {
            heapify(arr, size, i);
        }
    }
    public void heapify(int heap[], int size,int pos) {
        while (pos < size) {
            int smallest = pos;
            int left = 2 * pos + 1;
            int right = 2 * pos + 2;

            // Find the index of the smallest element among current node, left child, and right child.
            if (left < size && heap[left] < heap[smallest])
                smallest = left;
            if (right < size && heap[right] < heap[smallest])
                smallest = right;

            // If the smallest element is not the current node, swap.
            if (smallest != pos) {
               // swap(pos, smallest);
                int temp = heap[pos];
                heap[pos] = heap[smallest];
                heap[smallest] = temp;
                pos = smallest;
            } else {
                // If no swap is needed, break out of the loop.
                break;
            }
        }
    }
}
