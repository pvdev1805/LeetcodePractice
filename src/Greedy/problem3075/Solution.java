package Greedy.problem3075;

// Problem 3075 - Maximize Happiness of Selected Children
// Link: https://leetcode.com/problems/maximize-happiness-of-selected-children/
// Level: Medium

import java.util.Arrays;

public class Solution {
    // #1. Greedy + Sorting
    // Time Complexity: O(N log N)
    // Space Complexity: O(1)
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long totalHappiness = 0;
        int n = happiness.length - 1;
        for(int i = 0; i < k; i++){
            int currentHappiness = happiness[n - i] - i;
            if(currentHappiness > 0){
                totalHappiness += currentHappiness;
            } else break;
        }
        return totalHappiness;
    }
}
