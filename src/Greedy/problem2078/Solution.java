package Greedy.problem2078;

// Problem 2078 - Two Furthest Houses With Different Colors
// Link: https://leetcode.com/problems/two-furthest-houses-with-different-colors/
// Level: Easy

public class Solution {
    // #1. Two Pointers - Greedy Approach
    // Time Complexity: O(N), where N is the length of the input array colors, since we need to iterate through the array once using two pointers, we are using O(N) time.
    // Space Complexity: O(1), since we are using a constant amount of space to store the pointers and the variable for maximum distance, we are using O(1) space.
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxDistance = 0;
        int left = 0, right = n - 1;
        for (int i = n - 1; i > 0; i--) {
            if (colors[i] != colors[left]) {
                left = i;
                break;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (colors[i] != colors[right]) {
                right = i;
                break;
            }
        }
        maxDistance = Math.max(left, n - 1 - right);
        return maxDistance;
    }
}
