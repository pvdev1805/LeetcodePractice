package slidingWindow.problem1984;

// Problem 1984 - Minimum Difference Between Highest and Lowest of K Scores
// Link: https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
// Level: Easy

import java.util.Arrays;

public class Solution {
    // #1. Sorting + Sliding Window
    // Time Complexity: O(N*logN)
    // Space Complexity: O(logN) for sorting
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        if(k <= 1 || n <= 1) return 0;
        Arrays.sort(nums);
        int minDifference = Integer.MAX_VALUE;
        int left = 0, right = k - 1;
        while(right < n){
            int currentDifference = nums[right] - nums[left];
            minDifference = Math.min(minDifference, currentDifference);
            left++;
            right++;
        }
        return minDifference;
    }

    // #2. Sorting
    // Time Complexity: O(N*logN)
    // Space Complexity: O(logN) for sorting
    public int minimumDifference2(int[] nums, int k) {
        int n = nums.length;
        if(k <= 1 || n <= 1) return 0;
        Arrays.sort(nums);

        int minDifference = nums[k - 1] - nums[0];
        for(int i = 1; i <= n - k; i++){
            int currentDifference = nums[i + k - 1] - nums[i];
            minDifference = Math.min(minDifference, currentDifference);
        }
        return minDifference;
    }
}
