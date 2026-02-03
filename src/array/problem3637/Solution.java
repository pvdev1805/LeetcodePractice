package array.problem3637;

// Problem 3637 - Trionic Array I
// Link: https://leetcode.com/problems/trionic-array-i/
// Level: Easy

public class Solution {
    // #1. State Transition - Single Pass
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public boolean isTrionic(int[] nums){
        int n = nums.length;
        if(n < 4) return false;

        int state = 0; // 0: increasing, 1: decreasing, 2: increasing
        for(int i = 0; i < n - 1; i++){
            if(state == 0){
                if(nums[i] < nums[i + 1]){
                    continue; // still increasing
                } else if(i > 0 && nums[i] > nums[i + 1]){
                    state = 1; // Reached peak --> switch to decreasing
                } else {
                    return false; // invalid pattern
                }
            } else if(state == 1){
                if(nums[i] > nums[i + 1]){
                    continue; // still decreasing
                } else if(nums[i] < nums[i + 1]){
                    state = 2; // Reached valley --> switch to increasing
                } else {
                    return false; // invalid pattern
                }
            } else if(state == 2){
                if(nums[i] < nums[i + 1]){
                    continue; // still increasing
                } else {
                    return false; // invalid pattern
                }
            }
        }
        return state == 2; // Must end in increasing state
    }

    // #2. Find Peaks and Valleys
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public boolean isTrionic2(int[] nums) {
        int n = nums.length;

        // Find p: first position where array stops increasing
        int p = 0;
        while (p < n - 1 && nums[p] < nums[p + 1]) {
            p++;
        }

        // p must be > 0 (there must be an increasing section)
        if (p == 0) {
            return false;
        }

        // Find q: first position after p where array stops decreasing
        int q = p;
        while (q < n - 1 && nums[q] > nums[q + 1]) {
            q++;
        }

        // q must be > p (there must be a decreasing section)
        if (q == p) {
            return false;
        }

        // q must be < n - 1 (there must be an increasing section after q)
        if (q == n - 1) {
            return false;
        }

        // Check that the rest is strictly increasing
        for (int i = q; i < n - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
