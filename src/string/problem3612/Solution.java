package string.problem3612;

// Problem 3612 - Process String with Special Operations I
// Link: https://leetcode.com/problems/process-string-with-special-operations-i/
// Level: Medium

public class Solution {
    // #1. StringBuilder Approach
    // Time Complexity: O(N), where N is the length of the input string s, since we need to iterate through the string once to process each character, we are using O(N) time.
    // Space Complexity: O(N), since we are using a StringBuilder to store the intermediate result, in the worst case, we may need to store all characters of the input string, we are using O(N) space.
    public String processStr(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*' && !result.isEmpty()) {
                result.deleteCharAt(result.length() - 1);
            } else if (c == '#') {
                result.append(result);
            } else if (c == '%') {
                result.reverse();
            } else if (c >= 'a' && c <= 'z') {
                result.append(c);
            }
        }
        return result.toString();
    }
}
