package dynamicProgramming.problem799;

// Problem 799 - Champagne Tower
// Link: https://leetcode.com/problems/champagne-tower/
// Level: Medium

public class Solution {
    // #1. Dynamic Programming - Top-Down
    // Time Complexity: O(R^2) where R is the query_row
    // Space Complexity: O(R^2)
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 1][query_row + 1];
        dp[0][0] = (double)poured;
        for(int r = 0; r < query_row; r++){
            for(int c = 0; c <= r; c++){
                if(dp[r][c] > 1){
                    double excess = (dp[r][c] - 1) / 2.0;
                    dp[r + 1][c] += excess;
                    dp[r + 1][c + 1] += excess;
                    dp[r][c] = 1; // Cap the current glass to 1
                }
            }
        }
        return Math.min(1, dp[query_row][query_glass]);
    }
}
