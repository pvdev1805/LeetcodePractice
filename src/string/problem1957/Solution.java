package string.problem1957;

// Problem 1957 - Delete Characters to Make Fancy String
// Link: https://leetcode.com/problems/delete-characters-to-make-fancy-string/
// Level: Easy

public class Solution {
    // #1. StringBuilder Approach
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public String makeFancyString(String s) {
        int n = s.length();
        if(n < 3) return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(s.charAt(1));

        for(int i = 2; i < n; i++){
            if(s.charAt(i) == s.charAt(i-1) && s.charAt(i) == s.charAt(i-2)){
                continue;
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
