package Greedy.problem1262;

// Problem 1262 - Greatest Sum Divisible by Three
// Link: https://leetcode.com/problems/greatest-sum-divisible-by-three/
// Level: Medium

public class Solution {
    // #1. Greedy
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int maxSumDivThree(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int min1_2 = Integer.MAX_VALUE, min2_2 = Integer.MAX_VALUE;
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
            int r = num % 3;
            if(r == 1){
                if(num < min1){
                    min1_2 = min1;
                    min1 = num;
                } else if(num < min1_2){
                    min1_2 = num;
                }
            } else if(r == 2){
                if(num < min2){
                    min2_2 = min2;
                    min2 = num;
                } else if(num < min2_2){
                    min2_2 = num;
                }
            }
        }
        int remainder = totalSum % 3;
        if(remainder == 0) return totalSum;

        int r1 = 0, r2 = 0, remove;
        if(remainder == 1){
            // Case 1: Remove the smallest element with remainder 1
            r1 = min1;
            // Case 2: Remove the two smallest elements with remainder 2
            r2 = (min2 == Integer.MAX_VALUE || min2_2 == Integer.MAX_VALUE) ? Integer.MAX_VALUE : (min2 + min2_2);
        } else if(remainder == 2){
            // Case 1: Remove the smallest element with remainder 2
            r1 = min2;
            // Case 2: Remove the two smallest elements with remainder 1
            r2 = (min1 == Integer.MAX_VALUE || min1_2 == Integer.MAX_VALUE) ? Integer.MAX_VALUE : (min1 + min1_2);
        }

        remove = Math.min(r1, r2);
        return remove == Integer.MAX_VALUE ? 0 : totalSum - remove;
    }

    // #2. Dynamic Programming
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int maxSumDivThree2(int[] nums) {
        // dp[i] represents the maximum sum with remainder i when divided by 3
        int[] dp = {0, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for(int num : nums){
            // Clone the current state of dp to avoid overwriting during iteration
            int[] temp = dp.clone();
            for(int i = 0; i < 3; i++) {
                if (temp[i] != Integer.MIN_VALUE) {
                    int newSum = temp[i] + num;
                    int remainder = newSum % 3;
                    dp[remainder] = Math.max(dp[remainder], newSum);
                }
            }
        }
        return dp[0];
    }
}
