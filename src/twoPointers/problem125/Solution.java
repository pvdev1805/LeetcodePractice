package twoPointers.problem125;

// Problem 125 - Valid Palindrome
// Link: https://leetcode.com/problems/valid-palindrome/
// Level: Easy

public class Solution {
    // #1. Two-Pointer Approach
    // Time Complexity: O(n), where n is the length of the input string.
    // Space Complexity: O(1), no extra space used.
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left < right){
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) ++left;
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) --right;
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            ++left;
            --right;
        }
        return true;
    }
}
