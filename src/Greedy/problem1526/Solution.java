package Greedy.problem1526;

// Problem 1526 - Minimum Number of Increments on Subarrays to Form a Target Array
// https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target
// Level: Hard

public class Solution {
    // #1. Greedy
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int ans = target[0];
        for(int i = 1; i < n; i++){
            if(target[i] > target[i - 1]){
                ans += target[i] - target[i - 1];
            }
        }
        return ans;
    }
}
