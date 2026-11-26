package Math.problem3360;

// Problem 3360 - Stone Removal Game
// Link: https://leetcode.com/problems/stone-removal-game/
// Level: Easy

public class Solution {
    // #1. Iterative Approach
    // Time Complexity: O(1) since we are using a constant amount of turn to determine the winner
    // Space Complexity: O(1) since we are using a constant amount of extra space
    public boolean canAliceWin(int n) {
        boolean isAliceTurn = true;
        int stonesRemoved = 10;
        while (n >= stonesRemoved) {
            n -= stonesRemoved;
            isAliceTurn = !isAliceTurn;
            stonesRemoved--;
        }
        if (isAliceTurn == true) return false;
        return true;
    }
}
