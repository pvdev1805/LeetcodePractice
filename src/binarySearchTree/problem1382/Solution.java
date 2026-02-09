package binarySearchTree.problem1382;

// Problem 1382 - Balance a Binary Search Tree
// Link: https://leetcode.com/problems/balance-a-binary-search-tree/
// Level: Medium

import java.util.LinkedList;
import java.util.List;

public class Solution {
    // #1. In-order Traversal + Build Balanced BST
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedList = new LinkedList<>();
        inOrderTraversal(root, sortedList);
        return buildBalancedBST(sortedList, 0, sortedList.size() - 1);
    }

    // Helper method to perform in-order traversal and store values in sorted order
    private void inOrderTraversal(TreeNode node, List<Integer> sortedList){
        if(node == null) return;
        inOrderTraversal(node.left, sortedList);
        sortedList.add(node.val);
        inOrderTraversal(node.right, sortedList);
    }

    // Helper method to build a balanced BST from the sorted list
    private TreeNode buildBalancedBST(List<Integer> sortedList, int left, int right){
        if(left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(sortedList.get(mid));
        node.left = buildBalancedBST(sortedList, left, mid - 1);
        node.right = buildBalancedBST(sortedList, mid + 1, right);
        return node;
    }
}
