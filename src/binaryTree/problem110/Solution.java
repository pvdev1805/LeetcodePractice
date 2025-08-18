package binaryTree.problem110;

// Problem 110 - Balanced Binary Tree
// Link: https://leetcode.com/problems/balanced-binary-tree/
// Level: Easy

public class Solution {
    // #1. DFS Approach
    // Time Complexity: O(n), where n is the number of nodes in the tree.
    // Space Complexity: O(h), where h is the height of the tree (due to recursion stack). The worst case is O(n) for a skewed tree.
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1; // Check if the tree is balanced
    }

    private int checkBalance(TreeNode root){
        if(root == null){
            return 0; // Base case: height of an empty tree is 0
        }

        int leftHeight = checkBalance(root.left); // Check height of left subtree
        if(leftHeight == -1) return -1; // If left subtree is unbalanced

        int rightHeight = checkBalance(root.right); // Check height of right subtree
        if(rightHeight == -1) return -1; // If right subtree is unbalanced

        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1; // If current node is unbalanced, return -1
        }

        return Math.max(leftHeight, rightHeight) + 1; // Return height of the current node
    }
}
