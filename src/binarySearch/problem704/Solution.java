package binarySearch.problem704;

// Problem 704 - Binary Search
// Link: https://leetcode.com/problems/binary-search/
// Level: Easy

public class Solution {
    // #1. Binary Search Approach
    // Time Complexity: O(log n), where n is the number of elements in the array.
    // Space Complexity: O(1), no extra space used.
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while(left <= right){
            int mid = left + (right - left) / 2; // Calculate mid to avoid overflow
            if(nums[mid] == target){
                return mid; // Target found --> return index
            } else if(nums[mid] > target){
                right = mid - 1; // Target is in the left half
            } else {
                left = mid + 1; // Target is in the right half
            }
        }
        return -1; // Target not found --> return -1
    }
}
