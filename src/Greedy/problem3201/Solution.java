package Greedy.problem3201;

// Problem 3201 - Find the Maximum Length of Valid Subsequence I
// Link: https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-i/description/
// Level: Medium

public class Solution {
    // #1. Greedy Approach
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int maximumLength(int[] nums) {
        int oddCount = 0, evenCount = 0, evenLength = 0, oddLength = 0;
        for(int num: nums){
            if(num % 2 == 0){
                evenCount++;
                evenLength = oddLength + 1;
            } else {
                oddCount++;
                oddLength = evenLength + 1;
            }
        }
        return Math.max(Math.max(oddCount, evenCount), Math.max(oddLength, evenLength));
    }
}
