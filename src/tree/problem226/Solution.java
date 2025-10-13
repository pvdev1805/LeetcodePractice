package tree.problem226;

// Problem 226 - Invert Binary Tree
// https://leetcode.com/problems/invert-binary-tree/
// Level: Easy

import java.util.LinkedList;
import java.util.Queue;

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

    // #2. Iteration (BFS)
    // Time Complexity: O(n) where n is the number of nodes in the tree
    // Space Complexity: O(w) where w is the maximum width of the tree
    public TreeNode invertTree2(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            TreeNode currentLeft = current.left;
            current.left = current.right;
            current.right = currentLeft;

            if(current.left != null) queue.offer(current.left);
            if(current.right != null) queue.offer(current.right);
        }
        return root;
    }
}
