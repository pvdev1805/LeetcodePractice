package Math.problem3536;

// Problem 3536 - Maximum Product of Two Digits
// Link: https://leetcode.com/problems/maximum-product-of-two-digits/
// Level: Easy

public class Solution {
    // #1. Simple Approach
    // Time Complexity: O(log(n)) where n is the input number
    // Space Complexity: O(1) since we are using a constant amount of space
    public int maxProduct(int n) {
        int maxDigit = 0, secondMaxDigit = 0;

        while (n > 0) {
            int digit = n % 10;

            if (digit > maxDigit) {
                secondMaxDigit = maxDigit;
                maxDigit = digit;
            } else if (digit > secondMaxDigit) {
                secondMaxDigit = digit;
            }

            n /= 10;
        }

        return maxDigit * secondMaxDigit;
    }
}
