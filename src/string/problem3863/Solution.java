package string.problem3863;

// Problem 3863 - Minimum Operations to Sort a String
// Link: https://leetcode.com/problems/minimum-operations-to-sort-a-string/
// Level: Medium

public class Solution {
    // #1. Greedy + Case Analysis Approach
    // Time Complexity: O(n) since we are iterating through the string once
    // Space Complexity: O(1) since we are using a constant amount of extra space
    public int minOperations(String s) {
        int n = s.length();

        boolean sorted = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
                break;
            }
        }

        // Case 1: If the string is already sorted, then we don't need to do anything.
        if (sorted) return 0;

        // Case 2: If the string has only 2 characters, then substring of length 1 is always sorted, so we cannot sort the string in any way.
        if (n == 2) return -1;

        char minChar = s.charAt(0), maxChar = s.charAt(0);
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if (c < minChar) minChar = c;
            if (c > maxChar) maxChar = c;
        }

        // Case 3: If the minimum character is at the beginning or the maximum character is at the end, then we can sort the string in one operation.
        // - If the minimum character is at the beginning, we can sort the rest of the string from index 1 to n - 1.
        // - If the maximum character is at the end, we can sort the rest of the string from index 0 to n - 2.
        if (minChar == s.charAt(0) || maxChar == s.charAt(n - 1)) return 1;

        // Case 4: If the minimum character or the maximum character is in the middle of the string, then we can sort the string in two operations.
        // - Step 1: We can sort from that character to one end of the string, this operation will move the minimum or the maximum character to one end of the string.
        // - Step 2: We can sort the rest of the string excluding that character, this operation will sort the rest of the string.
        for (int i = 1; i < n - 1; i++) {
            char c = s.charAt(i);
            if (c == minChar || c == maxChar) return 2;
        }

        // Case 5: If maximum character is at the beginning and minimum character is at the end, then we can sort the string in three operations.
        // - Step 1: We can sort the rest of the string from index 1 to n - 2 in one operation, then the minimum character moves to index 1 and the maximum character remains at index 0.
        // - Step 2: We can sort the substring including index 0 and index 1 in one operation, that will move the minimum character to index 0.
        // - Step 3: We can sort the substring excluding index 0 in one operation, that will move the maximum character to index n - 1.
        return 3;
    }
}
