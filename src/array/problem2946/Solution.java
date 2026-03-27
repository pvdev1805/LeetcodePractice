package array.problem2946;

// Problem 2946 - Matrix Similarity After Cyclic Shift
// Link: https://leetcode.com/problems/matrix-similarity-after-cyclic-shift/
// Level: Easy

public class Solution {
    // #1. Cyclic Shift Comparison Approach
    // Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the matrix, since we need to compare each element of the matrix after the cyclic shift.
    // Space Complexity: O(1), since we are not using any additional space that grows with the input size, we are only using a constant amount of space for variables.
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        if (k % n == 0) return true; // If k is a multiple of n, the matrix will be the same after the cyclic shift

        k %= n; // Reduce k to the effective shift within the bounds of the number of columns

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    if (mat[i][(j - k + n) % n] != mat[i][j])
                        return false; // For even indexed rows, check if the element after shifting left by k matches the original element
                } else {
                    if (mat[i][(j + k) % n] != mat[i][j])
                        return false; // For odd indexed rows, check if the element after shifting right by k matches the original element
                }
            }
        }
        return true; // If all elements match after the cyclic shift, the matrices are similar
    }
}
