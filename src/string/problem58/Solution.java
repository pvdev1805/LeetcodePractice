package string.problem58;

// Problem 58 - Length of Last Word
// Link: https://leetcode.com/problems/length-of-last-word/
// Level: Easy

import java.util.Stack;

public class Solution {
    // #1. Iterative Approach
    // Time Complexity: O(n), where n is the length of the input string.
    // Space Complexity: O(1), no extra space used.
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int ans = 0;
        boolean foundLastWord = false;
        for(int i = n - 1; i >= 0; i--){
            if(s.charAt(i) == ' '){
                if(foundLastWord) return ans;
                continue;
            }
            foundLastWord = true;
            ans++;
        }
        return ans;
    }

    // #2. String Split Approach
    // Time Complexity: O(n), where n is the length of the input string.
    // Space Complexity: O(n), for storing the split words.
    public int lengthOfLastWord2(String s) {
        String[] words = s.split(" ");
        if(words.length == 0) return 0;
        return words[words.length - 1].length();
    }

    // #3. String Trim and Split Approach
    // Time Complexity: O(n), where n is the length of the input string.
    // Space Complexity: O(n), for storing the split words.
    public int lengthOfLastWord3(String s) {
        String[] words = s.trim().split(" ");
        if(words.length == 0) return 0;
        return words[words.length - 1].length();
    }

    // #4. Stack Approach
    // Time Complexity: O(n), where n is the length of the input string.
    // Space Complexity: O(n), for storing the words in the stack.
    public int lengthOfLastWord4(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' '){
                if(sb.length() > 0){
                    st.push(sb.toString());
                    sb.setLength(0); // Clear the StringBuilder
                }
            } else {
                sb.append(c);
            }
        }
        if(sb.length() > 0) return sb.length();
        return st.isEmpty() ? 0 : st.peek().length();
    }
}
