package string.problem2839;

// Problem 2839 - Check If Strings Can be Made Equal With Operations I
// Link: https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-i/
// Level: Easy

public class Solution {
    // #1. Character Matching Approach
    // Time Complexity: O(1), since we are only comparing a fixed number of characters (4 characters in total) from the two strings, the time complexity is constant.
    // Space Complexity: O(1), since we are using only a constant amount of extra space to store variables for the comparisons, we are not using any additional space that grows with the input size.
    public boolean canBeEqual(String s1, String s2) {
        boolean evenMatch = (s1.charAt(0) == s2.charAt(0)) && (s1.charAt(2) == s2.charAt(2)) || (s1.charAt(0) == s2.charAt(2)) && (s1.charAt(2) == s2.charAt(0)); // Check if the characters at even indices (0 and 2) can match

        if (!evenMatch) return false; // If the characters at even indices cannot match, we can return false immediately

        boolean oddMatch = (s1.charAt(1) == s2.charAt(1)) && (s1.charAt(3) == s2.charAt(3)) || (s1.charAt(1) == s2.charAt(3)) && (s1.charAt(3) == s2.charAt(1)); // Check if the characters at odd indices (1 and 3) can match

        return oddMatch; // If the characters at odd indices can match, we can return true, otherwise we return false
    }
}
