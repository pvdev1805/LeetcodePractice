package matrix.problem1582;

// Problem 1582 - Special Positions in a Binary Matrix
// Link: https://leetcode.com/problems/special-positions-in-a-binary-matrix/
// Level: Easy

public class Solution {
    // #1. Counting Approach
    // Time Complexity: O(m*n), where m is the number of rows and n is the number of columns in the matrix, since we need to iterate through the entire matrix to count the number of 1s in each row and column, and then iterate again to count the special positions.
    // Space Complexity: O(m + n), where m is the number of rows and n is the number of columns in the matrix, since we need to store the count of 1s for each row and column in separate arrays.
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        int specialCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1) {
                    specialCount++;
                }
            }
        }
        return specialCount;
    }
}
