package Math.problem3736;

// Problem 3736 - Minimum Moves to Equal Array Elements III
// Link: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-iii
// Level: Easy

public class Solution {
    // #1. Iterative Approach
    // Time Complexity: O(n) since we are iterating through the array once
    // Space Complexity: O(1) since we are using a constant amount of extra space
    public int minMoves(int[] nums) {
        int moves = 0;
        int maxNum = Integer.MIN_VALUE;
        for(int num : nums){
            if(num > maxNum) maxNum = num;
        }
        for(int num : nums){
            moves += (maxNum - num);
        }
        return moves;
    }

    // #2. Mathematical Approach
    // Time Complexity: O(n) since we are iterating through the array once
    // Space Complexity: O(1) since we are using a constant amount of extra space
    public int minMoves2(int[] nums) {
        int n = nums.length;
        int maxNum = Integer.MIN_VALUE;
        int sum = 0;
        for(int num : nums){
            if(num > maxNum) maxNum = num;
            sum += num;
        }
        return n * maxNum - sum;
    }
}
