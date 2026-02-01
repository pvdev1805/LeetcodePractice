package binarySearch.problem744;

// Problem 744 - Find Smallest Letter Greater Than Target
// Link: https://leetcode.com/problems/find-smallest-letter-greater-than-target/
// Level: Easy

public class Solution {
    // #1. Linear Search
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public char nextGreatestLetter(char[] letters, char target) {
        int currentIndex = 0;
        int n = letters.length;
        while(currentIndex < n && letters[currentIndex] <= target){
            currentIndex++;
        }
        if(currentIndex == n){
            return letters[0];
        }
        return letters[currentIndex];
    }

    // #2. Binary Search
    // Time Complexity: O(log N)
    // Space Complexity: O(1)
    public char nextGreatestLetter2(char[] letters, char target) {
        int n = letters.length;
        int left = 0, right = n - 1;
        char result = letters[0];
        while(left <= right){
            int mid = left + (right - left) / 2;
            char midChar = letters[mid];
            if(midChar > target){
                result = midChar;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
