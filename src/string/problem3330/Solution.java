package string.problem3330;

// Problem 3330 - Find the Original Typed String I
// Link: https://leetcode.com/problems/find-the-original-typed-string-i/description/
// Level: Easy

public class Solution {
    // #1.
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int possibleStringCount(String word) {
        int ans = 1;
        for(int i = 1; i < word.length(); i++){
            if(word.charAt(i) == word.charAt(i-1)) ans++;
        }
        return ans;
    }
}
