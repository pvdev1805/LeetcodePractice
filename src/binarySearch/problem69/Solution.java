package binarySearch.problem69;

// Problem 69 - Sqrt(x)
// Link: https://leetcode.com/problems/sqrtx/
// Level: Easy

public class Solution {
    // #1. Binary Search Approach
    // Time Complexity: O(log x), where x is the input number.
    // Space Complexity: O(1), no extra space used.
    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(mid  > (x / mid)){
                right = mid - 1;
            } else if(mid < (x / mid)){
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right; // right will be the largest integer such that right * right <= x
    }
}
