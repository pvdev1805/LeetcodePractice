package Math.problem3871;

// Problem 3871 - Count Commas in Range II
// Link: https://leetcode.com/problems/count-commas-in-range-ii/
// Level: Medium

public class Solution {
    // #1. Math Approach
    // Time Complexity: O(log n) since we are iterating through the thresholds of 1000, 1000000, 1000000000, etc. --> ~ O(1) when n is small
    // Space Complexity: O(1) since we are using a constant amount of extra space
    public long countCommas(long n) {
        long result = 0;
        for (long threshold = 1000; threshold <= n; threshold *= 1000) {
            result += n - threshold + 1;
        }
        return result;
    }
}
