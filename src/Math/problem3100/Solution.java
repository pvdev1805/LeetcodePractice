package Math.problem3100;

// Problem 3100 - Water Bottles II
// https://leetcode.com/problems/water-bottles-ii/
// Level: Medium

public class Solution {
    // #1. Simulation
    // Time Complexity: O(n) where n is the initial number of bottles.
    // Space Complexity: O(1) since we are using only a constant amount of extra
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int bottlesDrunk = numBottles;
        int emptyBottles = numBottles;
        int exchangedBottles = 0;
        while(emptyBottles + exchangedBottles >= numExchange){
            if(emptyBottles + exchangedBottles == numExchange && exchangedBottles != 0){
                bottlesDrunk += exchangedBottles;
                emptyBottles += exchangedBottles;
                exchangedBottles = 0;
            } else {
                emptyBottles -= numExchange;
                exchangedBottles++;
                numExchange++;
            }
        }
        if(exchangedBottles > 0) bottlesDrunk += exchangedBottles;
        return bottlesDrunk;
    }

    // #2. Simulation (Simplified)
    // Time Complexity: O(n) where n is the initial number of bottles.
    // Space Complexity: O(1) since we are using only a constant amount of extra space.
    public int maxBottlesDrunk2(int numBottles, int numExchange) {
        int bottlesDrunk = numBottles;
        int emptyBottles = numBottles;
        while(emptyBottles >= numExchange){
            emptyBottles -= numExchange;
            bottlesDrunk++;
            numExchange++;
            emptyBottles++;
        }
        return bottlesDrunk;
    }
}
