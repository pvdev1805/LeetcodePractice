package twoPointers.problem2211;

// Problem 2211 - Count Collisions on a Road
// Link: https://leetcode.com/problems/count-collisions-on-a-road/
// Level: Medium

public class Solution {
    // #1. Two Pointers
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int countCollisions(String directions) {
        int n = directions.length();
        if(n == 1) return 0; // No collisions possible with a single car
        int left = 0, right = n - 1;
        // Move left pointer to the right while there are 'L's
        while(left < right && directions.charAt(left) == 'L'){
            left++;
        }
        // Move right pointer to the left while there are 'R's
        while(left < right && directions.charAt(right) == 'R'){
            right--;
        }
        if(left >= right) return 0; // No collisions possible
        int collisions = 0;

        // Count collisions from left to right
        for(; left <= right; left++){
            // 'L' and 'R' will collide, 'S' will cause a collision with either 'L' or 'R'
            collisions += (directions.charAt(left) != 'S' ? 1 : 0);
        }
        return collisions;
    }
}
