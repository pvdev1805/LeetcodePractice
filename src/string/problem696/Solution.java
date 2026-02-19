package string.problem696;

// Problem 696 - Count Binary Substrings
// Link: https://leetcode.com/problems/count-binary-substrings/
// Level: Easy

public class Solution {
    // #1. Counting Consecutive Characters Approach
    // Time Complexity: O(n), where n is the length of the input string, since we are iterating through the string once.
    // Space Complexity: O(1), no extra space used.
    public int countBinarySubstrings(String s) {
        int n = s.length();
        int result = 0, previousStreak = 0, currentStreak = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentStreak++; // Increment currentStreak if the current character is the same as the previous character
            } else {
                previousStreak = currentStreak; // Update previousStreak to the currentStreak before resetting it
                currentStreak = 1; // Reset currentStreak to 1 for the new character
            }
            if (previousStreak >= currentStreak) {
                result++; // Increment result if the previousStreak is greater than or equal to the currentStreak, which means we can form a valid binary substring
            }
        }
        return result;
    }
}
