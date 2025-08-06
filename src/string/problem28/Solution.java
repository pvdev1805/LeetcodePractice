package string.problem28;

// Problem 28 - Find the Index of the First Occurrence in a String
// Link: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string
// Level: Easy

public class Solution {
    // #1. Naive Approach - Brute Force
    // Time Complexity: O(n * m), where n is the length of haystack and m is the length of needle.
    // Space Complexity: O(1), no extra space used
    public int strStr(String haystack, String needle){
        int n = haystack.length();
        int m = needle.length();

        for(int i = 0; i <= n - m; i++){
            int count = 0;
            for(int j = 0; j < m; j++){
                if(haystack.charAt(i + j) != needle.charAt(j)){
                    break;
                }
                count++;
            }
            if(count == m){
                return i; // Found the first occurrence
            }
        }

        return -1; // Needle not found in haystack
    }

    // #2. Using String Methods - substring and equals
    // Time Complexity: O(n * m), where n is the length of haystack and m is the length of needle.
    // Space Complexity: O(1), no extra space used
    // Note: This approach is still O(n * m) in the worst case, but
    // it is more readable and uses built-in string methods.
    public int strStr2(String haystack, String needle){
        int n = haystack.length();
        int m = needle.length();
        for(int i = 0; i <= n - m; i++){
            if(haystack.substring(i, i + m).equals(needle)){
                return i; // Found the first occurrence
            }
        }
        return -1; // Needle not found in haystack
    }

    // #3. Optimized Two-Pointer Approach
    // Time Complexity: O(n + m), where n is the length of haystack and m is the length of needle.
    // Space Complexity: O(1), no extra space used
    public int strStr3(String haystack, String needle){
        int n = haystack.length();
        int m = needle.length();

        if(m > n) return -1; // If needle is longer than haystack, return -1

        int i = 0, j = 0;
        while(i < n){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;

                if(j == m) return i - j; // Found the first occurrence
            } else {
                i = i - j + 1; // Reset i to the next character after the last match
                j = 0; // Reset j to the start of needle
            }
        }
        return -1; // Needle not found in haystack
    }

    // #4. KMP Algorithm (Knuth-Morris-Pratt)
    // Time Complexity: O(n + m), where n is the length of haystack and m is the length of needle.
    // Space Complexity: O(m), for the prefix table
    public void computeLPSArray(String needle, int m, int[] lps) {
        int len = 0; // Length of the previous longest prefix suffix
        lps[0] = 0; // lps[0] is always 0
        int i = 1;

        while(i < m){
            if(needle.charAt(i) == needle.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            } else {
                if(len != 0){
                    len = lps[len - 1]; // Use the previous prefix suffix length
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    public int strStr4(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if(m == 0) return 0; // If needle is empty, return 0
        if(n < m) return -1; // If haystack is shorter than needle, return -1

        // Build the prefix table
        int[] lps = new int[m];
        computeLPSArray(needle, m, lps);

        int i = 0; // index for haystack
        int j = 0; // index for needle

        while(i < n){
            if(needle.charAt(j) == haystack.charAt(i)){
                i++;
                j++;
            }
            if(j == m) return i - j; // Found the first occurrence
            else if(i < n && needle.charAt(j) != haystack.charAt(i)){
                if(j != 0) j = lps[j - 1]; // Use the prefix table to skip characters
                else i++;
            }
        }
        return -1; // Needle not found in haystack
    }

}
