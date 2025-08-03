package array.problem121;

// Problem 121 - Best Time to Buy and Sell Stock
// Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// Level: Easy

public class Solution {
    // #1. Single Pass Approach - Kadane's Algorithm
    // Time Complexity: O(n), where n is the length of the input array.
    // Space Complexity: O(1), no extra space used.
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = prices[0];
        int maxProfit = 0;

        for(int i = 1; i < n; i++){
            if(prices[i] < buy){
                buy = prices[i]; // Update buy price if current price is lower
            } else if(prices[i] - buy > maxProfit){
                maxProfit = Math.max(maxProfit, prices[i] - buy); // Calculate profit if selling at current price
            }
        }
        return maxProfit; // Return the maximum profit found
    }

    // #2. Optimized Single Pass Approach
    // Time Complexity: O(n), where n is the length of the input array.
    // Space Complexity: O(1), no extra space used.
    public int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price: prices){
            minPrice = Math.min(minPrice, price); // Update the minimum price seen so far
            maxProfit = Math.max(maxProfit, price - minPrice); // Calculate profit if selling
        }
        return maxProfit; // Return the maximum profit found
    }
}
