package string.problem2409;

// Problem 2409 - Count Days Spent Together
// Link: https://leetcode.com/problems/count-days-spent-together/
// Level: Easy

public class Solution {
    // Precomputed prefix sum of days in each month for a non-leap year of the {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31} month days array
    private static final int[] PREFIX_SUM = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

    // #1. Date Comparison Approach
    // Time Complexity: O(1) since we are only comparing a fixed number of dates
    // Space Complexity: O(1) since we are using a constant amount of extra space
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        // Step 1: Get the later arrival date
        String overlapStart = arriveAlice.compareTo(arriveBob) > 0 ? arriveAlice : arriveBob;

        // Step 2: Get the earlier leave date
        String overlapEnd = leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob;

        // Step 3: Convert the dates to day of the year and calculate the overlap
        int startDay = getDaysOfYear(overlapStart);
        int endDay = getDaysOfYear(overlapEnd);

        // Step 4: If the start day is after the end day, there is no overlap, so return 0. Otherwise, return the number of overlapping days.
        return Math.max(0, endDay - startDay + 1); // +1 because both start and end days are inclusive
    }

    // Helper method to convert a date in "MM-DD" format to the day of the year
    private int getDaysOfYear(String date) {
        int month = (date.charAt(0) - '0') * 10 + (date.charAt(1) - '0');
        int day = (date.charAt(3) - '0') * 10 + (date.charAt(4) - '0');
        return PREFIX_SUM[month - 1] + day;
    }
}
