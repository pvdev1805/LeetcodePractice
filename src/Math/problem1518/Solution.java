package Math.problem1518;

// Problem 1518 - Water Bottles
// https://leetcode.com/problems/water-bottles/
// Level: Easy

public class Solution {
    // #1. Simulation
    // Time Complexity: O(log n) where n is the initial number of bottles.
    // Space Complexity: O(1) since we are using only a constant amount of extra space.
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;
        int emptyBottles = numBottles;
        while(emptyBottles >= numExchange){
            int exchangedBottles = emptyBottles / numExchange;
            result += exchangedBottles;
            emptyBottles %= numExchange;
            emptyBottles += exchangedBottles;
        }
        return result;
    }
}
