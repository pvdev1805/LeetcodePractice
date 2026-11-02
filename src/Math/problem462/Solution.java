package Math.problem462;

// Problem 462 - Minimum Moves to Equal Array Elements II
// Link: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii
// Level: Medium

import java.util.Arrays;

public class Solution {
    // #1. Sorting Approach
    // Time Complexity: O(n log n) due to sorting the array
    // Space Complexity: O(1) if we ignore the space used by the sorting algorithm
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort((nums));
        int median = nums[n / 2];
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(median - num);
        }
        return moves;
    }

    // #2. Quickselect Approach
    // Time Complexity: O(n) on average, O(n^2) in the worst case due to the nature of Quickselect
    // Space Complexity: O(1) if we ignore the space used by the recursion stack in Quickselect
    public int minMoves2_2(int[] nums) {
        int n = nums.length;
        int median = (int) findMedianWithoutSorting(nums);
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(median - num);
        }
        return moves;
    }

    // #3. Quickselect Approach (Alternative Implementation)
    // Time Complexity: O(n) on average, O(n^2) in the worst case due to the nature of Quickselect
    // Space Complexity: O(1) if we ignore the space used by the recursion stack in Quickselect
    public int minMoves2_3(int[] nums) {
        int n = nums.length;
        int median = quickSelect(nums, 0, n - 1, n / 2);
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(median - num);
        }
        return moves;
    }

    // Helper method to perform Lomuto partitioning
    // Time Complexity: O(n) for partitioning
    // Space Complexity: O(1) since we are using a constant amount of extra space
    private int lomutoPartition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;

                // Swap a[i] and a[j]
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        // Swap a[i + 1] and a[high] (or pivot)
        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;

        return i + 1; // Return the index of the pivot after sorting
    }

    // Helper method to perform Quickselect to find the k-th smallest element
    // Time Complexity: O(n) on average, O(n^2) in the worst case
    // Space Complexity: O(1) if we ignore the space used by the recursion stack in Quickselect
    private int quickSelect(int[] a, int low, int high, int k) {
        if (low <= high) {
            int pivotIndex = lomutoPartition(a, low, high);

            if (pivotIndex == k) {
                return a[pivotIndex]; // Found the k-th smallest element
            } else if (pivotIndex < k) {
                return quickSelect(a, pivotIndex + 1, high, k); // Search in the right subarray
            } else {
                return quickSelect(a, low, pivotIndex - 1, k); // Search in the left subarray
            }
        }
        return -1; // This should never be reached if k is valid
    }

    // Helper method to find the median without sorting the entire array
    // Time Complexity: O(n) on average, O(n^2) in the worst case due to the nature of Quickselect
    // Space Complexity: O(1) if we ignore the space used by the recursion stack in Quickselect
    private double findMedianWithoutSorting(int[] a) {
        int n = a.length;
        if (n == 0) return 0; // Edge case: empty array
        // If the array has an odd number of elements, return the middle element
        if (n % 2 != 0) {
            return quickSelect(a, 0, n - 1, n / 2);
        }

        // If the array has an even number of elements, we need to find the average of the two middle elements
        int leftMedian = quickSelect(a, 0, n - 1, n / 2 - 1);
        int rightMedian = quickSelect(a, 0, n - 1, n / 2);
        return (leftMedian + rightMedian) / 2.0;
    }
}
