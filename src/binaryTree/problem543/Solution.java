package binaryTree.problem543;

// Problem 543 - Diameter of Binary Tree
// https://leetcode.com/problems/diameter-of-binary-tree/
// Level: Easy

public class Solution {
    private int diameter = 0;

    // #1. DFS Recursion
    // Time Complexity: O(n) where n is the number of nodes in the tree
    // Space Complexity: O(h) where h is the height of the tree
    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return diameter;
    }

    private int calculateHeight(TreeNode node){
        if(node == null) return 0;

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
