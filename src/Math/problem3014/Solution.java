package Math.problem3014;

// Problem 3014 - Minimum Number of Pushes to Type Word I
// Link: https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/
// Level: Easy

public class Solution {
    // #1. Mathematical Approach
    // Time Complexity: O(1) since we are performing a constant number of operations
    // Space Complexity: O(1) since we are using a constant amount of space
    public int minimumPushes(String word) {
        int n = word.length();
        int t1 = (n + 7) / 8;
        int t2 = n % 8;
        if (t2 == 0) {
            return 4 * t1 * (t1 + 1);
        }
        int f1 = 4 * t1 * (t1 - 1);
        int f2 = t1 * t2;
        return f1 + f2;
    }
}
