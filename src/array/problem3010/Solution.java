package array.problem3010;

// Problem 3010 - Divide an Array Into Subarrays With Minimum Cost I
// Link: https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/
// Level: Easy

import java.util.Arrays;

public class Solution {
    // #1. Find the two smallest elements
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            if(nums[i] < min1){
                min2 = min1;
                min1 = nums[i];
            } else if(nums[i] < min2){
                min2 = nums[i];
            }
        }
        return nums[0] + min1 + min2;
    }

    // #2. Sorting
    // Time Complexity: O(N*logN)
    // Space Complexity: O(logN) for sorting
    public int minimumCost2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums, 1, n);
        return nums[0] + nums[1] + nums[2];
    }
}
