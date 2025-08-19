package Math.problem2348;

// Problem 2348 - Number of Zero-Filled Subarrays
// Link: https://leetcode.com/problems/number-of-zero-filled-subarrays/
// Level: Medium

public class Solution {
    // #1. Single Pass Approach
    // Time Complexity: O(n), where n is the length of the input array.
    // Space Complexity: O(1), no extra space used.
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        int count = 0; // Count of zero-filled subarrays
        long ans = 0; // Total number of zero-filled subarrays
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                count++; // Increment count if current element is zero
                ans += count; // Add the count to the answer
            } else {
                count = 0; // Reset count if current element is not zero
            }
        }
        return ans; // Return the total count of zero-filled subarrays
    }

    // #2. Optimized Single Pass Approach
    // Time Complexity: O(n), where n is the length of the input array.
    // Space Complexity: O(1), no extra space used.
    public long zeroFilledSubarray2(int[] nums) {
        int n = nums.length;
        int count = 0; // Count of zero-filled subarrays
        long ans = 0; // Total number of zero-filled subarrays'
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                count++; // Increment count if current element is zero
            } else {
                ans += (long)count * (count + 1) / 2; // Calculate the number of zero-filled subarrays ending at this point
                count = 0; // Reset count if current element is not zero
            }
        }
        if(count > 0) {
            ans += (long)count * (count + 1) / 2; // Add the last segment of zero-filled subarrays if any
        }
        return ans; // Return the total count of zero-filled subarrays
    }
}
