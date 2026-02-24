package binaryTree.problem1022;

// Problem 1022 - Sum of Root To Leaf Binary Numbers
// Link: https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
// Level: Easy

public class Solution {
    // #1. Depth-First Search (DFS) Approach
    // Time Complexity: O(N), where N is the number of nodes in the tree, since we visit each node once.
    // Space Complexity: O(H), where H is the height of the tree, O(N) in the worst case of a skewed tree and O(log N) for a balanced tree, due to the recursion stack.
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0); // Start DFS with the root node and an initial sum of 0
    }

    private int dfs(TreeNode node, int currentSum) {
        if (node == null) return 0; // Base case: if the node is null, return 0
        currentSum = (currentSum << 1) | node.val; // Shift currentSum left and add the current node's value
        if (node.left == null && node.right == null) {
            return currentSum; // If it's a leaf node, return the current sum
        }
        return dfs(node.left, currentSum) + dfs(node.right, currentSum); // Recur for left and right subtrees
    }
}
