package slidingWindow.problem3090;

// Problem 3090 -Maximum Length Substring With Two Occurrences
// Link: https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/
// Level: Easy

public class Solution {
    // #1. Sliding Window Approach
    // Time Complexity: O(n) where n is the length of `s`
    // Space Complexity: O(1) since the frequency array has a fixed size of 26
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int[] freq = new int[26];
        int res = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            freq[s.charAt(right) - 'a']++;

            while (freq[s.charAt(right) - 'a'] > 2) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
