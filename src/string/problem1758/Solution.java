package string.problem1758;

// Problem 1758 - Minimum Changes To Make Alternating Binary String
// Link: https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/
// Level: Easy

public class Solution {
    // #1. Counting Approach
    // Time Complexity: O(n), where n is the length of the input string s, since we need to iterate through the string once to count the number of changes needed for both options (starting with '0' and starting with '1').
    // Space Complexity: O(1), since we are using only a constant amount of extra space to store the counts of changes for both options.
    public int minOperations(String s) {
        int options1 = countChanges(s, '0'); // Count changes needed if we want the string to start with '0' (i.e., "010101...")
        int options2 = countChanges(s, '1'); // Count changes needed if we want the string to start with '1' (i.e., "101010...")
        return Math.min(options1, options2); // Return the minimum of the two options
    }

    // Helper method to count the number of changes needed to make the string alternate starting with the expected character
    private int countChanges(String s, char expected) {
        int changes = 0;
        for (int i = 0; i < s.length(); i++) {
            // If the index is even, we expect the character to be 'expected', otherwise we expect it to be the opposite of 'expected'
            if ((i % 2 == 0 && s.charAt(i) != expected) || (i % 2 == 1 && s.charAt(i) == expected)) {
                changes++;
            }
        }
        return changes;
    }
}
