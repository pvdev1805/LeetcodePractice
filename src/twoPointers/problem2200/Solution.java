package twoPointers.problem2200;

// Problem 2200 - Find All K-Distant Indices in an Array
// Link: https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/
// Level: Easy

import java.util.LinkedList;
import java.util.List;

public class Solution {
    // #1.
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new LinkedList<>();
        int n = nums.length;

        int start = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == key){
                int left = Math.max(0, i - k);
                int right = Math.min(n - 1, i+k);

                while(right >= start){
                    if(start >= left) ans.add(start);
                    start++;
                }
            }
        }

        return ans;
    }
}
