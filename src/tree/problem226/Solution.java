package tree.problem226;

// Problem 226 - Invert Binary Tree
// https://leetcode.com/problems/invert-binary-tree/
// Level: Easy

public class Solution {
    // #1. Recursion
    // Time Complexity: O(n) where n is the number of nodes in the tree
    // Space Complexity: O(h) where h is the height of the tree
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode currentLeft = root.left;
        root.left = root.right;
        root.right = currentLeft;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
