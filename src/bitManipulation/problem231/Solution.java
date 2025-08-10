package bitManipulation.problem231;

// Problem 231 - Power of Two
// Link: https://leetcode.com/problems/power-of-two/
// Level: Easy

public class Solution {
    // #1. Bit Manipulation Approach
    // Time Complexity: O(1), constant time check.
    // Space Complexity: O(1), no extra space used.
    public boolean isPowerOfTwo(int n) {
        // pow(2, n) == 1 << n --> binary: 4=100, 8=1000, 16=10000, ... => 2^n = 1000...(in binary)
        // n - 1 in binary is 0111...
        // => n & (n - 1) = 1000... & 0111... = 0

        return n > 0 && (n & (n - 1)) == 0;
    }

    // #2. Iterative Approach
    // Time Complexity: O(log n), where n is the input number.
    // Space Complexity: O(1), no extra space used.
    public boolean isPowerOfTwo2(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
}
