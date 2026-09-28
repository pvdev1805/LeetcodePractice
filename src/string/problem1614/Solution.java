package string.problem1614;

// Problem 1614 - Maximum Nesting Depth of the Parentheses
// Link: https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
// Level: Easy

public class Solution {
    // #1. Iterative Approach
    // Time Complexity: O(n) since we are iterating through the string once
    // Space Complexity: O(1) since we are using a constant amount of extra space
    public int maxDepth(String s) {
        // We initialize the depth to 0 and the max depth to 0
        // The depth represents the current nesting level of parentheses
        // The max depth represents the maximum nesting level encountered
        int depth = 0;
        int maxDepth = 0;
        for (char c : s.toCharArray()) {
            // If the character is ')', we decrease the depth
            if (c == ')') {
                depth--;
                continue;
            }

            // If the character is digit or letter, we can skip it
            if(c != '(') continue;

            // If the character is '(', we increase the depth
            depth++;

            // New max depth is possible after the '(' character, so we check if the current depth is greater than the max depth
            maxDepth = Math.max(maxDepth, depth);
        }

        return maxDepth;
    }
}
