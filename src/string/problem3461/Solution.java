package string.problem3461;

// Problem 3461 - Check If Digits Are Equal In String After Operations I
// https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/
// Level: Easy

public class Solution {
    // #1. Simulation
    // Time Complexity: O(n^2) where n is the length of the string s
    // Space Complexity: O(n) where n is the length of the string s
    public boolean hasSameDigits(String s) {
        int index = 0;
        String result = "";
        while(s.length() > 2 && index < s.length() - 1){
            char digit = (char)((s.charAt(index) - '0' + s.charAt(index + 1) - '0') % 10 + '0');
            result += digit;
            index++;
            if(index == s.length() - 1){
                s = result;
                index = 0;
                result = "";
            }
        }
        return s.length() == 2 && s.charAt(0) == s.charAt(1);
    }

    // #2. In-place Simulation
    // Time Complexity: O(n^2) where n is the length of the string s
    // Space Complexity: O(n) where n is the length of the string s
    public boolean hasSameDigits2(String s) {
        char[] a = s.toCharArray();
        for(int i = a.length - 1; i >= 2; i--){
            for(int j = 0; j < i; j++){
                char digit = (char)((a[j] - '0' + a[j+1] - '0') % 10 + '0');
                a[j] = digit;
            }
        }
        return a[0] == a[1];
    }
}
