package Greedy.problem3487;

// Problem 3487 - Maximum Unique Subarray Sum After Deletion
// Link: https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion/
// Level: Easy

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    // #1. HashMap Approach
    // Time Complexity: O(n), where n is the length of the input array.
    // Space Complexity: O(n), for storing the frequency of each number.
    public int maxSum(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        Map<Integer, Integer> mp = new HashMap<>();
        for(int num: nums){
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        int sum = nums[0];
        for(int i = 1; i < n; i++){
            if(mp.get(nums[i]) > 1){
                mp.put(nums[i], mp.get(nums[i]) - 1);
            } else {
                sum = Math.max(sum, Math.max(sum + nums[i], nums[i]));
            }
        }
        return sum;
    }

    // #2. Greedy Approach + Fixed-Array
    // Time Complexity: O(n), where n is the length of the input array.
    // Space Complexity: O(m+1), where m is the maximum positive number in the input array.
    public int maxSum2(int[] nums){
        int n = nums.length;
        boolean isPositiveNumExisted = false;
        int maxNum = Integer.MIN_VALUE;
        for(int num: nums){
            if(num > 0 && !isPositiveNumExisted){
                isPositiveNumExisted = true;
            }
            maxNum = Math.max(maxNum, num);
        }
        if(!isPositiveNumExisted) return maxNum;

        boolean[] isVisited = new boolean[maxNum + 1];
        int sum = 0;
        for(int num: nums){
            if(num > 0 && !isVisited[num]){
                isVisited[num] = true;
                sum += num;
            }
        }
        return sum;
    }

    // #3. Greedy Approach + HashSet
    // Time Complexity: O(n), where n is the length of the input array.
    // Space Complexity: O(m), where m is the number of unique positive numbers in the input array.
    public int maxSum3(int[] nums){
        int n = nums.length;
        boolean isPositiveNumExisted = false;
        int maxNum = Integer.MIN_VALUE;
        for(int num: nums){
            if(num > 0 && !isPositiveNumExisted){
                isPositiveNumExisted = true;
            }
            maxNum = Math.max(maxNum, num);
        }
        if(!isPositiveNumExisted) return maxNum;

        Set<Integer> uniquePositiveNums = new HashSet<>();
        for(int num: nums){
            if(num > 0){
                uniquePositiveNums.add(num);
            }
        }
        int sum = 0;
        for(int num: uniquePositiveNums){
            sum += num;
        }
        return sum;
    }
}
