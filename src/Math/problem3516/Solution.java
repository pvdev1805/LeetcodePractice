package Math.problem3516;

// Problem 3516 - Find Closest Person
// Link: https://leetcode.com/problems/find-closest-person/
// Level: Easy

public class Solution {
    // #1. Direct Comparison Approach
    // Time Complexity: O(1), constant time operations.
    // Space Complexity: O(1), no extra space used.
    public int findClosest(int x, int y, int z) {
        int distX = Math.abs(z - x);
        int distY = Math.abs(z - y);
        if(distX > distY) return 2;
        if(distX < distY) return 1;
        return 0;
    }
}
