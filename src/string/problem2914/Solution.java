package string.problem2914;

// Problem 2914 - Minimum Number of Changes to Make Binary String Beautiful
// Link: https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/
// Level: Medium

public class Solution {
    // #1. Iterative Approach
    // Time Complexity: O(n) since we are iterating through the string once
    // Space Complexity: O(1) since we are using a constant amount of extra space
    public int minChanges(String s) {
        int changes = 0;
        int n = s.length();

        // Iterate through the string in steps of 2
        for (int i = 1; i < n; i += 2) {
            // If the current character is the same as the previous character, we need to change it
            if (s.charAt(i) != s.charAt(i - 1)) {
                changes++;
            }
        }

        return changes;
    }
}
