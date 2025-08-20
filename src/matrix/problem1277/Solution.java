package matrix.problem1277;

// Problem 1277 - Count Square Submatrices with All Ones
// Link: https://leetcode.com/problems/count-square-submatrices-with-all-ones/
// Level: Medium

public class Solution {
    // #1. Dynamic Programming Approach
    // Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the matrix.
    // Space Complexity: O(1), since we are modifying the input matrix in place.
    public int countSquares(int[][] matrix) {
        final int rows = matrix.length;
        final int cols = matrix[0].length;
        int count = 0;

        for(int i = 0; i < cols; i++){
            count += matrix[0][i]; // Count squares in the first row
        }

        for(int i = 1; i < rows; i++){
            count += matrix[i][0]; // Count squares in the first column
        }

        for(int i = 1; i < rows; i++){
            for(int j = 1; j < cols; j++){
                if(matrix[i][j] == 0) continue;

                matrix[i][j] = 1 + Math.min(
                    Math.min(matrix[i - 1][j], matrix[i][j - 1]),
                    matrix[i - 1][j - 1]
                );
                count += matrix[i][j]; // Add the count of squares ending at (i, j)
            }
        }

        return count; // Return the total count of square submatrices with all ones
    }
}
