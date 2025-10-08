package binarySearch.problem2300;

// Problem 2300 - Successful Pairs of Spells and Potions
// https://leetcode.com/problems/successful-pairs-of-spells-and-potions/
// Level: Medium

import java.util.Arrays;

public class Solution {
    // #1. Sorting + Binary Search
    // Time Complexity: O(n log m) where n is the length of spells and m is the length of potions
    // Space Complexity: O(N) where N is the number of spells
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int maxPotion = potions[m - 1];
        int[] pairs = new int[n];
        for(int i = 0; i < n; i++){
            int spell = spells[i];
            long target = (long) Math.ceil((double) success / spell);
            if(target <= maxPotion){
                int index = binarySearch(potions, target);
                pairs[i] = m - index;
            }
        }
        return pairs;
    }

    // Find the first index in potions where the value is greater than or equal to target
    // Time Complexity: O(log m) where m is the length of potions
    // Space Complexity: O(1)
    private int binarySearch(int[] potions, long target){
        int left = 0, right = potions.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(potions[mid] >= target){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
