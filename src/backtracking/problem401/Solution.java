package backtracking.problem401;

// Problem 401 - Binary Watch
// Link: https://leetcode.com/problems/binary-watch/
// Level: Easy

import java.util.LinkedList;
import java.util.List;

public class Solution {
    final int[] LEDS = {8, 4, 2, 1, 32, 16, 8, 4, 2, 1}; // First 4 for hours, next 6 for minutes

    // #1. Backtracking Approach
    // Time Complexity: O(2^10), since we are exploring all combinations of 10 LEDs.
    // Space Complexity: O(1), excluding the space used for the result list, as we are using a fixed amount of space for the backtracking process.
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new LinkedList<>();
        backtrack(0, turnedOn, 0, 0, result);
        return result;
    }

    // #2. Bit Manipulation + Brute Force Approach
    // Time Complexity: O(1), since we are iterating through a fixed number of hours (12) and minutes (60).
    // Space Complexity: O(1), excluding the space used for the result list, as we are using a fixed amount of space for the iteration process.
    public List<String> readBinaryWatch2(int turnedOn) {
        List<String> result = new LinkedList<>();
        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                    String time = String.format("%d:%02d", hour, minute);
                    result.add(time);
                }
            }
        }
        return result;
    }

    /**
     * Backtracking helper function to explore all combinations of LEDs.
     *
     * @param idx     - the current index of the LED being considered
     * @param cnt     - the number of LEDs left to turn on
     * @param hours   - the current hours value based on the LEDs turned on
     * @param minutes - the current minutes value based on the LEDs turned on
     * @param result  - the list to store valid time combinations
     *                Time Complexity: O(2^10), since we are exploring all combinations of 10 LEDs.
     *                Space Complexity: O(1), excluding the space used for the result list, as we are using a fixed amount of space for the backtracking process.
     */
    private void backtrack(int idx, int cnt, int hours, int minutes, List<String> result) {
        // Pruning: If we have turned on more LEDs than allowed, or if the hours or minutes exceed their limits, we can stop exploring this path.
        if (hours >= 12 || minutes >= 60) return;

        // Base case: If we have turned on the required number of LEDs, we can add the current time to the result list.
        if (cnt == 0) {
            String time = String.format("%d:%02d", hours, minutes); // Format hours and minutes into a time string
            result.add(time);
            return;
        }

        // Recursive case: Try turning on each LED starting from the current index
        for (int i = idx; i < 10; i++) {
            // If the current LED is for hours (first 4), we add its value to hours; if it's for minutes (next 6), we add its value to minutes.
            if (i < 4) {
                backtrack(i + 1, cnt - 1, hours + LEDS[i], minutes, result);
            } else {
                backtrack(i + 1, cnt - 1, hours, minutes + LEDS[i], result);
            }
        }
    }
}
