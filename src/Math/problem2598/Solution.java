package Math.problem2598;

// Problem 2598 - Smallest Missing Non-negative Integer After Operations
// https://leetcode.com/problems/smallest-missing-non-negative-integer-after-operations
// Level: Medium

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // #1. Math + Counting
    // Time Complexity: O(n) where n is the length of the input array
    // Space Complexity: O(v) where v is the value of the input integer
    public int findSmallestInteger(int[] nums, int value) {
        int n = nums.length;
        int[] remainders = new int[value];
        for(int num : nums){
            num %= value;
            if(num < 0) num += value;
            remainders[num]++;
        }
        for(int i = 0; i < n; i++){
            int remainder = i % value;
            remainders[remainder]--;
            if(remainders[remainder] < 0) return i;
        }
        return n;
    }
}
