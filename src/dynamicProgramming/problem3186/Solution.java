package dynamicProgramming.problem3186;

// Problem 3186 -Maximum Total Damage With Spell Casting
// https://leetcode.com/problems/maximum-total-damage-with-spell-casting/
// Level: Medium

import java.util.*;

public class Solution {
    // #1. Dynamic Programming + Binary Search
    // Time Complexity: O(n log n) where n is the number of unique power values
    // Space Complexity: O(n) where n is the number of unique power values
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> freq = new HashMap<>();
        for (int p : power) freq.put(p, freq.getOrDefault(p, 0L) + 1);

        List<Integer> keys = new ArrayList<>(freq.keySet());
        Collections.sort(keys);

        int n = keys.size();
        long[] dp = new long[n];
        dp[0] = freq.get(keys.get(0)) * keys.get(0);

        for (int i = 1; i < n; i++) {
            long take = freq.get(keys.get(i)) * keys.get(i);
            int prev = binarySearch(keys, i - 1, keys.get(i) - 3);
            if (prev >= 0) take += dp[prev];
            dp[i] = Math.max(dp[i - 1], take);
        }

        return dp[n - 1];
    }

    // Find the rightmost index in keys where the value is less than or equal to value
    // Time Complexity: O(log n) where n is the number of unique power values
    // Space Complexity: O(1)
    private int binarySearch(List<Integer> keys, int end, int value) {
        int l = 0, r = end, ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (keys.get(mid) <= value) {
                ans = mid;
                l = mid + 1;
            } else r = mid - 1;
        }
        return ans;
    }
}
