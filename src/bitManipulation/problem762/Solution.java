package bitManipulation.problem762;

// Problem 762 - Prime Number of Set Bits in Binary Representation
// Link: https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
// Level: Easy

public class Solution {
    // #1. Bit Manipulation Approach
    // Time Complexity: O(n * sqrt(m)), where n is the number of integers in the range [left, right] and m is the maximum number of set bits (which is at most 32 for integers). We iterate through each integer in the range and check if the count of set bits is prime, which takes O(sqrt(m)) time.
    // Space Complexity: O(1), no extra space used.
    public int countPrimeSetBits(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int setBitsCount = Integer.bitCount(i); // Count the number of set bits in the binary representation of i
            if (isPrime(setBitsCount)) {
                answer++; // Increment answer if the count of set bits is a prime number
            }
        }
        return answer; // Return the total count of numbers in the range [left, right] that have a prime number of set bits
    }

    // Helper method to check if a number is prime
    // Time Complexity: O(sqrt(n)), where n is the input number, since we check for divisibility up to the square root of n.
    // Space Complexity: O(1), no extra space used.
    private boolean isPrime(int n) {
        if (n < 2) return false; // 0 and 1 are not prime numbers
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false; // If n is divisible by any number from 2 to sqrt(n), it is not prime
        }
        return true; // If n is not divisible by any number from 2 to sqrt(n), it is prime
    }
}
