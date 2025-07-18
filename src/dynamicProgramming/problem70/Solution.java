package dynamicProgramming.problem70;

// Problem 70 - Climbing Stairs
// Link: https://leetcode.com/problems/climbing-stairs/
// Level: Easy

public class Solution {
    // #1.  Dynamic Programming
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int climbStairs(int n){
        if (n <= 2) return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // #2.  Space Optimized Dynamic Programming
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int climbStairs2(int n) {
        if (n <= 2) return n;
        int first = 1, second = 2, current = 0;
        for (int i = 3; i <= n; i++) {
            current = first + second;
            first = second;
            second = current;
        }
        return current;
    }
}
