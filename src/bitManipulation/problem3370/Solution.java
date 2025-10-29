package bitManipulation.problem3370;

// Problem 3370 - Smallest Number With All Set Bits
// https://leetcode.com/problems/smallest-number-with-all-set-bits/
// Level: Easy

public class Solution {
    // #1. Bit Manipulation
    // Time Complexity: O(log n) where n is the input number
    // Space Complexity: O(1)
    public int smallestNumber(int n) {
        int x = 1;
        while(x - 1 < n){
            // x <<= 1;
            x = x << 1; // Left shift to get the next power of 2 (x = x * 2)
        }
        return x - 1; // Subtract 1 to get a number with all bits set to 1
    }
}
