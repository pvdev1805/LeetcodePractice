package array.problem3105;

// Problem 3105 - Longest Strictly Increasing or Strictly Decreasing Subarray
// Link: https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/
// Level: Easy

public class Solution {
    // #1. Iterative Approach
    // Time Complexity: O(n) since we are iterating through the array once
    // Space Complexity: O(1) since we are using a constant amount of extra space
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int ans = 1, increasingLength = 1, decreasingLength = 1;
        for (int i = 1; i < n; i++) {
            int isIncreasing = (nums[i] > nums[i - 1]) ? 1 : 0; // Check if the current element is greater than the previous one
            int isDecreasing = (nums[i] < nums[i - 1]) ? 1 : 0; // Check if the current element is less than the previous one
            increasingLength = (isIncreasing == 1) ? increasingLength + 1 : 1; // Reset the increasing length if the current element is not greater than the previous one
            decreasingLength = (isDecreasing == 1) ? decreasingLength + 1 : 1; // Reset the decreasing length if the current element is not less than the previous one
            ans = Math.max(ans, Math.max(increasingLength, decreasingLength)); // Update the answer with the maximum of the current increasing and decreasing lengths
        }
        return ans;
    }
}
