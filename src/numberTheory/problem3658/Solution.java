package numberTheory.problem3658;

// Problem 3658 - GCD of Odd and Even Sums
// Link: https://leetcode.com/problems/gcd-of-odd-and-even-sums/
// Level: Easy

public class Solution {
    // Helper function to find GCD of two numbers using Euclidean algorithm
    // Time Complexity: O(log(min(a, b))) where a and b are the two numbers
    // Space Complexity: O(1) since we are using a constant amount of space
    int findGCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    // #1. Simple Approach
    // Time complexity: O(n) where n is the input number
    // Space complexity: O(1) since we are using a constant amount of space
    public int gcdOfOddEvenSums(int n) {
        int oddSum = 0;
        int evenSum = 0;

        for (int i = 1; i <= n; i++) {
            oddSum += 2 * i - 1;
            evenSum += 2 * i;
        }

        return findGCD(oddSum, evenSum);
    }

    // #2. Optimized Approach
    // Time complexity: O(log(min(oddSum, evenSum))) for finding GCD
    // Space complexity: O(1) since we are using a constant amount of space
    public int gcdOfOddEvenSums2(int n) {
        int oddSum = n * n; // Sum of first n odd numbers is n^2
        int evenSum = n * (n + 1); // Sum of first n even numbers is n * (n + 1)
        return findGCD(oddSum, evenSum);
    }
}
