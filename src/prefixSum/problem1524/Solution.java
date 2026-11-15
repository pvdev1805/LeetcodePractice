package prefixSum.problem1524;

// Problem 1524 - Number of Sub-arrays With Odd Sum
// Link: https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/
// Level: Medium

public class Solution {
    // #1. Prefix Sum Approach
    // Time Complexity: O(n) since we are iterating through the array once
    // Space Complexity: O(1) since we are using a constant amount of extra space
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1000000007;
        long prefixSum = 0, oddPrefixSumCount = 0;
        for (int num : arr) {
            prefixSum += num;
            // If the prefix sum is odd, increment the count of odd prefix sums
            if (prefixSum % 2 != 0) oddPrefixSumCount++;
        }

        // The number of prefix sum arrays with odd sum is equal to the number of odd prefix sums
        // Example: arr = [1, 3, 5] --> prefixSum with odd sum: [1], [1, 3, 5]

        // Calculate the sum of subarray from index i to j: prefixSum[j] - prefixSum[i - 1]
        // If the sum is odd, then there are 2 cases:
        // 1. If prefixSum[j] is odd and prefixSum[i - 1] is even, then the sum is odd
        // 2. If prefixSum[j] is even and prefixSum[i - 1] is odd, then the sum is odd
        // --> The number of subarrays with odd sum is equal to the number of odd prefix sums multiplied by the number of even prefix sums
        // Example: arr = [1, 3, 5] --> subarrays with odd sum: [3], [5]

        long evenPrefixSumCount = arr.length - oddPrefixSumCount;

        long ans = oddPrefixSumCount + evenPrefixSumCount * oddPrefixSumCount;
        return (int) (ans % MOD);
    }
}
