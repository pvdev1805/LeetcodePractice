package Math.problem1291;

// Problem 1291 - Sequential Digits
// Link: https://leetcode.com/problems/sequential-digits/
// Level: Medium

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    // #1. Brute Force Approach
    // Time Complexity: O(1) since the number of sequential digits is limited (there are only 36 possible sequential digits)
    // Space Complexity: O(1) since the result list will contain at most 36 elements
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new LinkedList<>();
        for (int i = 1; i <= 9; i++) {
            int num = i;
            for (int j = i + 1; j <= 9; j++) {
                num = num * 10 + j;
                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}
