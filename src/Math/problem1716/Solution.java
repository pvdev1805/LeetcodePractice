package Math.problem1716;

// Problem 1716 - Calculate Money in Leetcode Bank
// https://leetcode.com/problems/calculate-money-in-leetcode-bank/
// Level: Easy

public class Solution {
    // #1. Math Simulation
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;

        int total = 0;

        // Calculate total for complete weeks
        for (int i = 0; i < weeks; i++) {
            total += 28 + i * 7; // 28 is the sum of first week (1+2+3+4+5+6+7)
        }

        // Calculate total for remaining days
        for (int j = 0; j < days; j++) {
            total += weeks + 1 + j; // weeks + 1 is the starting amount for the current week
        }

        return total;
    }

    // #2. Direct Formula
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public int totalMoney2(int n) {
        int weeks = n / 7;
        int days = n % 7;

        int total = 28 * weeks + 7 * weeks * (weeks - 1) / 2; // Total for complete weeks
        total += days * (weeks + 1) + days * (days - 1) / 2; // Total for remaining days

        return total;
    }
}
