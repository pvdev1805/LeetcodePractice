package twoPointers.problem2210;

// Problem 2210 - Count Hills and Valleys in an Array
// Link: https://leetcode.com/problems/count-hilly-and-valley-pairs/
// Level: Easy

public class Solution {
    // #1. Two-Pointer Approach
    // Time Complexity: O(n), where n is the length of the input array.
    // Space Complexity: O(1), no extra space used.
    public int countHillValley(int[] nums){
        int n = nums.length;
        int count = 0;
        int left = 0;

        for(int i = 1; i < n - 1; i++){
            if(nums[i] != nums[i+1]){
                if((nums[left] < nums[i] && nums[i] > nums[i+1]) || (nums[left] > nums[i] && nums[i] < nums[i+1])){
                    ++count;
                }
                left = i;
            }
        }

        return count;
    }
}
