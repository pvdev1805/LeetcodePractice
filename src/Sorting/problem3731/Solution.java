package Sorting.problem3731;

// Problem 3731 - Find Missing Elements
// Link: https://leetcode.com/problems/find-missing-elements/
// Level: Easy

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    // #1. Sorting Approach
    // Time Complexity: O(n log n) due to sorting
    // Space Complexity: O(n) for the result list
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int currentNum = nums[0];
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != currentNum) {
                ans.add(currentNum);
                i--;
            }
            currentNum++;
        }
        return ans;
    }

    // #2. Sorting Approach with While Loop
    // Time Complexity: O(n log n) due to sorting
    // Space Complexity: O(n) for the result list
    public List<Integer> findMissingElements2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int currentNum = nums[0];
        List<Integer> ans = new LinkedList<>();
        int idx = 0;
        while (idx < n) {
            if (nums[idx] != currentNum) {
                ans.add(currentNum);
            } else {
                idx++;
            }
            currentNum++;
        }
        return ans;
    }

    // #3. Hash Table Approach
    // Time Complexity: O(n) where n is the length of `nums`
    // Space Complexity: O(1) since the boolean array has a fixed size of 101
    public List<Integer> findMissingElements3(int[] nums) {
        int n = nums.length;
        int minNum = 101, maxNum = 0;
        boolean[] flag = new boolean[101];
        List<Integer> ans = new LinkedList<>();
        for (int num : nums) {
            if (maxNum < num) {
                maxNum = num;
            }
            if (minNum > num) {
                minNum = num;
            }
            flag[num] = true;
        }
        for (int i = minNum; i <= maxNum; i++) {
            if (!flag[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}
