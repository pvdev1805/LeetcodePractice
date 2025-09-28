package Greedy.problem976;

// Problem 976 - Largest Perimeter Triangle
// https://leetcode.com/problems/largest-perimeter-triangle/
// Level: Easy

import java.util.Arrays;

public class Solution {
    // #1. Sorting + Greedy
    // Time Complexity: O(n * log n) where n is the length of the input array
    // Space Complexity: O(1) if we ignore the space used for sorting.
    public int largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        for(int i = n - 1; i >= 2; i--){
            if(nums[i - 1] + nums[i - 2] > nums[i]){
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }
}
