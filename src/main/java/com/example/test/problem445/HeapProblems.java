package com.example.test.problem445;
import java.util.*;
public class HeapProblems {
        public  int pop(List<Integer> heap) {
            if (heap.isEmpty()) {
                //throw new IllegalStateException("Heap is empty");
                return -1;
            }

            // Get the maximum element (root).
            int poppedValue = heap.get(0);

            // Move the last element to the root position.
            int lastElement = heap.remove(heap.size() - 1);

            // If there are more elements in the heap, adjust it.
            if (!heap.isEmpty()) {
                heap.set(0, lastElement);
                heapify(heap, 0);
            }

            return poppedValue;
        }

        // Helper function to maintain the heap property after removing the root.
        private  void heapify(List<Integer> heap, int i) {
            int size = heap.size();
            int largest = i;

            while (i < size) {
                int leftChild = 2 * i + 1;
                int rightChild = 2 * i + 2;

                // Compare with left child.
                if (leftChild < size && heap.get(leftChild) > heap.get(largest)) {
                    largest = leftChild;
                }

                // Compare with right child.
                if (rightChild < size && heap.get(rightChild) > heap.get(largest)) {
                    largest = rightChild;
                }

                // If the largest element is not the current element, swap.
                if (largest != i) {
                    int temp = heap.get(i);
                    heap.set(i, heap.get(largest));
                    heap.set(largest, temp);
                    i = largest;
                } else {
                    // If no swap is needed, break out of the loop.
                    break;
                }
            }
        }

        // Code Snippet of the push function:
        public  void push(List<Integer> heap, int x) {
            heap.add(x);

            // Position of the current inserted element.
            int pos = heap.size() - 1;

            // Shifting the element up until it reaches the topmost node if it is larger than its parent.
            while (pos > 0) {
                int parent = (pos - 1) / 2;
                if (heap.get(pos) > heap.get(parent)) {
                    // Swapping the elements.
                    int temp = heap.get(parent);
                    heap.set(parent, heap.get(pos));
                    heap.set(pos, temp);
                    pos = parent;
                } else {
                    // As parent is larger, the element is now in its correct position.
                    break;
                }
            }
        }
}

class MinHeap {

    private final int [] heap;
    private final int capacity;
    private int size;
    MinHeap(int size) {
        this.capacity = size;
        this.heap = new int[capacity];
        this.size = 0;
    }

    // Implement the function to remove minimum element.
    public int extractMinElement() {
        if (size == 0) {
            return -1;
        }
        int minElement = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return minElement;
    }

    // Implement the function to delete an element.
    public void deleteElement(int ind) {
        if (ind < size) {
            // Decrease the key to the minimum possible value.
            decreaseKeyElement(ind, Integer.MIN_VALUE);
            extractMinElement();
        }
    }
    // Decrease the value of an element at a given index.
    public void decreaseKeyElement(int ind, int new_val) {
        if (ind < size) {
            // Update the element's value.
            heap[ind] = new_val;

            // Restore the heap property by swapping with the parent if necessary.
            while (ind != 0 && heap[ind] < heap[parent(ind)]) {
                swap(ind, parent(ind));
                ind = parent(ind);
            }
        }
    }


    // Implement the function to insert 'val' in the heap.
    public void insert(int val) {
        int pos = size;
        if(size == capacity) return;
        heap[size++] = val;
        // Shifting the element up until it reaches the topmost node if it is smaller than its parent.
        while (pos != 0 && heap[pos] < heap[parent(pos)]) {
            swap(pos, parent(pos));
            pos = parent(pos);
        }
    }

    public void heapify(int pos) {
        while (pos<size) {
            int smallest = pos;
            int left = left(pos);
            int right = right(pos);

            // Find the index of the smallest element among current node, left child, and right child.
            if (left < size && heap[left] < heap[smallest])
                smallest = left;
            if (right < size && heap[right] < heap[smallest])
                smallest = right;

            // If the smallest element is not the current node, swap.
            if (smallest != pos) {
                swap(pos, smallest);
                pos = smallest;
            } else {
                // If no swap is needed, break out of the loop.
                break;
            }
        }
    }
    // Helper function to get the index of the parent node.
    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}

class MaxHeap {

    private final int[] heap;
    private final int capacity;
    private int size;

    MaxHeap(int size) {
        this.capacity = size;
        this.heap = new int[capacity];
        this.size = 0;
    }

    // Implement the function to remove maximum element.
    public int extractMaxElement() {
        if (size == 0) {
            return -1;
        }
        int maxElement = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return maxElement;
    }

    // Implement the function to delete an element.
    public void deleteElement(int ind) {
        if (ind < size) {
            // Decrease the key to the maximum possible value.
            increaseKeyElement(ind, Integer.MAX_VALUE);
            extractMaxElement();
        }
    }

    // Increase the value of an element at a given index.
    public void increaseKeyElement(int ind, int new_val) {
        if (ind < size) {
            // Update the element's value.
            heap[ind] = new_val;

            // Restore the heap property by swapping with the parent if necessary.
            while (ind != 0 && heap[ind] > heap[parent(ind)]) {
                swap(ind, parent(ind));
                ind = parent(ind);
            }
        }
    }

    // Implement the function to insert 'val' in the heap.
    public void insert(int val) {
        int pos = size;
        if (size == capacity) return;
        heap[size++] = val;
        // Shifting the element up until it reaches the topmost node if it is larger than its parent.
        while (pos != 0 && heap[pos] > heap[parent(pos)]) {
            swap(pos, parent(pos));
            pos = parent(pos);
        }
    }

    public void heapify(int pos) {
        while (pos < size) {
            int largest = pos;
            int left = left(pos);
            int right = right(pos);

            // Find the index of the largest element among current node, left child, and right child.
            if (left < size && heap[left] > heap[largest])
                largest = left;
            if (right < size && heap[right] > heap[largest])
                largest = right;

            // If the largest element is not the current node, swap.
            if (largest != pos) {
                swap(pos, largest);
                pos = largest;
            } else {
                // If no swap is needed, break out of the loop.
                break;
            }
        }
    }

    // Helper function to get the index of the parent node.
    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}


