package hashTable.problem2996;

// Problem 2996 - Smallest Missing Integer Greater Than Sequential Prefix Sum
// Link: https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/
// Level: Easy

public class Solution {
    // #1. Hash Table Approach
    // Time Complexity: O(n) where n is the length of `nums`
    // Space Complexity: O(1) since the boolean array has a fixed size of 1276
    public int missingInteger(int[] nums) {
        int n = nums.length;
        int sequentialSum = nums[0];

        // Find the longest Prefix Sequential Sum
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sequentialSum += nums[i];
            } else
                break;
        }

        // Create a hash table to store the numbers in the array (1+2+3+...+50 = 1275)
        boolean[] hashTable = new boolean[1276];

        // populating the hash table
        for (int num : nums) {
            hashTable[num] = true;
        }

        // Find the missing integer greater than the sequential prefix sum
        while (hashTable[sequentialSum]) {
            sequentialSum++;
        }

        return sequentialSum;
    }
}
