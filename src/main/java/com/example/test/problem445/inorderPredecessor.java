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

    //BST to sorted DLL
    static TreeNode prev = null, head = null;
    public static TreeNode bstToSortedDLL(TreeNode root) {
        prev = null;
        head = null;

        convertToDLL(root);
        return head;
    }
    static void convertToDLL(TreeNode root){
        if(root == null) return;

        convertToDLL(root.left);

        if(prev == null) head = root;
        else{
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        convertToDLL(root.right);
    }
}
 //Definition for a binary tree node.



