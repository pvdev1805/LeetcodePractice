package dynamicProgramming.problem322;

// // Problem 322 - Coin Change
// // Link: https://leetcode.com/problems/coin-change/
// // Level: Medium

import java.util.Arrays;

public class Solution {
    // #1. Dynamic Programming Approach (Bottom-Up: Tabulation)
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

    // #1.1.
    public int coinChange1(int[] coins, int amount) {
        int n = coins.length;

        int[] dp = new int[amount + 1];
        for(int i = 0; i < dp.length; i++){
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < n; j++){
                if(i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    // #2. Dynamic Programming Approach (Top-Down: Recursion)
    // Time Complexity: O(n ^ amount), where n is the number of coins and amount is the target amount.
    // Space Complexity: O(amount), for the recursive stack.
    // --> Time Limit Exceeded for large inputs.
    public int coinChange2(int[] coins, int amount) {

        int ans = coinCount2(coins, amount);
        return (ans == Integer.MAX_VALUE) ?  -1 : ans;
    }

    int coinCount2(int[] coins, int amount) {

        if(amount == 0) {
            return 0;
        }
        if(amount < 0) {
            return Integer.MAX_VALUE;
        }

        int minCoins = Integer.MAX_VALUE;

        for(int i = 0; i < coins.length; i++) {
            int ans = coinCount2(coins, amount - coins[i]);

            if(ans != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, 1 + ans);
            }
        }
        return minCoins;
    }
    // #2.1.
    // --> Time Limit Exceeded for large inputs.
    public int coinChange2_1(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            int subResult = coinChange(coins, amount - coin);

            if (subResult != -1) {
                minCoins = Math.min(minCoins, 1 + subResult);
            }
        }

        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    // #3. Dynamic Programming Approach (Top-Down: Recursion with Memoization)
    // Time Complexity: O(n * amount), where n is the number of coins and amount is the target amount.
    // Space Complexity: O(amount), for the dp array.
    int[] dp;
    public int coinChange3(int[] coins, int amount) {

        dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int ans = coinCount3(coins, amount);
        return (ans == Integer.MAX_VALUE) ?  -1 : ans;
    }

    int coinCount3(int[] coins, int amount) {

        if(amount == 0) {
            return 0;
        }
        if(amount < 0) {
            return Integer.MAX_VALUE;
        }

        if(dp[amount] != -1) {
            return dp[amount];
        }

        int minCoins = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            int ans = coinCount3(coins, amount - coins[i]);

            if(ans != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, 1 + ans);
            }
        }
        return dp[amount] = minCoins;
    }
}
