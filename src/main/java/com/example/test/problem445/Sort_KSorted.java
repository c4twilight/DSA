package com.example.test.problem445;
import java.util.*;

public class Sort_KSorted {

    //Ques:- Given an array of n distinct elements. Check whether the given array is a k sorted array or not.
    // A k sorted array is an array where each element is at most k distance away from its target
    // position in the sorted array.
    String isKSortedArray(int arr[], int n, int k) {
        List<Pair> aux = new ArrayList<>(); // {arr[i], index}
        for(int i=0; i<n; i++){
            aux.add(new Pair(arr[i], i));
        }

        Collections.sort(aux , (a, b) -> a.key - b.key);

        for(int i=0; i<n; i++){
            if(Math.abs(aux.get(i).val - i) > k){
                return "No";
            }
        }
        return "Yes";
    }

    //Ques:- Given an array of n elements, where each element is at most k
    // away from its target position, you need to sort the array optimally.
    //Function to return the sorted array.
    ArrayList <Integer> nearlySorted(int arr[], int n, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<=k; i++){
            pq.offer(arr[i]);
        }

        for(int i=k+1; i<n; i++){
            list.add(pq.poll());
            pq.offer(arr[i]);
        }

        while(!pq.isEmpty()){
            list.add(pq.poll());
        }

        return list;

    }
}
class Pair{
    int key;
    int val;

    Pair(int k,int v){
        key = k;
        val = v;
    }
}
