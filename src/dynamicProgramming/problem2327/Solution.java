package dynamicProgramming.problem2327;

// Problem 2327 - Number of People Aware of a Secret
// Link: https://leetcode.com/problems/number-of-people-aware-of-a-secret/
// Level: Medium

public class Solution {
    // #1. Dynamic Programming + Sliding Window Approach
    // Time Complexity: O(n), where n is the number of days.
    // Space Complexity: O(n), for storing the dp array.
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        final int MOD = 1000000007;
        long[] dp = new long[n + 1];
        dp[1] = 1; // On day 1, one person knows the secret
        long share = 0; // Number of people who can share the secret
        // dp[i] represents the number of people who learn the secret on day i
        for(int t = 2; t <= n; t++){
            // People who learned the secret 'delay' days ago can start sharing it
            if(t - delay >= 1){
                share = (share + dp[t - delay]) % MOD;
            }
            // People who learned the secret 'forget' days ago will forget it and stop sharing
            if(t - forget >= 1){
                share = (share - dp[t - forget] + MOD) % MOD;
            }
            dp[t] = share; // Update the number of people who learn the secret on day t
        }
        long knows = 0; // Total number of people who still remember the secret
        // Sum up the number of people who learned the secret in the last forget - 1 days
        for(int i = n - forget + 1; i <= n; i++){
            knows = (knows + dp[i]) % MOD;
        }
        return (int) knows; // Return the total number of people who know the secret
    }
}
