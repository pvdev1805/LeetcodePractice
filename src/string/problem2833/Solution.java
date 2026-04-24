package string.problem2833;

// Problem 2833 - Furthest Point From Origin
// Link: https://leetcode.com/problems/furthest-point-from-origin/
// Level: Easy

public class Solution {
    // #1. Counting Approach
    // Time Complexity: O(N), where N is the length of the input string moves, since we need to iterate through the string once to count the occurrences of 'L', 'R', and '_', we are using O(N) time.
    // Space Complexity: O(1), since we are using a constant amount of space to store the counts of 'L', 'R', and '_', we are using O(1) space.
    public int furthestDistanceFromOrigin(String moves) {
        int countLeft = 0, countRight = 0, countUnderscore = 0;
        for (char move : moves.toCharArray()) {
            if (move == 'L') countLeft++;
            else if (move == 'R') countRight++;
            else countUnderscore++;
        }
        return Math.abs(countRight - countLeft) + countUnderscore;
    }
}
