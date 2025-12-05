package prefixSum.problem3432;

// Problem 3432 - Count Partitions with Even Sum Difference
// Link: https://leetcode.com/problems/count-partitions-with-even-sum-difference/
// Level: Easy

public class Solution {
    // #1. Prefix Sum
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int num : nums) totalSum += num;
        // If total sum is odd, we cannot partition it into two even sums
        int leftSum = 0;
        int count = 0;
        for(int i = 0; i < n - 1; i++){
            leftSum += nums[i];
            int rightSum = totalSum - leftSum;
            if((leftSum % 2 == 0 && rightSum % 2 == 0) || (leftSum % 2 != 0 && rightSum % 2 != 0)){
                count++;
            }
        }
        return count;
    }

    // #2. Prefix Sum with Difference Calculation
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int countPartitions2(int[] nums) {
        for(int j = 1; j < nums.length ; ++j){
            nums[j] += nums[j-1];
        }
        if(nums[nums.length - 1] % 2 != 0) return 0;
        int sum = nums[nums.length - 1];

        int cnt = 0;
        for(int j = 0 ; j < nums.length - 1 ; ++j){
            int diff = sum - 2 * nums[j]; // diff = rightSum - leftSum = (sum - leftSum) - leftSum = sum - 2 * leftSum
            if (diff % 2 == 0) {
                ++cnt;
            }
        }

        return cnt;
    }
}
