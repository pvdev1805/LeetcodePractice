package hashMap.problem3289;

// Problem 3289 - The Two Sneaky Numbers of Digitville
// Link: https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/
// Level: Easy

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    // #1. HashMap
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        int i = 0;
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.get(num) == 2){
                result[i] = num;
                i++;
            }
        }
        return result;
    }

    // #2. Counting Array
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int[] getSneakyNumbers2(int[] nums) {
        int n = nums.length;
        int[] count = new int[101];
        int[] result = new int[2];
        int i = 0;
        for(int num : nums){
            count[num]++;
            if(count[num] == 2){
                result[i] = num;
                i++;
            }
        }
        return result;
    }

    // #3. Sorting
    // Time Complexity: O(N log N)
    // Space Complexity: O(1)
    public int[] getSneakyNumbers3(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] result = new int[2];
        int i = 0;
        for(int j = 1; j < n; j++){
            if(nums[j] == nums[j - 1]){
                result[i] = nums[j];
                i++;
            }
        }
        return result;
    }

    // #4. Cyclic Sort
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int[] getSneakyNumbers4(int[] nums) {
        int n = nums.length;

        int i = 0;
        while(i < n){
            if(nums[i] < n && nums[i] != nums[nums[i]]){
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        int[] result = new int[2];
        int idx = 0;
        for(i = 0; i < n; i++){
            if(nums[i] < n && nums[i] != i){
                result[idx++] = nums[i];
            }
        }
        return result;
    }
}
