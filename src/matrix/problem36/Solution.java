package matrix.problem36;

// Problem 36 - Valid Sudoku
// Link: https://leetcode.com/problems/valid-sudoku/
// Level: Medium

import java.util.HashSet;

public class Solution {
    // #1. HashSet Approach
    // Time Complexity: O(1), since the board size is fixed (9x9).
    // Space Complexity: O(1), since the maximum space used is constant (for 9 rows, 9 columns, and 9 boxes).
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;

                int boxIdx = (i / 3) * 3 + (j / 3);

                if (rows[i].contains(c) || cols[j].contains(c) || boxes[boxIdx].contains(c)) {
                    return false;
                }

                rows[i].add(c);
                cols[j].add(c);
                boxes[boxIdx].add(c);
            }
        }

        return true;
    }
}
