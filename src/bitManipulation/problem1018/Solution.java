package bitManipulation.problem1018;

// Problem 1018 - Binary Prefix Divisible By 5
// Link: https://leetcode.com/problems/binary-prefix-divisible-by-5/
// Level: Easy

import java.util.LinkedList;
import java.util.List;

public class Solution {
    // #1. Bit Manipulation
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> answer = new LinkedList<>();
        int currentValue = 0;
        for(int num : nums){
            // currentValue = ((currentValue << 1) + num) % 5;
            currentValue = (currentValue * 2 + num) % 5;
            answer.add(currentValue == 0);
        }
        return answer;
    }
}
