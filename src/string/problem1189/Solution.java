package string.problem1189;

// Problem 1189 - Maximum Number of Ballon
// Link: https://leetcode.com/problems/maximum-number-of-balloons/
// Level: Easy

import java.util.Arrays;

public class Solution {
    // #1. Hash Table Approach
    // Time Complexity: O(n) where n is the length of `text`
    // Space Complexity: O(1) since the frequency array has a fixed size of 5
    public int maxNumberOfBalloons(String text) {
        String t = "balon"; // Simplify "balloon" to "balon" for unique characters
        int[] freq = new int[t.length()];
        for (char c : text.toCharArray()) {
            for (int i = 0; i < t.length(); i++) {
                if (c == t.charAt(i)) {
                    freq[i]++;
                }
            }
        }
        freq[2] >>= 1; // At 'll' --> 'l': freq[2] = freq[2] / 2;
        freq[3] >>= 1; // At 'oo' --> 'o': freq[3] = freq[3] / 2;

        return Arrays.stream(freq).min().getAsInt();
    }
}
