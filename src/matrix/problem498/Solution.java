package matrix.problem498;

// Problem 498 - Diagonal Traverse
// Link: https://leetcode.com/problems/diagonal-traverse/
// Level: Medium

public class Solution {
    // #1. Simulation Approach
    // Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the matrix.
    // Space Complexity: O(m * n), for storing the result.
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];

        int col = 0, row = 0;
        for(int i = 0; i < m*n; i++){
            result[i] = mat[row][col];


            if((col + row) % 2 == 0){
                if(col == n - 1){
                    row++; // Move down if at the last column
                } else if(row == 0){
                    col++; // Move right if at the first row
                } else {
                    // Move up-right
                    col++;
                    row--;
                }
            } else {
                if(row == m - 1){
                    col++; // Move right if at the last row
                } else if(col == 0){
                    row++; // Move down if at the first column
                } else {
                    // Move down-left
                    col--;
                    row++;
                }
            }
        }

        return result; // Return the diagonal traversal result
    }
}
