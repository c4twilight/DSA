package com.example.test.problem445;

public class inorderPredecessor {
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        // write your code here
        TreeNode predecessor = null;

        while(root != null){
            if(p.val <= root.val){
                root = root.left;
            }
            else{
                predecessor = root;
                root = root.right;
            }
        }
        return predecessor;
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        TreeNode Successor = null;

        while(root != null){
            if(p.val >= root.val){
                root = root.right;
            }
            else{
                Successor = root;
                root = root.left;
            }
        }
        return Successor;
    }
}
 //Definition for a binary tree node.



