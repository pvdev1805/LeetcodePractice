package array.problem1267;

// Problem 1267 - Count Servers that Communicate
// Link: https://leetcode.com/problems/count-servers-that-communicate/
// Level: Medium

public class Solution {
    // #1. Counting Approach
    // Time Complexity: O(m * n) since we are iterating through the grid twice
    // Space Complexity: O(m + n) for storing the row and column counts
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        // Count the number of servers in each row and column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // If a server is in a row or column with more than one server, it can communicate
                    if (rowCount[i] > 1 || colCount[j] > 1) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
