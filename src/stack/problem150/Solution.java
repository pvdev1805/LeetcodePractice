package stack.problem150;

// Problem 150 - Evaluate Reverse Polish Notation
// Link: https://leetcode.com/problems/evaluate-reverse-polish-notation/
// Level: Medium

import java.util.Stack;

public class Solution {
    // #1. Stack
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                int result = 0;
                if(token.equals("+")){
                    result = a + b;
                } else if(token.equals("-")){
                    result = a - b;
                } else if(token.equals("*")){
                    result = a * b;
                } else if(token.equals("/")){
                    result = a / b;
                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
