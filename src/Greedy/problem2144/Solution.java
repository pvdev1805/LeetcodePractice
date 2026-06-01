package Greedy.problem2144;

// Problem 2144 - Minimum Cost of Buying Candies With Discount
// Link: https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/
// Level: Easy

import java.util.Arrays;

public class Solution {
    // #1. Sorting Approach
    // Time Complexity: O(N*logN), where N is the length of the input array cost, since we need to sort the array, we are using O(N log N) time.
    // Space Complexity: O(1), since we are sorting the array in-place and using only a constant amount of extra space for variables, we are using O(1) space.
    public int minimumCost(int[] cost) {
        int n = cost.length;
        Arrays.sort(cost);
        int totalCost = 0;
        for (int i = n - 1; i >= 0; i -= 3) {
            totalCost += cost[i];
            if (i - 1 >= 0) {
                totalCost += cost[i - 1];
            }
        }
        return totalCost;
    }
}
