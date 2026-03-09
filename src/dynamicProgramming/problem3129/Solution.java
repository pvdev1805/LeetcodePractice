package dynamicProgramming.problem3129;

// Problem 3129 - Find All Possible Stable Binary Arrays I
// Link: https://leetcode.com/problems/find-all-possible-stable-binary-arrays-i/
// Level: Medium

class Solution {
    // #1. Dynamic Programming Approach
    // Time Complexity: O(zero * one), where zero is the number of zeros and one is the number of ones, since we are filling a 3D DP table of size (zero + 1) x (one + 1) x 2.
    // Space Complexity: O(zero * one), due to the 3D DP table we are using to store the number of ways to form stable arrays with a given number of zeros and ones.
    public int numberOfStableArrays(int zero, int one, int limit) {
        int MOD = 1000000007;
        // dp[z][o][0] -> ways where last element is 0
        // dp[z][o][1] -> ways where last element is 1
        long[][][] dp = new long[zero + 1][one + 1][2];
        // base cases: only zeros
        for (int i = 1; i <= Math.min(zero, limit); i++) {
            dp[i][0][0] = 1;
        }
        // base cases: only ones
        for (int j = 1; j <= Math.min(one, limit); j++) {
            dp[0][j][1] = 1;
        }
        for (int z = 1; z <= zero; z++) {
            for (int o = 1; o <= one; o++) {
                // place 0 at the end
                dp[z][o][0] = (dp[z - 1][o][0] + dp[z - 1][o][1]) % MOD;

                if (z - limit - 1 >= 0) {
                    dp[z][o][0] = (dp[z][o][0] - dp[z - limit - 1][o][1] + MOD) % MOD;
                }
                // place 1 at the end
                dp[z][o][1] = (dp[z][o - 1][0] + dp[z][o - 1][1]) % MOD;

                if (o - limit - 1 >= 0) {
                    dp[z][o][1] = (dp[z][o][1] - dp[z][o - limit - 1][0] + MOD) % MOD;
                }
            }
        }
        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}
