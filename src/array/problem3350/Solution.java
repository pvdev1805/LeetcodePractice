package array.problem3350;

// Problem 3350 - Adjacent Increasing Subarrays Detection II
// https://leetcode.com/problems/adjacent-increasing-subarrays-detection-ii/
// Level: Medium

import java.util.List;

public class Solution {
    // #1. Single Pass with Two Counters
    // Time Complexity: O(n) where n is the length of the input list
    // Space Complexity: O(1)
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int previousIncreasingCount = 0;
        int currentIncreasingCount = 1;
        int k = 0;
        for(int i = 1; i < n; i++){
            if(nums.get(i) > nums.get(i - 1)){
                currentIncreasingCount++;
            } else {
              previousIncreasingCount = currentIncreasingCount;
              currentIncreasingCount = 1;
            }
            if(previousIncreasingCount >= currentIncreasingCount && currentIncreasingCount > k){
                k = currentIncreasingCount;
            } else if(currentIncreasingCount % 2 == 0 && currentIncreasingCount / 2 > k){
                k = currentIncreasingCount / 2;
            }
        }
        return k;
    }
}
