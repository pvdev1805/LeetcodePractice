package stack.problem1021;

// Problem 1021 - Remove Outermost Parentheses
// Link: https://leetcode.com/problems/remove-outermost-parentheses/
// Level: Easy

public class Solution {
    // #1. Iterative Approach
    // Time Complexity: O(n) since we are iterating through the string once
    // Space Complexity: O(n) since we are using a StringBuilder to store the result
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int openCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // We only append the '(' character if we are not at the outermost level
                if (openCount > 0) sb.append(c);
                openCount++;
            } else {
                openCount--;
                // We only append the ')' character if we are not at the outermost level
                if (openCount > 0) sb.append(c);
            }
        }
        return sb.toString();
    }
}
