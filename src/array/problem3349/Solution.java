package array.problem3349;

// Problem 3349 - Adjacent Increasing Subarrays Detection I
// https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i/
// Level: Easy

import java.util.List;

public class Solution {
    // #1. Single Pass with Two Counters
    // Time Complexity: O(n) where n is the length of the input list
    // Space Complexity: O(1)
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int previousIncreasingCount = 0;
        int currentIncreasingCount = 1;
        for(int i = 1; i < n; i++){
            if(nums.get(i) > nums.get(i - 1)){
                currentIncreasingCount++;
            } else {
                previousIncreasingCount = currentIncreasingCount;
                currentIncreasingCount = 1;
            }
            if((previousIncreasingCount >= k && currentIncreasingCount >= k) || currentIncreasingCount >= 2 * k){
                return true;
            }
        }
        return false;
    }
}
