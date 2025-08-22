package matrix.problem3195;

// Problem 3195 - Find the Minimum Area to Cover All Ones I
// Link: https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-i/
// Level: Medium

public class Solution {
    // #1. Matrix Traversal Approach
    // Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the matrix.
    // Space Complexity: O(1), no extra space used.
    public int minimumArea(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int minRows = rows, maxRows = -1;
        int minCols = cols, maxCols = -1;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    if(i < minRows) minRows = i; // Update minimum row index
                    if(i > maxRows) maxRows = i; // Update maximum row index
                    if(j < minCols) minCols = j; // Update minimum column index
                    if(j > maxCols) maxCols = j; // Update maximum column index
                }
            }
        }

        // If no 1s are found, return 0
        return (maxRows == -1) ? 0 : (maxRows - minRows + 1) * (maxCols - minCols + 1);
    }
}
