package matrix.problem48;

// Problem 48 - Rotate Image
// Link: https://leetcode.com/problems/rotate-image/
// Level: Medium

public class Solution {
    // #1. In-place Rotation Approach
    // Time Complexity: O(N^2), where N is the length of the input matrix, since we need to iterate through the matrix once to perform the rotation, we are using O(N^2) time.
    // Space Complexity: O(1), since we are performing the rotation in-place and not using any additional data structures, we are using O(1) space.
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        int mid = n / 2;

        for (int i = 0; i <= mid; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                // Save Top-Left Element
                int temp = matrix[i][j];

                // Move Bottom-Left to Top-Left
                matrix[i][j] = matrix[n - 1 - j][i];

                // Move Bottom-Right to Bottom-Left
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];

                // Move Top-Right to Bottom-Right
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];

                // Move Top-Left (temp) to Top-Right
                matrix[j][n - 1 - i] = temp;
            }
        }
    }
}
