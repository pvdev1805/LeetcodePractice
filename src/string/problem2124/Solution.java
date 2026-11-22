package string.problem2124;

// Problem 2124 - Check if All A's Appears Before All B's
// Link: https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/
// Level: Easy

import java.util.stream.Collectors;

public class Solution {
    // #1. Sorting Approach
    // Time Complexity: O(N * logN) since we are sorting the string
    // Space Complexity: O(N) since we are creating a new string to store the sorted characters
    public boolean checkString(String s) {
        String sorted = s.chars().sorted().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
        return s.equals(sorted);
    }

    // #2. Iterative Approach
    // Time Complexity: O(N) since we are iterating through the string once
    // Space Complexity: O(1) since we are using a constant amount of extra space
    public boolean checkString2(String s) {
        int n = s.length();
        int lastAIndex = -1;
        int firstBIndex = n;

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'a'){
                lastAIndex = i;
            } else if(s.charAt(i) == 'b' && firstBIndex == n){
                firstBIndex = i;
            }
        }

        return lastAIndex < firstBIndex;
    }

    // #3. Iterative Approach
    // Time Complexity: O(N) since we are iterating through the string once
    // Space Complexity: O(1) since we are using a constant amount of extra space
    public boolean checkString3(String s) {
        int n = s.length();
        for(int i = 0; i < n - 1; i++){
            if(s.charAt(i) == 'b' && s.charAt(i + 1) == 'a'){
                return false;
            }
        }

        return true;
    }
}
