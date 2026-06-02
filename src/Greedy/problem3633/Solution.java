package Greedy.problem3633;

// Problem 3633 - Earliest Finish Time for Land and Water Rides I
// Link: https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-i/
// Level: Easy

public class Solution {
    // #1. Greedy Approach
    // Time Complexity: O(N + M), where N is the length of landStartTime and M is the length of waterStartTime, since we need to iterate through both arrays once to find the minimum finish times and calculate the result, we are using O(N + M) time.
    // Space Complexity: O(1), since we are using a constant amount of space to store the minimum finish times and the result, we are using O(1) space.
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minLandFinishTime = Integer.MAX_VALUE;
        int minWaterFinishTime = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < landStartTime.length; i++) {
            minLandFinishTime = Math.min(minLandFinishTime, landStartTime[i] + landDuration[i]);
        }

        for (int i = 0; i < waterStartTime.length; i++) {
            minWaterFinishTime = Math.min(minWaterFinishTime, waterStartTime[i] + waterDuration[i]);
            result = Math.min(result, Math.max(minLandFinishTime, waterStartTime[i]) + waterDuration[i]);
        }

        for (int i = 0; i < landStartTime.length; i++) {
            result = Math.min(result, Math.max(minWaterFinishTime, landStartTime[i]) + landDuration[i]);
        }

        return result;
    }
}
