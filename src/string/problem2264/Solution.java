package string.problem2264;

// // Problem 2264 - Largest 3-Same-Digit Number in String
// // Link: https://leetcode.com/problems/largest-3-same-digit-number-in-string
// // Level: Easy

public class Solution {
    // #1. Iterative Approach
    // Time Complexity: O(n), where n is the length of the input string.
    // Space Complexity: O(1), no extra space used.
    public String largestGoodInteger(String num) {
        int count = 0;
        char previousChar = 'X', maxChar = ' ';
        for(int i = 0; i < num.length(); i++){
            char currentChar = num.charAt(i);
            if(currentChar != previousChar){
                count = 1; // Reset count for a new character
            } else {
                count++; // Increment count for the same character
            }
            if(count == 3){
                if(currentChar > maxChar) {
                    maxChar = currentChar; // Update maxChar if current is greater
                }
            }
            previousChar = currentChar; // Update previousChar
        }
        if(maxChar == ' ') return ""; // If no 3-same-digit found, return empty string
        return String.valueOf(maxChar).repeat(3); // Return the largest 3-same-digit number
    }
}
