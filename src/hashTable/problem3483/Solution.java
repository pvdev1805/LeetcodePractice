package hashTable.problem3483;

// Problem 3483 - Unique 3-Digit Even Numbers
// Link: https://leetcode.com/problems/unique-3-digit-even-numbers/
// Level: Easy

import java.util.HashSet;
import java.util.Set;

public class Solution {

    // #1. Brute Force Approach
    // Time Complexity: O(n^3) where n is the length of the digits array
    // Space Complexity: O(n) where n is the number of unique 3-digit even numbers
    public int totalNumbers(int[] digits) {
        Set<Integer> seen = new HashSet<>();
        int n = digits.length;

        for (int h = 0; h < n; h++) {
            if (digits[h] == 0) continue;
            for (int t = 0; t < n; t++) {
                if (t == h) continue;

                for (int u = 0; u < n; u++) {
                    if (u == h || u == t) continue;

                    if (digits[u] % 2 != 0) continue;

                    int num = digits[h] * 100 + digits[t] * 10 + digits[u];
                    seen.add(num);
                }
            }
        }

        return seen.size();
    }

    // #2. Optimized Approach using Frequency Array
    // Time Complexity: O(max(n, 9*10*5)) where n is the length of the digits array and 9*10*5 is the maximum number of iterations for the three nested loops (9 for hundreds, 10 for tens, and 5 for even units)
    // Space Complexity: O(1) since we are using a fixed size frequency array
    public int totalNumbers2(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) {
            freq[d]++;
        }

        int count = 0;

        for (int h = 1; h <= 9; h++) {
            if (freq[h] == 0) continue;
            freq[h]--;

            for (int t = 0; t <= 9; t++) {
                if (freq[t] == 0) continue;
                freq[t]--;

                for (int u = 0; u <= 8; u += 2) {
                    if (freq[u] > 0) count++;
                }

                freq[t]++;
            }

            freq[h]++;
        }
        return count;
    }
}
