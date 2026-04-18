package Math.problem3783;

// Problem 3783 - Mirror Distance of an Integer
// Link: https://leetcode.com/problems/mirror-distance-of-an-integer/
// Level: Easy

public class Solution {
    // #1. Iterative Approach
    // Time Complexity: O(M), where M is the number of digits in the input integer n, since we need to reverse the digits of n, which takes O(M) time.
    // Space Complexity: O(1), since we are using a constant amount of space to store the reversed number and the temporary variable for reversing, we are using O(1) space.
    public int mirrorDistance(int n) {
        int revNum = 0;
        if (n <= 9) revNum = n;
        else {
            int temp = n;
            while (temp > 0) {
                int digit = temp % 10;
                revNum = revNum * 10 + digit;
                temp /= 10;
            }
        }
        return Math.abs(n - revNum);
    }
}
