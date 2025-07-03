package string.problem3304;

// Problem 3304 - Find the K-th Character in String Game I
// Link: https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/description/
// Level: Easy

public class Solution {

    // #1. Simulation
    // Time Complexity: O(1+2+4+8+...+2^x) --> O(1)
    // Space Complexity: O(1)
    public char kthCharacter(int k) {
        String word = "a";
        while(word.length() < k){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(c == 'z'){
                    sb.append('a');
                } else {
                    sb.append((char)(c + 1));
                }
            }
            word += sb.toString();
        }
        return word.charAt(k - 1);
    }
}
