package array.problem3300;

// Problem 3300 - Minimum Element After Replacement With Digit Sum
// Link: https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/
// Level: Easy

public class Solution {
    // #1. Iteration and Digit Sum Calculation Approach
    // Time Complexity: O(N * D), where N is the length of the input array nums and D is the number of digits in the largest number in the array, since we need to iterate through the array once and for each number, we need to calculate the sum of its digits, we are using O(N * D) time.
    // Space Complexity: O(1), since we are using a constant amount of space to store the minimum digit sum, we are using O(1) space.
    public int minElement(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int num : nums) {
            int digitSum = calculateDigitSum(num);
            ans = Math.min(ans, digitSum);
        }
        return ans;
    }

    private int calculateDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit;
            num /= 10;
        }
        return sum;
    }
}
