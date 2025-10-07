package twoPointers.problem15;

// Problem 15 - 3Sum
// https://leetcode.com/problems/3sum/
// Level: Medium

import java.util.*;

public class Solution {
    // #1. Sorting + Two Pointers
    // Time Complexity: O(n^2) where n is the length of the input array
    // Space Complexity: O(M) where M is the number of triplets in the result list.
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(nums[i] > 0) break; // Since the array is sorted, no need to continue if the current number is greater than 0
            if(i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates for the first number in the triplet

            int left = i + 1, right = n - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum > 0){
                    right--;
                } else if(sum < 0){
                    left++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]) left++; // Skip duplicates for the second number in the triplet
                    while(left < right && nums[right] == nums[right + 1]) right--; // Skip duplicates for the third number in the triplet
                }
            }
        }
        return res;
    }

    // #2. Sorting + HashMap
    // Time Complexity: O(n^2) where n is the length of the input array
    // Space Complexity: O(M) where M is the number of triplets in the result
    public List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.get(nums[i]) - 1); // Decrease the count of the current number to avoid using it again
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates for the first number in the triplet

            for (int j = i + 1; j < nums.length; j++) {
                count.put(nums[j], count.get(nums[j]) - 1); // Decrease the count of the second number to avoid using it again
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // Skip duplicates for the second number in the triplet

                int target = -(nums[i] + nums[j]); // The third number needed to make the sum zero
                if (count.getOrDefault(target, 0) > 0) {
                    res.add(Arrays.asList(nums[i], nums[j], target)); // Found a valid triplet
                }
            }

            for (int j = i + 1; j < nums.length; j++) {
                count.put(nums[j], count.get(nums[j]) + 1); // Restore the count of the second number for the next iteration
            }
        }
        return res;
    }
}
