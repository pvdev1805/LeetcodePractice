package twoPointers.problem2540;

// Problem 2540 - Minimum Common Value
// Link: https://leetcode.com/problems/minimum-common-value/
// Level: Easy

public class Solution {
    // #1. Two Pointers Approach
    // Time Complexity: O(N + M), where N and M are the lengths of the input arrays nums1 and nums2, since we need to iterate through both arrays at most once, we are using O(N + M) time.
    // Space Complexity: O(1), since we are using a constant amount of space to store the pointers and the common value, we are using O(1) space.
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int n1 = nums1.length, n2 = nums2.length;
        while (i < n1 && j < n2) {
            if (nums1[i] == nums2[j]) return nums1[i];
            else if (nums1[i] < nums2[j]) i++;
            else j++;
        }
        return -1;
    }

    // #2. Binary Search Approach
    // Time Complexity: O(N log M), where N is the length of the smaller array and M is the length of the larger array, since we need to iterate through the smaller array and perform binary search on the larger array for each element, we are using O(N log M) time.
    // Space Complexity: O(1), since we are using a constant amount of space to store the pointers and the common value, we are using O(1) space.
    public int getCommon2(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;

        // Determine which array is smaller to optimize the number of binary search operations
        int[] smaller = n1 < n2 ? nums1 : nums2;
        int[] larger = n1 < n2 ? nums2 : nums1;

        // Iterate through the smaller array and perform binary search on the larger array
        for (int num : smaller) {
            if (binarySearch(larger, num)) return num;
        }
        return -1;
    }

    // Helper method to perform binary search on a sorted array
    private boolean binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return true;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
