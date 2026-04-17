package hashMap.problem3761;

// Problem 3761 - Minimum Absolute Distance Between Mirror Pairs
// Link: https://leetcode.com/problems/minimum-absolute-distance-between-mirror-pairs/
// Level: Medium

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // #1. HashMap Approach
    // Time Complexity: O(N * M), where N is the length of the input array nums and M is the number of digits in the largest number in nums, since we need to iterate through the array once and reverse each number, which takes O(M) time.
    // Space Complexity: O(N), since in the worst case we may need to store all numbers in the input array nums in the HashMap, we are using O(N) space to store the reversed numbers and their indices.
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        int minDistance = Integer.MAX_VALUE;

        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int currentNum = nums[i];
            if (mp.containsKey(currentNum)) {
                minDistance = Math.min(minDistance, Math.abs(i - mp.get(currentNum)));
            }
            int reversedNum = reverseNumber(currentNum);
            mp.put(reversedNum, i);
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance; // Return -1 if no mirror pairs are found, otherwise return the minimum distance
    }

    private int reverseNumber(int num) {
        if (num <= 9) return num; // Base case: single-digit numbers are the same when reversed'
        int revNum = 0;
        while (num > 0) {
            int digit = num % 10; // Get the last digit of the number
            revNum = revNum * 10 + digit; // Append the digit to the reversed number
            num /= 10; // Remove the last digit from the original number
        }
        return revNum; // Return the reversed number
    }
}
