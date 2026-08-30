package Greedy.problem2091;

// Problem 2091 - Removing Minimum and Maximum From Array
// Link: https://leetcode.com/problems/removing-minimum-and-maximum-from-array/
// Level: Medium

public class Solution {
    // #1. Greedy Approach
    // Time Complexity: O(N) where N is the length of `nums`
    // Space Complexity: O(1) since we are using a constant amount of extra space
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIndex = 0, maxIndex = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
        }

        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);

        // Case 1: Delete both from the left: right - 0 + 1 = right + 1
        int deleteLeft = right + 1;
        // Case 2: Delete both from the right: (n - 1) - left + 1 = n - left
        int deleteRight = n - left;
        // Case 3: Delete one from the left and one from the right: (left - 0 + 1) + ((n - 1) - right + 1)
        int deleteMixed = (left + 1) + (n - right);

        return Math.min(Math.min(deleteLeft, deleteRight), deleteMixed);
    }
}
