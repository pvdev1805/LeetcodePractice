package binaryTree.problem2265;

// Problem 2265 - Count Nodes Equal to Average of Subtree
// Link: https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
// Level: Medium

public class Solution {
    int answer = 0;

    // #1. DFS Approach
    // Time Complexity: O(n) since we are visiting each node once
    // Space Complexity: O(h) where h is the height of the tree, due to the recursion stack
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return answer;
    }

    // DFS helper function that returns an array containing the sum and count of nodes in the subtree rooted at the given node
    // Time Complexity: O(n) since we are visiting each node once
    // Space Complexity: O(h) where h is the height of the tree, due to the recursion stack
    private int[] dfs(TreeNode node) {
        if (node == null) return new int[]{0, 0}; // return {sum, count}

        int[] left = dfs(node.left); // left = [leftSum, leftCount]
        int[] right = dfs(node.right); // right = [rightSum, rightCount]

        int sum = left[0] + right[0] + node.val; // left[0] = leftSum, right[0] = rightSum
        int count = left[1] + right[1] + 1; // left[1] = leftCount, right[1] = rightCount

        // If the average of the subtree is equal to the value of the current node, increment the answer
        if (sum / count == node.val) answer++;

        return new int[]{sum, count};
    }
}
