package dynamicProgramming.problem322;

// // Problem 322 - Coin Change
// // Link: https://leetcode.com/problems/coin-change/
// // Level: Medium

public class Solution {
    // #1. Dynamic Programming Approach
    // Time Complexity: O(n * amount), where n is the number of coins and amount is the target amount.
    // Space Complexity: O(amount), for the dp array.
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[] dp = new int[amount + 1];
        for(int i = 0; i < dp.length; i++){
            dp[i] = amount + 1;
        }

        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < n; j++){
                if(i >= coins[j]){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
