package bitManipulation.problem693;

// Problem 693 - Binary Number with Alternating Bits
// Link: https://leetcode.com/problems/binary-number-with-alternating-bits/
// Level: Easy

public class Solution {
    // #1. Bit Manipulation Approach
    // Time Complexity: O(log n), where n is the input number, since we are processing each bit of n.
    // Space Complexity: O(1), no extra space used.
    public boolean hasAlternatingBits(int n) {
        int lastBit = n & 1; // Get the least significant bit
        n >>= 1; // Shift n right to process the next bit
        while (n > 0) {
            int currentBit = n & 1; // Get the current least significant bit
            if (currentBit == lastBit) { // If the current bit is the same as the last bit, return false
                return false;
            }
            lastBit = currentBit; // Update lastBit to the current bit
            n >>= 1; // Shift n right to process the next bit
        }
        return true; // If we processed all bits without finding adjacent bits that are the same, return true
    }

    // #2. Bit Manipulation with Shifted Comparison
    // Time Complexity: O(1), since we are performing a constant number of bitwise operations.
    // Space Complexity: O(1), no extra space used.
    public boolean hasAlternatingBits2(int n) {
        return (n & (n >> 1)) == 0 && (n & (n >> 2)) == (n >> 2);
    }
}
