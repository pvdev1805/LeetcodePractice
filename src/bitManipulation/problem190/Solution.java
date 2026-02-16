package bitManipulation.problem190;

// Problem 190 - Reverse Bits
// Link: https://leetcode.com/problems/reverse-bits/
// Level: Easy

public class Solution {
    // #1. Bit Manipulation Approach
    // Time Complexity: O(1), since we are always processing 32 bits.
    // Space Complexity: O(1), no extra space used.
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++){
            result <<= 1; // Shift result left to make room for the next bit
            if((n & 1) == 1){
                result |= 1; // Set the least significant bit of result if the current bit of n is 1
            }
            n >>= 1; // Shift n right to process the next bit
        }
        return result;
    }
}
