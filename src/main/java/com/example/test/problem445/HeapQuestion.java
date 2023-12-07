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
            int largest = pos;
            int left = 2*pos+1;
            int right = 2*pos+2;

            // Find the index of the largest element among current node, left child, and right child.
            if (left < size && heap[left] > heap[largest])
                largest = left;
            if (right < size && heap[right] > heap[largest])
                largest = right;

            // If the largest element is not the current node, swap.
            if (largest != pos) {
               // swap(pos, largest);
                int temp = heap[pos];
                heap[pos] = heap[largest];
                heap[largest] = temp;
                pos = largest;
            } else {
                // If no swap is needed, break out of the loop.
                break;
            }
        }
    }

}
