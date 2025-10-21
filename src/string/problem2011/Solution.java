package string.problem2011;

// Problem 2011 - Final Value of Variable After Performing Operations
// https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
// Level: Easy

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // #1. Simulation
    // Time Complexity: O(n) where n is the number of operations
    // Space Complexity: O(1)
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(String operation : operations){
            if(operation.charAt(1) == '+'){
                x++;
            } else {
                x--;
            }
        }
        return x;
    }

    // #2. HashMap
    // Time Complexity: O(n) where n is the number of operations
    // Space Complexity: O(1)
    public int finalValueAfterOperations2(String[] operations) {
        int x = 0;
        Map<String, Integer> mp = new HashMap<>();
        for(String operation : operations){
            mp.put(operation, mp.getOrDefault(operation, 0) + 1);
        }
        x += mp.getOrDefault("++X", 0);
        x += mp.getOrDefault("X++", 0);
        x -= mp.getOrDefault("--X", 0);
        x -= mp.getOrDefault("X--", 0);
        return x;
    }
}
