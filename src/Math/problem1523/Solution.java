package Math.problem1523;

// Problem 1523 - Count Odd Numbers in an Interval Range
// Link: https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
// Level: Easy

public class Solution {
    // #1. Mathematical Calculation
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public int countOdds(int low, int high) {
        if(low % 2 == 0 && high % 2 == 0){
            return (high - low) / 2;
        }
        return (high - low) / 2 + 1;
    }
}
