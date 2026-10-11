package array.problem2778;

// Problem 2778 - Sum of Squares of Special Elements
// Link: https://leetcode.com/problems/sum-of-squares-of-special-elements/
// Level: Easy

public class Solution {
    // #1. Iterative Approach
    // Time Complexity: O(n) since we are iterating through the array once
    // Space Complexity: O(1) since we are using a constant amount of extra space
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (n % (i + 1) == 0) {
                sum += nums[i] * nums[i];
            }
        }
        return sum;
    }
}
