package bitManipulation.problem1009;

// Problem 1009 - Complement of Base 10 Integer
// Link: https://leetcode.com/problems/complement-of-base-10-integer/
// Level: Easy

public class Solution {
    // #1. Bit Manipulation Approach
    // Time Complexity: O(log N), where N is the input integer n, since we are iterating through the bits of n to create the mask.
    // Space Complexity: O(1), since we are using only a constant amount of extra space to store the mask and the result.
    public int bitwiseComplement(int n) {
        if (n == 0) return 1; // Special case for 0, since its complement is 1
        int mask = 1; // Initialize mask to 1 (binary 000...001)
        while (mask < n) { // Loop until mask exceeds n
            mask = (mask << 1) | 1; // Shift mask left and set the least significant bit to 1 (binary 000...011, then 000...111, etc.)
        }
        return n ^ mask; // XOR n with the mask to get the complement
    }

    // #2. Alternative Bit Manipulation Approach
    // Time Complexity: O(1), since the number of bits in an integer is fixed (32 bits for a standard integer), the operations we perform are constant time.
    // Space Complexity: O(1), since we are using only a constant amount of extra space to store the mask and the result.
    public int bitwiseComplement2(int n) {
        if (n == 0) return 1; // Special case for 0, since its complement is 1
        int k = (int) (Math.log(n) / Math.log(2)) + 1; // Calculate the number of bits needed to represent n
        int mask = (1 << k) - 1; // Create a mask with k bits set to 1 (binary 000...111 for k bits)
        return n ^ mask; // XOR n with the mask to get the complement
    }
}
