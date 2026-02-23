package rollingHash.problem1461;

// Problem 1461 - Check If a String Contains All Binary Codes of Size K
// Link: https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
// Level: Medium

import java.util.*;

public class Solution {
    // #1. HashSet Approach
    // Time Complexity: O(n * k), where n is the length of the input string and k is the size of the binary codes. We iterate through the string to extract all substrings of length k, which takes O(n * k) time.
    // Space Complexity: O(2^k * k), since we can have at most 2^k unique binary codes of length k, and each code takes O(k) space to store in the HashSet.
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        Set<String> seen = new HashSet<>();
        for (int i = 0; i <= n - k; i++) {
            String substring = s.substring(i, i + k); // Get the substring of length k starting at index i
            seen.add(substring); // Add the substring to the set of seen substrings
        }
        return seen.size() == (1 << k); // Check if the number of unique substrings of length k is equal to 2^k, which is the total number of possible binary
    }

    // #2. Rolling Hash Approach
    // Time Complexity: O(n), where n is the length of the input string. We iterate through the string once to build the rolling hash and check for unique codes, which takes O(n) time.
    // Space Complexity: O(2^k), since we can have at most 2^k unique binary codes of length k, and we use a list to track which codes have been seen.
    public boolean hasAllCodes2(String s, int k) {
        int n = s.length();
        int totalCodes = 1 << k; // Total number of possible binary codes of length k (2^k)
        if (n - k + 1 < totalCodes)
            return false; // If the number of substrings of length k is less than the total number of codes, return false

        List<Boolean> seen = new ArrayList<>(Collections.nCopies(totalCodes, false)); // Create a list to track which codes have been seen
        int currentHash = 0;
        int allOnesMask = totalCodes - 1; // Mask to keep only the last k bits
        int count = 0; // Count of unique codes seen

        // Build the initial hash for the first k characters
        for (int i = 0; i < k; i++) {
            currentHash = (currentHash << 1) | (s.charAt(i) - '0'); // Build the initial hash for the first k characters
        }
        seen.set(currentHash, true); // Mark the initial hash as seen
        count++;

        // Iterate through the string starting from the k-th character to update the hash and check for new codes
        for (int i = k; i < n; i++) {
            currentHash = ((currentHash << 1) | (s.charAt(i) - '0')) & allOnesMask; // Update the hash by shifting left and adding the new bit, then apply the mask to keep only the last k bits
            if (!seen.get(currentHash)) { // If this code has not been seen before
                seen.set(currentHash, true); // Mark it as seen
                count++; // Increment the count of unique codes seen
                if (count == totalCodes) {
                    return true; // If we have seen all possible codes, return true
                }
            }
        }

        return count == totalCodes; // Return true if we have seen all possible codes, otherwise return false
    }
}
