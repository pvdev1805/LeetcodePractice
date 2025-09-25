package dynamicProgramming.problem120;

// Problem 120 - Triangle
// https://leetcode.com/problems/triangle/
// Level: Medium

import java.util.List;

public class Solution {
    // #1. Bottom-Up Dynamic Programming
    // Time Complexity: O(n^2) where n is the number of rows in the triangle.
    // Space Complexity: O(1) since we are modifying the triangle in place.
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                int below = triangle.get(i + 1).get(j);
                int belowRight = triangle.get(i + 1).get(j + 1);
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(below, belowRight));
            }
        }
        return triangle.get(0).get(0);
    }
}
