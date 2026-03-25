package array.problem3546;

// Problem 3546 - Equal Sum Grid Partition I
// Link: https://leetcode.com/problems/equal-sum-grid-partition-i/
// Level: Medium

public class Solution {
    // #1. Prefix Sum Approach
    // Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the grid, since we need to calculate the total sum and the row and column sums, and then check for possible cuts.
    // Space Complexity: O(m + n), since we are using two additional arrays to store the sums of each row and each column.
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Calculate the total sum of the grid
        long totalSum = 0;
        long[] rowSums = new long[m];
        long[] colSums = new long[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                totalSum += grid[i][j];
                rowSums[i] += grid[i][j];
                colSums[j] += grid[i][j];
            }
        }
        if (totalSum % 2 != 0) return false; // If the total sum is odd, we cannot partition it into two equal sums
        long halfSum = totalSum / 2;


        // Check horizontal cut
        long rowSum = 0;
        for (int i = 0; i < m - 1; i++) {
            rowSum += rowSums[i];
            if (rowSum == halfSum)
                return true; // If we find a horizontal cut that gives us half of the total sum, we can partition the grid
        }

        // Check vertical cut
        long colSum = 0;
        for (int j = 0; j < n - 1; j++) {
            colSum += colSums[j];
            if (colSum == halfSum)
                return true; // If we find a vertical cut that gives us half of the total sum, we can partition the grid
        }

        return false; // If we cannot find any horizontal or vertical cut that gives us half of the total sum, we cannot partition the grid
    }
}
