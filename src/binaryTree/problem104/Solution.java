package binaryTree.problem104;

// Problem 104 - Maximum Depth of Binary Tree
// https://leetcode.com/problems/maximum-depth-of-binary-tree/
// Level: Easy

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // #1. DFS Recursion
    // Time Complexity: O(n) where n is the number of nodes in the tree
    // Space Complexity: O(h) where h is the height of the tree
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // #2. BFS Iteration
    // Time Complexity: O(n) where n is the number of nodes in the tree
    // Space Complexity: O(w) where w is the maximum width of the tree (in the worst case, w = (n + 1) / 2 for a full binary tree --> O(n))
    public int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;
        while(!queue.isEmpty()){
            depth++;
            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode currentNode = queue.poll();
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }
        }

        return depth;
    }
}
