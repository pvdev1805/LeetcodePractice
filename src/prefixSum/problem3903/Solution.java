package prefixSum.problem3903;

// Problem 3903 - Smallest Stable Index I
// Link: https://leetcode.com/problems/smallest-stable-index-i/
// Level: Easy

public class Solution {
    // #1. Prefix Sum Approach
    // Time Complexity: O(N) where N is the length of `nums`
    // Space Complexity: O(N) for the suffix array
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] suffix = new int[n];

        int minNum = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            minNum = Math.min(minNum, nums[i]);
            suffix[i] = minNum;
        }
        int maxNum = 0;
        // Return the first index i with score <= k
        for (int i = 0; i < n; i++) {
            maxNum = Math.max(maxNum, nums[i]);
            int score = maxNum - suffix[i];
            if (score <= k) return i;
        }
        return -1;
    }
}
