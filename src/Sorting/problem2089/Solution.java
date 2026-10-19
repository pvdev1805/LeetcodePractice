package Sorting.problem2089;

// Problem 2089 - Find Target Indices After Sorting Array
// Link: https://leetcode.com/problems/find-target-indices-after-sorting-array/
// Level: Easy

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    // #1. Sorting + Iteration Approach
    // Time Complexity: O(NlogN) since we are sorting the array
    // Space Complexity: O(N) since we are using a list to store the result
    public List<Integer> targetIndices(int[] nums, int target) {
        int n = nums.length;

        Arrays.sort(nums);

        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                result.add(i);
            }
        }

        return result;
    }

    // #2. Counting Approach
    // Time Complexity: O(N) since we are iterating through the array once
    // Space Complexity: O(N) since we are using a list to store the result
    public List<Integer> targetIndices2(int[] nums, int target) {
        int lessCount = 0, equalCount = 0;

        for (int num : nums) {
            if (num < target) lessCount++;
            else if (num == target) equalCount++;
        }

        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < equalCount; i++) {
            result.add(lessCount + i);
        }

        return result;
    }
}
