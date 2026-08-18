package hashTable.problem3471;

// Problem 3471 - Find the Largest Almost Missing Integer
// Link: https://leetcode.com/problems/find-the-largest-almost-missing-integer/
// Level: Easy

public class Solution {
    // #1. Hash Table Approach
    // Time Complexity: O(n) where n is the length of `nums`
    // Space Complexity: O(1) since the frequency array has a fixed size of 51
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[51];
        for (int num : nums) {
            freq[num]++;
        }
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (k == n) {
                res = Math.max(res, nums[i]);
            } else if (freq[nums[i]] == 1) {
                if (k == 1) {
                    res = Math.max(res, nums[i]);
                } else if (i == 0 || i == n - 1) {
                    res = Math.max(res, nums[i]);
                }
            }
        }
        return res;
    }

    // #2. Hash Table Approach with Combined Conditions
    // Time Complexity: O(n) where n is the length of `nums`
    // Space Complexity: O(1) since the frequency array has a fixed size of 51
    public int largestInteger2(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[51];
        for (int num : nums) {
            freq[num]++;
        }
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (k == n || (freq[nums[i]] == 1 && (k == 1 || i == 0 || i == n - 1))) {
                res = Math.max(res, nums[i]);
            }
        }
        return res;
    }
}
