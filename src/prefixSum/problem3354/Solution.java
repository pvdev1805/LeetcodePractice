package prefixSum.problem3354;

// Problem 3354 - Make Array Elements Equal to Zero
// https://leetcode.com/problems/make-array-elements-equal-to-zero/
// Level: Easy

public class Solution {
    // #1. Prefix Sum
    // Time Complexity: O(n) where n is the length of the input array nums
    // Space Complexity: O(1)
    public int countValidSelections(int[] nums) {
        int total = 0, leftSum = 0, n = nums.length;
        for(int num : nums) total += num;

        int validSelections = 0;
        for(int i = 0; i < n; i++){
            int rightSum = total - leftSum - nums[i];
            if(nums[i] == 0){
                if(leftSum == rightSum) validSelections += 2;
                else if(leftSum == rightSum + 1 || leftSum == rightSum - 1) validSelections += 1;
            }
            leftSum += nums[i];
        }
        return validSelections;
    }
}
