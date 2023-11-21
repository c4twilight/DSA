package com.example.test.problem445;
import java.util.*;
public class TwoSumwithRepeatedElement {
    public static List<List<Integer>> twoSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;
        Arrays.sort(arr);
        while (left < right) {
            if (left != 0 && arr[left] == arr[left - 1]) {
                left++;
                continue;
            }
            int sum = arr[left] + arr[right];
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[left]);
                list.add(arr[right]);
                res.add(list);

                left++;
                right--;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}
