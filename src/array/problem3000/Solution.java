package array.problem3000;

// Problem 3000 - Maximum Area of Longest Diagonal Rectangle
// Link: https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/
// Level: Easy

public class Solution {
    // #1. Single-pass Iteration Approach
    // Time Complexity: O(n), where n is the number of rectangles.
    // Space Complexity: O(1), no extra space used.
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n = dimensions.length;
        int maxArea = 0;
        double maxDiagonal = 0;
        for(int i = 0; i < n; i++){
            int length = dimensions[i][0];
            int width = dimensions[i][1];
            double diagonal = Math.sqrt(length * length + width * width);
            if(diagonal > maxDiagonal){
                maxDiagonal = diagonal;
                maxArea = length * width;
            } else if(diagonal == maxDiagonal){
                maxArea = Math.max(maxArea, length * width);
            }
        }
        return maxArea;
    }
}
