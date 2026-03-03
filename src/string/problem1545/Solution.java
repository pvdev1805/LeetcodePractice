package string.problem1545;

// Problem 1545 - Find Kth Bit in Nth Binary String
// Link: https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/
// Level: Medium

public class Solution {
    // #1. Recursive Approach
    // Time Complexity: O(N), where N is the value of n, since we are recursively building the binary string up to n. However, we are not actually constructing the string, so the time complexity is effectively O(1) for finding the kth bit.
    // Space Complexity: O(N), due to the recursion stack in the worst case when n is large.
    public char findKthBit(int n, int k) {
        if (n == 1) return '0'; // Base case: the first binary string is "0"
        int length = (1 << n) - 1; // Calculate the length of the nth binary string, which is 2^n - 1
        if (k == length) return '1'; // If k is the last index, return '1'
        int mid = length / 2 + 1; // Calculate the middle index of the binary string
        if (k == mid) return '1'; // If k is the middle index, return '1'
        if (k < mid)
            return findKthBit(n - 1, k); // If k is less than the middle index, or on the left side, the kth bit is the same as the kth bit in the (n-1)th binary string
        return findKthBit(n - 1, length - k + 1) == '0' ? '1' : '0'; // If k is greater than the middle index, or on the right side, we need to find the corresponding bit in the (n-1)th binary string and invert it
    }
}
