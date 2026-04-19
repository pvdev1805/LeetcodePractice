package twoPointers.problem1855;

// Problem 1855 - Maximum Distance Between a Pair of Values
// Link: https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/
// Level: Medium

public class Solution {
    // #1. Two Pointers Approach
    // Time Complexity: O(N + M), where N is the length of the input array nums1 and M is the length of the input array nums2, since we need to iterate through both arrays once using two pointers, we are using O(N + M) time.
    // Space Complexity: O(1), since we are using a constant amount of space to store the pointers and the variable for maximum distance, we are using O(1) space.
    public int maxDistance(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int i = 0, j = 0;
        int maxDistance = 0;
        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                maxDistance = Math.max(maxDistance, j - i);
                j++;
            } else {
                i++;
            }
        }
        return maxDistance;
    }

    // #2. Binary Search Approach
    // Time Complexity: O(N*logM), where N is the length of the input array nums1 and M is the length of the input array nums2, since we need to iterate through the array nums1 once and for each element in nums1, we perform a binary search on the array nums2, which takes O(log M) time, we are using O(N log M)
    // Space Complexity: O(1), since we are using a constant amount of space to store the pointers and the variable for maximum distance, we are using O(1) space.
    public int maxDistance2(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int maxDistance = 0;
        for (int i = 0; i < n1; i++) {
            int left = i, right = n2 - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums1[i] <= nums2[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (right >= i) {
                maxDistance = Math.max(maxDistance, right - i);
            }
        }
        return maxDistance;
    }
}
