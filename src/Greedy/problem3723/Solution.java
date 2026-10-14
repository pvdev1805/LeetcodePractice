package Greedy.problem3723;

// Problem 3723 - Maximum Sum of Squares of Digits
// Link: https://leetcode.com/problems/maximum-sum-of-squares-of-digits/
// Level: Medium

public class Solution {
    // #1. Greedy Approach
    // Time Complexity: O(num) since we are iterating through the number of digits once
    // Space Complexity: O(num) since we are using a StringBuilder to store the result
    public String maxSumOfSquares(int num, int sum) {
        // Step 1: The biggest possible digit sum is 9 * num --> Ex: num = 4, then the biggest num is 9999, if sum > 9999 --> return ""
        if (sum > 9 * num) return "";

        StringBuilder sb = new StringBuilder();

        // Step 2: fill every position from left to right
        while (num-- > 0) {
            int digit = Math.min(9, sum); // take as much as we can, at most 9
            sb.append(digit);
            sum -= digit; // decrease the sum by the digit we just used
        }

        return sum == 0 ? sb.toString() : ""; // if sum is not 0, then we couldn't fill all positions correctly
    }

    // #2. Optimized Greedy Approach
    // Time Complexity: O(num) since we are iterating through the number of digits once
    // Space Complexity: O(num) since we are using a StringBuilder to store the result
    public String maxSumOfSquares2(int num, int sum) {
        // Step 1: The biggest possible digit sum is 9 * num --> Ex: num = 4, then the biggest num is 9999, if sum > 9999 --> return ""
        if (sum > 9 * num) return "";

        // Step 2: We can fill the number with as many 9's as possible, then fill the remainder with the next largest digit, and finally fill the rest with 0's
        StringBuilder sb = new StringBuilder();
        int q = sum / 9; // number of 9's we can use
        int r = sum % 9; // remainder after using 9's

        // Step 3: fill the positions with 9's as much as possible
        for (int i = 0; i < q; i++) {
            sb.append('9');
        }

        // Step 4: if there's a remainder, fill the next position with that digit
        if (r > 0) {
            sb.append((char) ('0' + r)); // append the remainder as a digit
        }

        // Step 5: fill the remaining positions with 0's
        int remainingZeros = num - q - (r > 0 ? 1 : 0); // remaining positions to fill with 0's
        for (int i = 0; i < remainingZeros; i++) {
            sb.append('0');
        }

        return sb.toString();
    }
}
