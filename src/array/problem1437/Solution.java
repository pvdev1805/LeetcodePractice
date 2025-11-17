package array.problem1437;

// Problem 1437 - Check If All 1's Are at Least Length K Places Away
// Link: https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
// Level: Easy

public class Solution {
    // #1. Two Pointers
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int previousOneIndex = 0;
        while(previousOneIndex < n && nums[previousOneIndex] != 1){
            previousOneIndex++;
        }
        if(previousOneIndex == n) return true; // No 1s in the array
        int currentIndex = previousOneIndex + 1;
        for(int i = currentIndex; i < n; i++){
            if(nums[i] == 1){
                if(i - previousOneIndex - 1 < k){
                    return false;
                }
                previousOneIndex = i;
            }
        }
        return true;
    }

    // #2. Single Pass
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public boolean kLengthApart2(int[] nums, int k) {
        int lastOneIndex = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                if(lastOneIndex != -1 && i - lastOneIndex - 1 < k){
                    return false;
                }
                lastOneIndex = i;
            }
        }
        return true;
    }
}
