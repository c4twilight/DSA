package com.example.test.problem;

import java.util.ArrayList;
import java.util.List;

public class problem {

     /* Maximum Unsorted Subarray
     Given an array A of non-negative integers of size N. Find the minimum subarray Al, Al+1 ,...,
     Ar such that if we sort(in ascending order) that sub-array, then the whole array should get sorted.
      If A is already sorted, output -1.
      */
        public ArrayList<Integer> subUnsort(ArrayList<Integer> nums) {
            // You can code here

        /*int n = nums.size();
        ArrayList<Integer> num1 = (ArrayList)nums.clone();
        Collections.sort(nums);
        int count = -1 , count2 = -1;
        int i =0 , j = n-1;
        while(i<n ){
            if(nums.get(i) != num1.get(i)){
                count = i;
                break;
            }
            i++;
        }
        while(j>=0){
            if(nums.get(j) != num1.get(j)){
                count2 = j;
                break;
            }
            j--;
        }
      ArrayList<Integer> ans = new ArrayList<>();
      if(count == -1 && count2 == -1){
        ans.add(-1);
        return ans;
      }
        ans.add(count);
        ans.add(count2);
        return ans;
      */
            int n = nums.size();
            int max = nums.get(0), min = nums.get(n-1) , begin= -1 , end = -2;
            for(int i =0; i < n; i++){

                max = Math.max(max, nums.get(i));

                if(nums.get(i) < max)
                    end = i;

                min = Math.min(min, nums.get(n-1 -i));
                if(nums.get(n-1 -i) > min)
                    begin =n-1 - i;
            }
            ArrayList<Integer> ans = new ArrayList<>();
            if(begin == -1 && end == -2){
                ans.add(-1);
                return ans;
            }
            ans.add(begin);
            ans.add(end);
            return ans;
        }

        /* Kth Node From Middle
        Given are an integer B and a linked list A of length N.
     From the middle of the Linked List A toward the beginning,
      you must determine the value of the Bth node.
     Return -1 if such an element is not present.
         */
    public int kthNodeFromMiddle(ListNode head, int B) {
        //You can code here
        ListNode fast = head;
        ListNode slow = head;
        for(int i=0; i<B; i++){
            if(fast != null && fast.next != null){
                fast = fast.next.next;
            }else{
                return -1;
            }
        }
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.val;

    }
    /*
    Remove Nth Node from List End
    Given a linked list A, remove the B-th node from the end of the list and return its head.
    Consider the linked list 1->2->3->4->5 with B = 2. The linked list changes to 1->2->3->5
    after the second node at the very end is removed.
     */
    public ListNode removeNthFromEnd(ListNode A, int B) {
        //You can code here
        ListNode dummy = new ListNode();
        dummy.next = A;
        ListNode fast = dummy;
        ListNode slow = dummy;
        int count = 0;
        for(int i=0; i<B && fast != null; i++){
            fast= fast.next;
        }
        if (fast == null) {
            return dummy.next.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
    /*
    Generate Brackets
    Given an integer N representing the number of pairs of parentheses, The goal is to produce
    all possible combinations of balanced and well-formed brackets. Return the answer according
     to sorted order where '(' comes first and then ')'.
     */
    public List<String> AllParenthesis(int n) {
        //You can code here
        List<String> list = new ArrayList<String>();
        backtrack(list, new StringBuilder(), 0, 0, n);
        return list;
    }
    private void backtrack(List<String> list, StringBuilder str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str.toString());
            return;
        }
        if(open < max){
            backtrack(list, str.append("("), open+1, close, max);
            str.deleteCharAt(str.length()-1);
        }
        if(close < open){
            backtrack(list, str.append(")"), open, close+1, max);
            str.deleteCharAt(str.length()-1);
        }
    }
    /*
    Smart Keypad Problem
    You are given a string digits that contains digits from [2 - 9], both inclusive.
    Return all possible letter combinations that the number could represent in sorted order
     */
    static final String[] KEYPAD = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        //You can code here
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        if(digits.length()==0){
            return ans;
        }
        dfsKeyPadCombination(sb, 0, digits, KEYPAD, ans);
        return ans;
    }
    private void dfsKeyPadCombination(StringBuilder sb, int index, String digits, String[] keypad, List<String> ans) {
        if(index >= digits.length()) {
            ans.add(sb.toString());
            return;
        }
        String options = keypad[digits.charAt(index) - '0'];
        for (char option : options.toCharArray()) {
            sb.append(option);
            dfsKeyPadCombination(sb, index + 1, digits, keypad, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    /*
    Merge Two Sorted Lists
    You are given the heads of two sorted linked lists list1 and list2.
    Merge the two lists in a one sorted list. The list should be made by
    splicing together the nodes of the first two lists.
    Return the head of the merged linked list.
     */

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //You can code here
        if(l1 == null) return l2;
        else if(l2 == null) return l1;

        if(l1.val > l2.val){
            //swap
            ListNode  temp = l1;
            l1 = l2;
            l2 = temp;
        }
        ListNode head = l1;
        while(l1 != null && l2 != null){
            ListNode temp = null;
            while(l1 != null && l1.val <= l2.val){
                temp = l1;
                l1 = l1.next;
            }
            temp.next = l2;
            // swap
            ListNode  temp1 = l1;
            l1 = l2;
            l2 = temp1;
        }
        return head;
    }
    /*
    List Cycle
    Problem Statement
    Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
    Note:
    -1 represents the null node here.
    There is always a valid input.
    If there is a cycle present then the intersection node is the only duplicate node.
     */
    public ListNode detectCycle(ListNode A) {
        //You can code here
        ListNode entry = A;
        ListNode slow = hasCycle(A);
        if(slow == null) return null;
        while(slow != entry) {               // found the entry location
            slow  = slow.next;
            entry = entry.next;
        }
        return entry;

    }
    private ListNode hasCycle(ListNode head){
        ListNode slow  = head;
        ListNode fast  = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return slow;
            }
        }
        return null;
    }
}
