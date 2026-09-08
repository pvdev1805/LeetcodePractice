package Math.problem3870;

// Problem 3870 - Count Commas in Range
// Link: https://leetcode.com/problems/count-commas-in-range/
// Level: Easy

public class Solution {
    // #1. Math Approach
    // Time Complexity: O(1) since we are performing a constant number of operations
    // Space Complexity: O(1) since we are using a constant amount of extra space
    public int countCommas(int n) {
        if (n < 1000) return 0;
        return Math.min(n - 999, 999000); // ( n - 1000 + 1 ) vs ( 999999 - 1000 + 1 )
    }

    // #2. Simplified Math Approach
    // Time Complexity: O(1) since we are performing a constant number of operations
    // Space Complexity: O(1) since we are using a constant amount of extra space
    public int countCommas2(int n) {
        if (n < 1000) return 0;
        return n - 999;
    }

    // #3. Optimized Math Approach
    // Time Complexity: O(1) since we are performing a constant number of operations
    // Space Complexity: O(1) since we are using a constant amount of extra space
    public int countCommas3(int n) {
        return Math.max(0, n - 999);
    }
}
