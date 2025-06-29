package Sorting.problem1498;

// Problem 1498 - Number of Subsequences That Satisfy The Given Sum Condition
// Link: https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/
// Level: Medium

import java.util.Arrays;

public class Solution {

    // #1. Sorting + Two Pointers
    // Time Complexity: O(NlogN) for sorting + O(N) for two pointers = O(NlogN)
    // Space Complexity: O(N+1) for pow2 array = O(N)
    public int numSubseq(int[] nums, int target) {
        final int mod = 1000000007;
        int n = nums.length;
        Arrays.sort(nums);

        int[] pow2 = new int[n+1];
        pow2[0] = 1;
        for(int i = 1; i <= n; i++){
            pow2[i] = pow2[i-1]*2 % mod;
        }

        int left = 0, right = n - 1;
        int ans = 0;
        while(left <= right){
            if(nums[left] + nums[right] <= target){
                ans = (ans + pow2[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
