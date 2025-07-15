package string.problem3136;

// Problem 3136 - Valid Word
// Link: https://leetcode.com/problems/valid-word/
// Level: Easy

public class Solution {
    // #1. Character Check
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public boolean isValid(String word) {
        int n = word.length();
        if(n < 3) return false;
        boolean hasVowel = false;
        boolean hasConsonant = false;
        for(int i = 0; i < n; i++){
            char c = word.charAt(i);
            if((c >= 48 && c <= 57)){
                continue;
            } else if((c >= 65 && c <= 92)){
                if((c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')) hasVowel = true;
                else hasConsonant = true;
            } else if((c >= 97 && c <= 122)){
                if((c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')) hasVowel = true;
                else hasConsonant = true;
            } else return false;
        }
        return hasVowel && hasConsonant;
    }
}
