package Greedy.problem3201;

public class Solution2 {
    // #2. Dynamic Programming Approach
    // Time Complexity: O(N)
    // Space Complexity: O(2*2) = O(1)
    public int maximumLength(int[] nums) {
        int k=2;
        int[][] dp = new int[k][k];
        int res = 0;
        for (int num : nums) {
            num %= k;
            dp[0][num] = dp[num][0] + 1;
            res = Math.max(res, dp[0][num]);
            dp[1][num] = dp[num][1] + 1;
            res = Math.max(res, dp[1][num]);
        }
        return res;
    }
}
