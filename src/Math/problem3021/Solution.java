package Math.problem3021;

// Problem 3021 - Alice and Bob Playing Flower Game
// Link: https://leetcode.com/problems/alice-and-bob-playing-flower-game/
// Level: Medium

public class Solution {
    // #1. Mathematical Approach
    // Time Complexity: O(1), constant time complexity as it involves simple arithmetic operations.
    // Space Complexity: O(1), no extra space used.
    public long flowerGame(int n, int m) {
        // The maximum number of flowers that can be picked is half of the total flowers
        // since Alice and Bob alternate turns and Alice starts first.
        // Thus, the result is (n * m) / 2.
        return (long)m*n/2;
    }
}
