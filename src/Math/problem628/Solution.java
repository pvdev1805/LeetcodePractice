package Math.problem628;

// Problem 628 - Maximum Product of Three Numbers
// Link: https://leetcode.com/problems/maximum-product-of-three-numbers
// Level: Easy

import java.util.Arrays;

public class Solution {
    // #1. Simple Approach
    // Time Complexity: O(n) where n is the length of `nums`
    // Space Complexity: O(1) since we are using a constant amount of space
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }

    // #2. Sorting Approach
    // Time Complexity: O(n log n) due to sorting
    // Space Complexity: O(1) if we ignore the space used by the sorting algorithm
    public int maximumProduct2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
    }
}
