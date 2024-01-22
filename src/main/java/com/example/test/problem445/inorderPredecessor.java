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
    //convert LL to Balanced BST with O(H) space.
    //https://youtu.be/18w8VduomfI?si=846SYbRiBQ3S2idE
    private static TreeNode convertToBST(TreeNode[] head, int n) {
        if (n <= 0 || head[0] == null) {
            return null;
        }

        TreeNode leftTree = convertToBST(head, n / 2);

        TreeNode root = head[0];
        root.left = leftTree;

        head[0] = head[0].right;

        root.right = convertToBST(head, n - n / 2 - 1);

        return root;
    }

    //1534 · Convert Binary Search Tree to Sorted Doubly Linked List
    public class BSTTODLLCircular {
        /**
         * @param root: root of a tree
         * @return: head node of a doubly linked list
         */
        TreeNode prev = null, head = null;
        //Function to convert binary tree to doubly linked list and return it.

        void convertToDLL(TreeNode root){
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
        public TreeNode treeToDoublyList(TreeNode root) {
            prev = null;
            head = null;

            convertToDLL(root);
            prev.right=head;
            head.left=prev;
            return head;
        }
    }
}
 //Definition for a binary tree node.



