package array.problem66;

// Problem 66 - Plus One
// Link: https://leetcode.com/problems/plus-one/
// Level: Easy

public class Solution {
    // #1. Simple Simulation
    // Time Complexity: O(N)
    // Space Complexity: O(1) or O(N) in case of all 9s
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                // No carry-over, we can return the result immediately
                return digits;
            } else {
                // If the digit is 9, it becomes 0 and we carry over to the next digit
                digits[i] = 0;
            }
        }
        // Case: digits = [9,9,9] --> digits + 1 = [1,0,0,0]
        // If all digits were 9, we need an extra digit at the front
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1; // The rest are already 0 by default
        return newDigits;
    }
}
