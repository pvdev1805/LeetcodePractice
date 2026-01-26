package Sorting.problem1200;

// Problem 1200 - Minimum Absolute Difference
// Link: https://leetcode.com/problems/minimum-absolute-difference/
// Level: Easy

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    // #1. Sorting
    // Time Complexity: O(N*log N)
    // Space Complexity: O(log N) for sorting
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        int minAbsDiff = Integer.MAX_VALUE;
        List<List<Integer>> result = new LinkedList<>();
        for(int i = 0; i < n - 1; i++){
            int currentAbsDiff = Math.abs(arr[i] - arr[i + 1]);
            if(currentAbsDiff > minAbsDiff) continue;
            if(currentAbsDiff < minAbsDiff){
                minAbsDiff = currentAbsDiff;
                result.clear();
            }
            List<Integer> pair = new LinkedList<>();
            pair.add(arr[i]);
            pair.add(arr[i + 1]);
            result.add(pair);
        }
        return result;
    }
}
