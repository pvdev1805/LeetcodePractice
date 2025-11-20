package array.problem238;

// Problem 238 - Product of Array Except Self
// Link: https://leetcode.com/problems/product-of-array-except-self/
// Level: Medium

public class Solution {
    // #1. Brute Force
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            int product = 1;
            for(int j = 0; j < n; j++){
                if(i != j){
                    product *= nums[j];
                }
            }
            result[i] = product;
        }
        return result;
    }

    // #2. Division Method
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int[] productExceptSelf2(int[] nums) {
        int prod = 1, zeroCount = 0;
        for (int num : nums) {
            if (num != 0) {
                prod *= num;
            } else {
                zeroCount++;
            }
        }

        if (zeroCount > 1) {
            return new int[nums.length];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 0) {
                res[i] = (nums[i] == 0) ? prod : 0;
            } else {
                res[i] = prod / nums[i];
            }
        }
        return res;
    }

    // #3. Prefix and Suffix Products
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int[] productExceptSelf3(int[] nums) {
        int n = nums.length;
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];
        int[] result = new int[n];

        leftProducts[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
        }

        rightProducts[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            result[i] = leftProducts[i] * rightProducts[i];
        }

        return result;
    }

    // #4. Optimized Prefix and Suffix Products
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int[] productExceptSelf4(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }
}
