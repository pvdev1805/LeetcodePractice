package Sorting.problem1877;

// Problem 1877 - Minimize Maximum Pair Sum in Array
// Link: https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/
// Level: Medium

import java.util.Arrays;

public class Solution {
    // #1. Sorting + Two Pointers + Greedy
    // Time Complexity: O(N log N)
    // Space Complexity: O(1)
    public int minPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0, right = n -1;
        int minMaxPairSum = 0;
        while(left < right){
            int currentPairSum = nums[left] + nums[right];
            minMaxPairSum = Math.max(minMaxPairSum, currentPairSum);
            left++;
            right--;
        }
        return minMaxPairSum;
    }
}
