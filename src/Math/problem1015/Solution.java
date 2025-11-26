package Math.problem1015;

// Problem 1015 - Smallest Integer Divisible by K
// Link: https://leetcode.com/problems/smallest-integer-divisible-by-k/
// Level: Medium

public class Solution {
    // #1. Remainder Cycle Detection
    // Time Complexity: O(K)
    // Space Complexity: O(1)
    public int smallestRepunitDivByK(int k) {
        // If k is 1, the smallest number consisting of only 1's that is divisible by k is 1 itself
        if(k == 1) return 1;
        // If k is divisible by 2 or 5, there is no such number consisting of only 1's that is divisible by k
        if(k % 2 == 0 || k % 5 == 0) return -1;

        int remainder = 0;
        // We try lengths from 1 to k
        // Ex: length = 3 -> 111 % k, length = 4 -> 1111 % k
        for(int length = 1; length <= k; length++){
            remainder = (remainder * 10 + 1) % k;
            if(remainder == 0) return length;
        }
        return -1;
    }
}
