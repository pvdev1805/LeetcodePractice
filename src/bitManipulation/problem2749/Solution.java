package bitManipulation.problem2749;

// Problem 2749 - Minimum Operations to Make the Integer Zero
// Link: https://leetcode.com/problems/minimum-operations-to-make-the-integer-zero
// Level: Medium

public class Solution {
    // #1. Bit Manipulation and Iteration Approach
    // Time Complexity: O(60 * 60) = O(1), since we iterate a constant number of times (up to 60).
    // Space Complexity: O(1), no extra space used.
    public int makeTheIntegerZero(int num1, int num2) {
        for(int k = 1; k <= 60; k++){
            long x = (long)num1 - (long)k * num2;
            if(x < 0) continue; // If x is negative, skip to the next k
            if(x < k) continue; // If x is less than k, then x < (2^0) * k when all k terms are 2^0, skip to the next k
            if(Long.bitCount(x) <= k) return k;
        }
        return -1;
    }
}
