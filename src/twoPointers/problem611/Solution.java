package twoPointers.problem611;

// Problem 611 - Valid Triangle Number
// https://leetcode.com/problems/valid-triangle-number/
// Level: Medium

import java.util.Arrays;

public class Solution {
    // #1. Sorting + Two Pointers
    // Time Complexity: O(n^2) where n is the length of the input array.
    // Space Complexity: O(1) if we ignore the space used for sorting.
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int count = 0;
        for(int i = n - 1; i >= 2; i--){
            int left = 0, right = i - 1;
            while(left < right){
                if(nums[left] + nums[right] > nums[i]){
                    count += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }
}
