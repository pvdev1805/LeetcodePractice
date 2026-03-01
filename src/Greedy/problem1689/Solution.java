package Greedy.problem1689;

// Problem 1689 - Partitioning Into Minimum Number Of Deci-Binary Numbers
// Link: https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
// Level: Medium

public class Solution {
    // #1. Greedy Approach
    // Time Complexity: O(N), where N is the length of the input string, since we need to iterate through the string once to find the maximum digit.
    // Space Complexity: O(1), as we are using only a constant amount of extra space to store the maximum digit.
    public int minPartitions(String n) {
        int maxDigit = 0; // Initialize maxDigit to track the maximum digit in the string
        for (char digit : n.toCharArray()) {
            maxDigit = Math.max(maxDigit, digit - '0'); // Update maxDigit if the current digit is greater
            if (maxDigit == 9) break; // If we find a 9, we can stop since it's the largest possible digit
        }
        return maxDigit; // The minimum number of deci-binary numbers needed is equal to the maximum digit found
    }
}
