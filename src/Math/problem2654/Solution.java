package Math.problem2654;

// Problem 2654 - Minimum Number of Operations to Make All Array Elements Equal to 1
// Link: https://leetcode.com/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1/
// Level: Medium

public class Solution {
    // # GCD Helper Function
    // Time Complexity: O(log(min(a, b)))
    // Space Complexity: O(1)
    public int gcd(int a, int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    // #1. GCD Subarray Search
    // Time Complexity: O(N^2 * logM) where N is the length of the array and M is the maximum element in the array.
    // Space Complexity: O(1)
    public int minOperations(int[] nums) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        int cnt1 = 0;
        for(int num: nums){
            if(num == 1) cnt1++;
        }
        if(cnt1 > 0) return n - cnt1; // If there are ones, the gcd of 1 with any number is 1 --> we can convert all other numbers to 1 in n - cnt1 operations.

        for(int i = 0; i < n; i++){
            int currentGCD = nums[i];
            for(int j = i + 1; j < n; j++){
                currentGCD = gcd(currentGCD, nums[j]);
                if(currentGCD == 1){
                    result = Math.min(result, j - i + n - 1); // Operations to make the subarray from i to j all 1s + operations to convert the rest of the array to 1s
                    break;
                }
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
