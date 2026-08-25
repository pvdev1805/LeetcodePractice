package array.problem3718;

// Problem 3718 - Smallest Missing Multiple of K
// Link: https://leetcode.com/problems/smallest-missing-multiple-of-k/
// Level: Easy

public class Solution {
    // #1. Hash Table Approach
    // Time Complexity: O(N) where N is the length of `nums`
    // Space Complexity: O(1) since the boolean array has a fixed size of 101
    public int missingMultiple(int[] nums, int k) {
        boolean[] flag = new boolean[101];
        int maxFlag = 0;
        for (int num : nums) {
            if (num % k == 0) {
                int currentFlag = num / k;
                flag[currentFlag] = true;
                if (currentFlag > maxFlag) {
                    maxFlag = currentFlag;
                }
            }
        }
        for (int i = 1; i <= maxFlag; i++) {
            if (!flag[i]) {
                return i * k;
            }
        }
        return (maxFlag + 1) * k;
    }
}
