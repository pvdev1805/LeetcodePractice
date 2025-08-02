package hashMap.problem169;

// Problem 169 - Majority Element
// Link: https://leetcode.com/problems/majority-element/
// Level: Easy

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    // #1. Sorting Approach
    // Time Complexity: O(n log n), where n is the length of the input array
    // Space Complexity: O(1), if we ignore the space used by the sorting algorithm.
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n/2];
    }

    // #2. HashMap Approach
    // Time Complexity: O(n), where n is the length of the input array
    // Space Complexity: O(n), for storing the frequency of each element.
    public int majorityElement2(int[] nums) {
        int n = nums.length;
        int threshold = n/2;

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            if (frequencyMap.get(num) > threshold) {
                return num;
            }
        }
        return -1;
    }
}
