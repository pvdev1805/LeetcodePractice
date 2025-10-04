package twoPointers.problem11;

public class Solution {
    // #1. Two Pointers + Greedy
    // Time Complexity: O(n) where n is the length of the input array.
    // Space Complexity: O(1) since we are using only a constant amount of extra space.
    public int maxArea(int[] height){
        int n = height.length;
        int left = 0, right = n - 1;

        int answer = 0;
        while(left < right){
            int h1 = height[left];
            int h2 = height[right];
            answer = Math.max(answer, (right - left) * Math.min(h1, h2));
            if(h1 < h2){
                left++;
            } else {
                right--;
            }
        }
        return answer;
    }
}
