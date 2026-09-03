package array.problem3876;

// Problem 3876 - Construct Uniform Parity Array II
// Link: https://leetcode.com/problems/construct-uniform-parity-array-ii/
// Level: Medium

public class Solution {
    // #1. Minimum Number Approach
    // Time Complexity: O(n) where n is the length of `nums1`
    // Space Complexity: O(1) since we are using a constant amount of extra space
    public boolean uniformArray(int[] nums1) {
        int minNum = Integer.MAX_VALUE;
        int oddCount = 0;
        for (int num : nums1) {
            if (num < minNum) minNum = num;
            if (num % 2 == 1) oddCount++;
        }
        // Minimum number is odd --> the remaining even numbers are all > min number OR All numbers are even
        return minNum % 2 == 1 || oddCount == 0;
    }
}
