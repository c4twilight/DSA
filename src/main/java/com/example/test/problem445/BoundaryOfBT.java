package com.example.test.problem445;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BoundaryOfBT {
    public
    List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null){
            return list;
        }
        if(!isLeaf(root)){
            list.add(root.val);
        }
        addLeftBoundary(root.left,list);
        addLeaf(root,list);
        addRightBoundary(root.right,list);
        return list;
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private void addRightBoundary(TreeNode right, List<Integer> list) {
        ArrayList<Integer> rightboundary = new ArrayList<>();

        while(right != null){
            if(!isLeaf(right)){
                rightboundary.add(right.val);
            }
            if(right.right != null){
                right = right.right;
            }
            else{
                right = right.left;
            }
        }
        Collections.reverse(rightboundary);
        list.addAll(rightboundary);
    }

    private void addLeaf(TreeNode root, List<Integer> list) {
        //inorder
        if(root == null) return;
        addLeaf(root.left, list);
        if(isLeaf(root))
            list.add(root.val);
        addLeaf(root.right, list);
    }

    private void addLeftBoundary(TreeNode left, List<Integer> list) {
        while(left != null){
            if(!isLeaf(left)) {
                list.add(left.val);
            }
            if(left.left != null){
                left = left.left;
            }
            else{
                left = left.right;
            }
        }
    }
}

//  Definition of TreeNode:
class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
}
