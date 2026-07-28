package string.problem3517;

// Problem 3517 - Smallest Palindromic Rearrangement I
// Link: https://leetcode.com/problems/smallest-palindromic-rearrangement-i/
// Level: Medium

public class Solution {
    // #1. Simple Approach
    // Time Complexity: O(n) where n is the length of `s`
    // Space Complexity: O(n) where n is the length of `s` for the frequency array and the StringBuilder
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        StringBuilder half = new StringBuilder();
        char mid = '\0';
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            half.append(String.valueOf(c).repeat(freq[i] / 2));
            if (freq[i] % 2 == 1) {
                mid = c;
            }
        }
        if (mid == '\0') {
            return half.toString() + half.reverse().toString();
        }
        return half.toString() + mid + half.reverse().toString();
    }

    // #2. Two Pointers
    // Time Complexity: O(n) where n is the length of `s`
    // Space Complexity: O(n) where n is the length of `s` for the frequency array and the character array
    public String smallestPalindrome2(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char[] arr = new char[n];
        int left = 0, right = n - 1;
        for (int i = 0; i < 26; i++) {
            while (freq[i] >= 2) {
                arr[left] = (char) ('a' + i);
                arr[right] = (char) ('a' + i);
                left++;
                right--;
                freq[i] -= 2;
            }
            if (freq[i] == 1) {
                arr[n / 2] = (char) ('a' + i);
            }
        }
        return new String(arr);
    }
}
