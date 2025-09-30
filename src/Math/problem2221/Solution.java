package Math.problem2221;

// Problem 2221 - Find Triangular Sum of an Array
// https://leetcode.com/problems/find-triangular-sum-of-an-array/
// Level: Medium

public class Solution {
    // #1. Simulation
    // Time Complexity: O(n^2) where n is the length of the input array
    // Space Complexity: O(n) for the new array created in each iteration.
    public int triangularSum(int[] nums) {
        int n = nums.length;
        for(int i = n - 1; i >= 1; i--){
            int[] newNums = new int[i];
            for(int j = 0; j < i; j++){
                newNums[j] = (nums[j] + nums[j + 1]) % 10;
            }
            nums = newNums;
        }
        return nums[0];
    }
}
