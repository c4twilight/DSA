package com.example.test.problem445;

public class Merge2SortedArray {
    //Merge Two Sorted Arrays Without Extra Spac
    public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
        // Write your code here.
        /*1st approch easy and optimal
        int n= a.length, m = b.length, left = n-1, right = 0;
        while(left >=0 && right < m){
            if(a[left] > b[right]){
                //swap
                long temp = a[left];
                a[left] = b[right];
                b[right] = temp;
                left--; right++;
            }
            else{
                break;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b); */

        //2nd gap method optimal ,it uses shell sorting technique.
        int n= a.length, m = b.length;

        // len of the imaginary single array:
        int len = n + m;

        // Initial gap:
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            // Place 2 pointers:
            int left = 0;
            int right = left + gap;
            while (right < len) {
                // case 1: left in a[]
                //and right in b[]:
                if (left < n && right >= n) {
                    swapIfGreater(a, b, left, right - n);
                }
                // case 2: both pointers in b[]:
                else if (left >= n) {
                    swapIfGreater(b, b, left - n, right - n);
                }
                // case 3: both pointers in arr1[]:
                else {
                    swapIfGreater(a, a, left, right);
                }
                left++; right++;
            }
            // break if iteration gap=1 is completed:
            if (gap == 1) break;

            // Otherwise, calculate new gap:
            gap = (gap / 2) + (gap % 2);
        }

    }
    private static void swapIfGreater(long[] arr1, long[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            long temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }
}
