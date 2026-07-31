package Greedy.problem3016;

// Problem 3016 - Minimum Number of Pushes to Type Word II
// Link: https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/
// Level: Medium

import java.util.Arrays;

public class Solution {
    // #1. Greedy Approach
    // Time Complexity: O(n log n) where n is the length of `word`
    // Space Complexity: O(1) since we are using a fixed-size frequency array
    public int minimumPushes(String word) {
        int n = word.length();
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        int ans = 0;
        Arrays.sort(freq);
        for (int i = 25; i >= 0; i--) {
            ans += ((25 - i) / 8 + 1) * freq[i];
        }
        return ans;
    }
}
