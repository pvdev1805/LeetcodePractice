package string.problem3227;

// Problem 3227 - Vowels Game in a String
// Link: https://leetcode.com/problems/vowels-game-in-a-string/
// Level: Medium

public class Solution {
    // #1. String Traversal Approach
    // Time Complexity: O(n), where n is the length of the string.
    // Space Complexity: O(1), no extra space used.
    public boolean doesAliceWin(String s) {
        String vowels = "aeiou";
        for(char c : s.toCharArray()){
            if(vowels.indexOf(c) != -1) return true;
        }
        return false;
    }
}
