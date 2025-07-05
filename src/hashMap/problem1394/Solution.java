package hashMap.problem1394;

// Problem 1394 - Find the Lucky Integer in an Array
// Link: https://leetcode.com/problems/find-lucky-integer-in-an-array/description/
// Level: Easy

import java.util.HashMap;

public class Solution {
    // #1. HashMap
    // Time Complexity: O(N) where N is the length of the array
    // Space Complexity: O(N) for the HashMap
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for(int num: arr){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int maxLucky = -1;
        for(int num: countMap.keySet()){
            if(num == countMap.get(num)){
                maxLucky = Math.max(maxLucky, countMap.get(num));
            }
        }
        return maxLucky;
    }
}
