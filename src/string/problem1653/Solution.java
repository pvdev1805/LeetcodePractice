package string.problem1653;

// Problem 1653 - Minimum Deletions to Make String Balanced
// Link: https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/
// Level: Medium

public class Solution {
    // #1. State Transition - Single Pass
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int minimumDeletions(String s) {
        int res = 0, count = 0;
        for(char c: s.toCharArray()){
            if(c == 'b'){
                count++;
            } else if(c == 'a'){
                // If there are some 'b'
                if(count != 0){
                    res++;
                    count--;
                }
            }
        }
        return res;
    }
}
