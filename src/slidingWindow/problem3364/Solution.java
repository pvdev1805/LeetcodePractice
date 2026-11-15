package slidingWindow.problem3364;

// Problem 3364 - Minimum Positive Sum Subarray
// Link: https://leetcode.com/problems/minimum-positive-sum-subarray/
// Level: Easy

import java.util.List;

public class Solution {
    // #1. Brute Force Approach
    // Time Complexity: O(n^2) since we are iterating through the array twice
    // Space Complexity: O(1) since we are using a constant amount of extra space
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums.get(j);
                int subArrayLength = j - i + 1;
                if (subArrayLength >= l && subArrayLength <= r && sum > 0) {
                    minSum = Math.min(minSum, sum);
                }
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }

    // #2. Prefix Sum Approach
    // Time Complexity: O(n * (r - l + 1)) since we are iterating through the array and checking all subarrays of length between l and r
    // Space Complexity: O(n) since we are using an extra array to store prefix sums
    public int minimumSumSubarray2(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums.get(i);
        }

        int minSum = Integer.MAX_VALUE;
        for (int length = l; length <= r; length++) {
            for (int i = 0; i + length <= n; i++) {
                // Calculate the sum of subarray from index i to j: prefixSum[j] - prefixSum[i - 1]
                int sum = prefixSum[i + length] - prefixSum[i];
                if (sum > 0) {
                    minSum = Math.min(minSum, sum);
                }
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }

    // #3. Sliding Window Approach
    // Time Complexity: O(n * (r - l + 1)) since we are iterating through the array and checking all subarrays of length between l and r
    // Space Complexity: O(1) since we are using a constant amount of extra space
    public int minimumSumSubarray3(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int minSum = Integer.MAX_VALUE;

        for (int length = l; length <= r; length++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += nums.get(i);
                // Remove the element that is out of the current window
                if (i >= length) {
                    sum -= nums.get(i - length);
                }
                // Check if the current window has the required length and a positive sum
                if (i >= length - 1 && sum > 0) {
                    minSum = Math.min(minSum, sum);
                }
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}
