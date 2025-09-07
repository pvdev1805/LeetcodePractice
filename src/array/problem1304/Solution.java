package array.problem1304;

// Problem 1304 - Find N Unique Integers Sum up to Zero
// Link: https://leetcode.com/problems/find-n-unique-integers-sum-up-to
// Level: Easy

public class Solution {
    // #1. Pairing Approach
    // Time Complexity: O(n), where n is the input integer.
    // Space Complexity: O(n), where n is the size of the output array.
    public int[] sumZero(int n) {
        int[] result = new int[n];
        for(int i = 0; i < n/2; i++){
            result[i*2] = i+1;
            result[i*2 + 1] = -i - 1;
        }
        return result;
    }
}
