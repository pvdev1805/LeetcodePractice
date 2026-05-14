package array.problem2784;

// Problem 2784 - Check if Array is Good
// Link: https://leetcode.com/problems/check-if-array-is-good/
// Level: Easy

public class Solution {
    // #1. Counting Occurrences Approach
    // Time Complexity: O(N), where N is the length of the input array nums, since we need to iterate through the array once to count the occurrences of each number, we are using O(N) time.
    // Space Complexity: O(N), since we are using an array to count the occurrences of each number, in the worst case, if all numbers from 1 to n-1 are present, we are using O(N) space.
    public boolean isGood(int[] nums) {
        int n = nums.length;
        if (n < 2) return false; // A good array must have at least 2 elements (1 to n-1 and n)
        int maxNum = n - 1; // The maximum number we expect in a good array is n-1
        int[] count = new int[maxNum + 1];
        for (int num : nums) {
            if (num > maxNum) return false; // If we find a number greater than n-1, it's not a good array
            count[num]++; // Count the occurrences of each number
            if (num != maxNum && count[num] > 1) return false;
            if (num == maxNum && count[num] > 2) return false;
        }
        for (int i = 1; i < maxNum; i++) {
            if (count[i] != 1) return false; // Each number from 1 to maxNum-1 must appear exactly once
        }
        return count[maxNum] == 2; // The number maxNum must appear exactly twice
    }
}
