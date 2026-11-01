package Math.problem453;

// Problem 453 - Minimum Moves to Equal Array Elements
// Link: https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
// Level: Medium

public class Solution {
    // #1. Iterative Approach
    // Time Complexity: O(n) since we are iterating through the array once
    // Space Complexity: O(1) since we are using a constant amount of extra space

    /**
     * Mindset: Instead of trying to make all elements equal by incrementing them, we can think of it as making all elements equal to the minimum element in the array.
     * - Incrementing (n - 1) elements by 1 reduces their relative distance to the
     * 1 remaining (left-behind) element by 1 unit.
     * - Conversely, this has the exact same effect on relative gaps as keeping
     * (n - 1) elements fixed and decrementing the remaining element by 1.
     * - Therefore, instead of chasing an unknown upper target `k`, we flip the
     * perspective: bring all elements down to the original minimum (`min`).
     *
     * @param nums The input array of integers.
     * @return The minimum number of moves required to make all elements equal.
     */
    public int minMoves(int[] nums) {
        int minNum = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < minNum) minNum = num;
        }
        int moves = 0;
        for (int num : nums) {
            moves += (num - minNum);
        }
        return moves;
    }
}
