package backtracking.problem78;

// Problem 78 - Subsets
// Link: https://leetcode.com/problems/subsets
// Level: Medium

import java.util.LinkedList;
import java.util.List;

public class Solution {
    // #1. Backtracking Approach
    // Time Complexity: O(N * 2^N), where N is the length of the input array.
    // Space Complexity: O(N), for the recursion stack and the result storage.
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> subset = new LinkedList<>();

        backtrack(nums, 0, subset, result);
        return result;
    }

    // Helper method for backtracking
    private void backtrack(int[] nums, int index, List<Integer> subset, List<List<Integer>> result){
        // Base case: if index reaches the length of nums, add the current subset to the result
        if(index == nums.length){
            // Add a copy of the current subset to the result --> Timeline: O(N) in the worst case when subset = nums
            result.add(new LinkedList<>(subset));
            return;
        }

        subset.add(nums[index]); // Include the current number in the subset
        backtrack(nums, index + 1, subset, result); // Recur with the next index
        subset.removeLast(); // Not include the current number in the subset
        backtrack(nums, index + 1, subset, result); // Recur with the next index without the current number
    }

    // #2. Iterative Approach
    // Time Complexity: O(N * 2^N), where N is the length of the input array.
    // Space Complexity: O(N), for the result storage.
    public List<List<Integer>> subsetsIterative(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<>()); // Start with the empty subset

        for(int num : nums){
            int size = result.size(); // Get the current size of the result list
            for(int i = 0; i < size; i++){
                List<Integer> currentSubset = new LinkedList<>(result.get(i)); // Copy the existing subset
                currentSubset.add(num); // Add the current number to the subset
                result.add(currentSubset); // Add the new subset to the result
            }
        }
        return result;
    }
}
