package array.problem1848;

// Problem 1848 - Minimum Distance to the Target Element
// Link: https://leetcode.com/problems/minimum-distance-to-the-target-element/
// Level: Easy

public class Solution {
    // #1. Linear Search Approach
    // Time Complexity: O(N), where N is the length of the input array nums, since we need to iterate through the array once to find the minimum distance to the target element.
    // Space Complexity: O(1), since we are using only a constant amount of extra space to store the minimum distance variable, we are not using any additional space that grows with the input size.
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                minDistance = Math.min(minDistance, Math.abs(i - start)); // Update the minimum distance if the current element matches the target
            }
        }
        return minDistance; // Return the minimum distance found
    }

    // #2. Two-Pointer Approach
    // Time Complexity: O(N), where N is the length of the input array nums, since in the worst case we may need to check all elements in the array to find the minimum distance to the target element.
    // Space Complexity: O(1), since we are using only a constant amount of extra space to store the minimum distance variable and the two pointers, we are not using any additional space that grows with the input size.
    public int getMinDistance2(int[] nums, int target, int start) {
        int n = nums.length;
        int left = start;
        int right = start;
        int minDistance = Integer.MAX_VALUE;

        while (left >= 0 || right < n) {
            if (left >= 0 && nums[left] == target) {
                minDistance = Math.min(minDistance, Math.abs(left - start)); // Update the minimum distance if the left pointer matches the target
            }
            if (right < n && nums[right] == target) {
                minDistance = Math.min(minDistance, Math.abs(right - start)); // Update the minimum distance if the right pointer matches the target
            }
            left--; // Move left pointer to the left
            right++; // Move right pointer to the right
        }
        return minDistance; // Return the minimum distance found
    }
}
