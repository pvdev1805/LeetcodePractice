package Math.problem1344;

// Problem 1344 - Angle Between Hands of a Clock
// Link: https://leetcode.com/problems/angle-between-hands-of-a-clock/
// Level: Medium

public class Solution {
    // #1. Trigonometry Approach
    // Time Complexity: O(1), since we are performing a constant number of arithmetic operations
    // Space Complexity: O(1), since we are using a constant amount of space to store the intermediate values and the final result
    public double angleClock(int hour, int minutes) {
        // Minute hand: 12:00 (0,0) , 12:30 (0.5, 6), 12:45 (0.75, 9) --> y1 = 12*x
        // --> After 1 hour, the minute hand goes through 12 digits on the clock from 1-12
        // Hour hand: y2 = x
        // --> After 1 hour, the hour hand goes through 1 digit on the clock
        // After the same time, the difference between minute hand and hour hand: diff = y1 - y2 = 12*x - x = 11*x

        // The hour: x = hour + minutes/60.0
        double x = hour + minutes / 60.0;
        double diff = (11.0 * x) % 12.0;
        return Math.min(diff, 12.0 - diff) * 30.0; // 360 degrees / 12 hours = 30 degrees per hour
    }
}
