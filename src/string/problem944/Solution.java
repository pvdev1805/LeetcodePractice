package string.problem944;

// Problem 944 - Delete Columns to Make Sorted
// Link: https://leetcode.com/problems/delete-columns-to-make-sorted/
// Level: Easy

public class Solution {
    // #1. Greedy
    // Time Complexity: O(N * M) where N is the number of strings and M is the length of each string
    // Space Complexity: O(1)
    public int minDeletionSize(String[] strs) {
        int n = strs.length; // Number of rows
        int m = strs[0].length(); // Number of columns
        int deleteCount = 0;
        for(int col = 0; col < m; col++){
            for(int row = 1; row < n; row++){
                if(strs[row].charAt(col) < strs[row - 1].charAt(col)){
                    deleteCount++;
                    break;
                }
            }
        }
        return deleteCount;
    }
}
