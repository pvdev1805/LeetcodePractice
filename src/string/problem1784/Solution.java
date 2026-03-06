package string.problem1784;

// Problem 1784 - Check if Binary String Has at Most One Segment of Ones
// Link: https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
// Level: Easy

public class Solution {
    // #1. Iterative Approach
    // Time Complexity: O(N), where N is the length of the input string s, since we need to iterate through the string once to check for segments of ones.
    // Space Complexity: O(1), since we are using only a constant amount of extra space to store variables for the loop and checks.
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        for (int i = n - 1; i >= 1; i--) {
            if (s.charAt(i) == '1' && s.charAt(i - 1) == '0') {
                return false; // If we find '01', it means there are at least two segments of ones, so we return false
            }
        }
        return true; // If we finish the loop without finding a '01', it means there is at most one segment of ones, so we return true
    }
}
