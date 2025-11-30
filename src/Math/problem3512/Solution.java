package Math.problem3512;

// Problem 3512 - Minimum Operations to Make Array Sum Divisible by K
// Link: https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k/
// Level: Easy

public class Solution {
    // #1. Remainder Calculation
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for(int num: nums) sum += num;
        return sum % k;
    }
}
