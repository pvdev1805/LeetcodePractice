package slidingWindow.problem1493;

// Problem 1493 - Longest Subarray of 1's After Deleting One Element
// Link: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
// Level: Medium

public class Solution {
    // #1. Naive Approach
    // Time Complexity: O(n), where n is the length of the input array.
    // Space Complexity: O(1), no extra space used.
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int first1 = -1; // Index of the first '1'
        for(int i = 0; i < n; i++){
            if(nums[i] == 1){
                first1 = i;
                break;
            }
        }
        if(first1 == -1) return 0; // No '1's in the array
        int ans = 0, prev = 0, curr = 0;
        for(int i = first1; i < n; i++){
            if(nums[i] == 1){
                curr++; // Increment current count of '1's
            } else {
                ans = Math.max(ans, prev + curr); // Update answer
                prev = curr; // Move current count to previous
                curr = 0; // Reset current count
            }
        }
        if(curr == n) return n - 1; // All elements are '1's, need to delete one
        ans = Math.max(ans, prev + curr); // Final update to answer
        return ans; // Return the maximum length found
    }

    // #2. Sliding Window Approach
    // Time Complexity: O(n), where n is the length of the input array.
    // Space Complexity: O(1), no extra space used.
    public int longestSubarray2(int[] nums){
        int n = nums.length;
        int left = 0, zeros = 0, ans = 0;

        for(int right = 0; right < n; right++){
            if(nums[right] == 0) zeros++; // Count zeros in the current window

            while(zeros > 1){ // If more than one zero, shrink the window from the left
                if(nums[left] == 0) zeros--; // Decrease zero count if left element is zero
                left++; // Move left pointer to the right
            }
            ans = Math.max(ans, right - left); // Update answer with the size of the current valid window
        }
        return ans; // Return the maximum length found
    }
}
