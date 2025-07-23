package dynamicProgramming.problem118;

// Problem 118 - Pascal's Triangle
// Link: https://leetcode.com/problems/pascals-triangle/
// Level: Easy

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // #1. Iterative Approach
    // Time Complexity: O(numRows^2)
    // Space Complexity: O(numRows)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> prevRow = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList<>();
            for (int k = 0; k <= i; k++) {
                currentRow.add(1);
            }

            for (int j = 1; j < i; j++) {
                currentRow.set(j, prevRow.get(j - 1) + prevRow.get(j));
            }

            result.add(currentRow);
            prevRow = new ArrayList<>(currentRow);
        }

        return result;
    }
}
