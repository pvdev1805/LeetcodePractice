package string.problem3498;
// Problem 3498 - Reverse Degree of a String
// Link: https://leetcode.com/problems/reverse-degree-of-a-string/
// Level: Easy

public class Solution {
    // #1. Traversal Approach
    // Time Complexity: O(n) since we are iterating through the string once
    // Space Complexity: O(1) since we are using a constant amount of extra space
    public int reverseDegree(String s) {
        int n = s.length();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int indexInString = i + 1; // 1-based index
            int indexInReversedAlphabet = 26 - (c - 'a'); // 1-based index in reversed alphabet
            // int indexInReversedAlphabet = 'z' - c + 1; // 1-based index in reversed alphabet

            int product = indexInString * indexInReversedAlphabet;
            sum += product;
        }

        return sum;
    }
}
