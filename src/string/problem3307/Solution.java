package string.problem3307;

// Problem 3307 - Find the K-th Character in String Game II
// Link: https://leetcode.com/problems/find-the-k-th-character-in-string-game-ii/
// Level: Hard

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // #1.
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public char kthCharacter(long k, int[] operations) {
        int shift = 0;
        List<Long> lengths = new ArrayList<>();
        long len = 1;

        for (int op : operations) {
            len *= 2;
            lengths.add(len);
            if (len >= k) break;
        }

        for (int i = lengths.size() - 1; i >= 0; i--) {
            long half = lengths.get(i) / 2;
            int op = operations[i];

            if (k > half) {
                k -= half;
                if (op == 1) shift++;
            }
            // else: k remains the same
        }

        return (char) (shift % 26 + 'a');
    }
}
