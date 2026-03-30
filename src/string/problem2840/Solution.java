package string.problem2840;

// Problem 2840 - Check If Strings Can be Made Equal With Operations II
// Link: https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-ii/
// Level: Medium

public class Solution {
    // #1. Character Count Approach
    // Time Complexity: O(N), where N is the length of the input strings s1 and s2, since we need to iterate through both strings once to count the characters at even and odd indices.
    // Space Complexity: O(1), since we are using only a fixed amount of extra space to store the counts of characters at even and odd indices, we are not using any additional space that grows with the input size.
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
        int[] evenCount = new int[26]; // Count of characters at even indices
        int[] oddCount = new int[26]; // Count of characters at odd indices

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                evenCount[s1.charAt(i) - 'a']++; // Increment count for character at even index in s1
                evenCount[s2.charAt(i) - 'a']--; // Decrement count for character at even index in s2
            } else {
                oddCount[s1.charAt(i) - 'a']++; // Increment count for character at odd index in s1
                oddCount[s2.charAt(i) - 'a']--; // Decrement count for character at odd index in s2
            }
        }
        for (int i = 0; i < 26; i++) {
            if (evenCount[i] != 0 || oddCount[i] != 0) {
                return false; // If there is any mismatch in character counts at even or odd indices, return false
            }
        }
        return true; // If all character counts match, return true
    }
}
