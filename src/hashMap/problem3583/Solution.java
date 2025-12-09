package hashMap.problem3583;

// Problem 3583 - Count Special Triplets
// Link: https://leetcode.com/problems/count-special-triplets/
// Level: Medium

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // #1. HashMap Counting Frequency
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int specialTriplets(int[] nums) {
        final int MOD = 1000000007;
        Map<Integer, Integer> suffix = new HashMap<>(), prefix = new HashMap<>();
        for(int num : nums){
            suffix.put(num, suffix.getOrDefault(num, 0) + 1);
        }
        long answer = 0;
        for(int num : nums){
            suffix.put(num, suffix.get(num) - 1);
            answer += (long) prefix.getOrDefault(2 * num, 0) * suffix.getOrDefault(2 * num, 0);
            prefix.put(num, prefix.getOrDefault(num, 0) + 1);
        }
        return (int) (answer % MOD);
    }
}
