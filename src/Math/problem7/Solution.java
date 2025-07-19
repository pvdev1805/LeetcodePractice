package Math.problem7;

// Problem 7 - Reverse Integer
// Link: https://leetcode.com/problems/reverse-integer/
// Level: Medium

public class Solution {
    // #1. Reverse Integer
    // Time Complexity: O(log10(N))
    // Space Complexity: O(1)
    public int reverse(int x){
        int reversedNum = 0;
        while(x != 0){
            if(reversedNum > Integer.MAX_VALUE / 10 || reversedNum < Integer.MIN_VALUE / 10){
                return 0;
            }
            int digit = x % 10;
            reversedNum = reversedNum * 10 + digit;
            x /= 10;
        }
        return reversedNum;
    }
}
