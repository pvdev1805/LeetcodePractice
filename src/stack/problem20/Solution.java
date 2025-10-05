package stack.problem20;

// Problem 20 - Valid Parentheses
// https://leetcode.com/problems/valid-parentheses/
// Level: Easy

import java.util.Stack;

public class Solution {
    // #1. Stack
    // Time Complexity: O(n) where n is the length of the input string.
    // Space Complexity: O(n) in the worst case when all characters are opening brackets.
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
