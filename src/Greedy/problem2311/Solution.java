package Greedy.problem2311;

// Problem 2311 - Longest Binary Subsequence Less Than or Equal to K
// Link: https://leetcode.com/problems/longest-binary-subsequence-less-than-or-equal-to-k/
// Level: Medium

public class Solution {
    // #1. Greedy
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int zeros = 0, ones = 0;
        long pow = 1, value = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '0') zeros++;
        }
        for(int i = n - 1; i >= 0; i--){
            if(s.charAt(i) == '1'){
                if(value + pow > k){
                    continue;
                }
                value += pow;
                ones++;
            }
            pow <<= 1;
            if(pow > k){
                break;
            }
        }
        return zeros + ones;
    }
}
