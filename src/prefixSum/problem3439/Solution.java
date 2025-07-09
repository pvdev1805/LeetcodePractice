package prefixSum.problem3439;

// Problem 3439 - Reschedule Meetings for Maximum Free Time I
// Link: https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-i/description/
// Level: Medium

public class Solution {
    // #1. Prefix Sum + Sliding Window
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int count = startTime.length;
        int[] prefixSum = new int[count + 1];
        int maxFree = 0;

        for (int i = 0; i < count; i++) {
            prefixSum[i + 1] = prefixSum[i] + endTime[i] - startTime[i];
        }

        for (int i = k - 1; i < count; i++) {
            int occupied = prefixSum[i + 1] - prefixSum[i - k + 1];
            int windowEnd = (i == count - 1) ? eventTime : startTime[i + 1];
            int windowStart = (i == k - 1) ? 0 : endTime[i - k];
            int freeTime = windowEnd - windowStart - occupied;
            maxFree = Math.max(maxFree, freeTime);
        }

        return maxFree;
    }
}
