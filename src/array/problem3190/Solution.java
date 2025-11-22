package array.problem3190;

// Problem 3190 - Find Minimum Operations To Make All Elements Divisible by Three
// Link: https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/
// Level: Easy

public class Solution {
    // #1. Count Non-Divisible Elements
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int minimumOperations(int[] nums) {
        int answer = 0;
        for(int num : nums){
            if(num % 3 != 0) answer++;
        }
        return answer;
    }
}
