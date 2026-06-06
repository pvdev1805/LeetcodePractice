package prefixSum.problem2574;

// Problem 2574 - Left and Right Sum Differences
// Link: https://leetcode.com/problems/left-and-right-sum-differences/
// Level: Easy

public class Solution {
    // #1. Naive Approach
    // Time Complexity: O(N), where N is the length of the input array nums, since we need to iterate through the array three times to calculate the left sums, right sums, and the final answer, we are using O(N) time.
    // Space Complexity: O(N), since we are using three additional arrays leftSum, rightSum, and answer to store the intermediate sums and the final answer, we are using O(N) space.
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        int[] answer = new int[n];

        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            answer[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return answer;
    }

    // #2. Optimized Approach (Prefix Sum)
    // Time Complexity: O(N), where N is the length of the input array nums, since we need to iterate through the array twice to calculate the right sum and the final answer, we are using O(N) time.
    // Space Complexity: O(1), since we are using only a constant amount of space to store the right sum, left sum, and the final answer, we are using O(1) space.
    public int[] leftRightDifference2(int[] nums) {
        int n = nums.length;
        int rightSum = 0;
        for (int i = 0; i < n; i++) {
            rightSum += nums[i];
        }
        int leftSum = 0;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            rightSum -= nums[i];
            answer[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }
        return answer;
    }
}
