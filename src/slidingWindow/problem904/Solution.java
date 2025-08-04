package slidingWindow.problem904;

// Problem 904 - Fruit Into Baskets
// Link: https://leetcode.com/problems/fruit-into-baskets/
// Level: Medium

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // #1. Sliding Window Approach
    // Time Complexity: O(n), where n is the length of the input array.
    // Space Complexity: O(1), since we are only storing at most 2 types
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int start = 0, end = 0;
        int maxFruits = 0;
        Map<Integer, Integer> fruitCount = new HashMap<>();

        while(end < n){
            fruitCount.put(fruits[end], fruitCount.getOrDefault(fruits[end], 0) + 1);
            while(fruitCount.size() > 2){
                fruitCount.put(fruits[start], fruitCount.get(fruits[start]) - 1);
                if(fruitCount.get(fruits[start]) == 0){
                    fruitCount.remove(fruits[start]);
                }
                start++;
            }
            maxFruits = Math.max(maxFruits, end - start + 1);
            end++;
        }

        return maxFruits;
    }
}
