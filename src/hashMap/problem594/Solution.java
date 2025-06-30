package hashMap.problem594;

// Problem 594 - Longest Harmonious Subsequence
// Link: https://leetcode.com/problems/longest-harmonious-subsequence/
// Level: Easy

import java.util.HashMap;

public class Solution {
    // #1. HashMap
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int findLHS(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num: nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;
        for(int num: frequencyMap.keySet()){
            if(frequencyMap.containsKey(num + 1)){
                int currentLength = frequencyMap.get(num) + frequencyMap.get(num + 1);
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }
}
