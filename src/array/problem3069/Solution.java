package array.problem3069;

// Problem 3069 - Distributed Elements Into Two Arrays I
// Link: https://leetcode.com/problems/distribute-elements-into-two-arrays-i/
// Level: Easy

import java.util.LinkedList;
import java.util.List;

public class Solution {
    // #1. Greedy Approach
    // Time Complexity: O(n) where n is the length of `nums`
    // Space Complexity: O(n) for the two lists used to store the distributed elements
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        List<Integer> arr1 = new LinkedList<>();
        List<Integer> arr2 = new LinkedList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for (int i = 2; i < n; i++) {
            if (arr1.getLast() > arr2.getLast()) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }
        int[] result = new int[n];
        for (int i = 0; i < arr1.size(); i++) {
            result[i] = arr1.get(i);
        }
        for (int i = 0; i < arr2.size(); i++) {
            result[arr1.size() + i] = arr2.get(i);
        }
        return result;
    }
}
