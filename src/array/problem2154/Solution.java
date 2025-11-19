package array.problem2154;

// Problem 2154 - Keep Multiplying Found Values by Two
// Link: https://leetcode.com/problems/keep-multiplying-found-values-by-two/
// Level: Easy

import java.util.Arrays;

public class Solution {
    // #1. Sorting
    // Time Complexity: O(N log N)
    // Space Complexity: O(1)
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        for(int num : nums){
            if(num == original){
                original *= 2;
            }
        }
        return original;
    }

    // #2. Hashing
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int findFinalValue2(int[] nums, int original) {
        boolean[] found = new boolean[1001];
        for(int num : nums){
            found[num] = true;
        }
        while(original <= 1000 && found[original]){
            original *= 2;
        }
        return original;
    }
}
