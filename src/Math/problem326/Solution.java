package Math.problem326;

// Problem 326 - Power of Three
// Link: https://leetcode.com/problems/power-of-three/
// Level: Easy

public class Solution {
    // #1. Iterative Approach
    // Time Complexity: O(log n), where n is the input number.
    // Space Complexity: O(1), no extra space used.
    public boolean isPowerOfThree(int n) {
        if(n < 1) return false;
        while(n % 3 == 0){
            n /= 3;
        }
        return n == 1;
    }

    // #2. Recursive Approach
    // Time Complexity: O(log n), where n is the input number.
    // Space Complexity: O(log n), due to recursive stack space.
    public boolean isPowerOfThree2(int n) {
        if(n < 1) return false;
        if(n == 1) return true;
        if(n % 3 != 0) return false;
        return isPowerOfThree2(n / 3);
    }
}
