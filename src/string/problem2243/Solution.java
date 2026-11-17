package string.problem2243;

// Problem 2243 - Calculate Digit Sum of a String
// Link: https://leetcode.com/problems/calculate-digit-sum-of-a-string/
// Level: Easy

public class Solution {
    // #1. Iterative Approach
    // Time Complexity: O(n * R) since we are iterating through the string once
    // Space Complexity: O(n) since we are using a StringBuilder to store the intermediate results
    // R is the number of rounds we need to perform until the length of the string is less than or equal to k
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i += k) {
                int end = Math.min(i + k, s.length());
                String subString = s.substring(i, end);
                int sum = 0;
                for (char c : subString.toCharArray()) {
                    sum += c - '0';
                }
                sb.append(sum);
            }
            s = sb.toString();
        }
        return s;
    }

    // #2. Optimized Iterative Approach
    // Time Complexity: O(n * R) since we are iterating through the string once
    // Space Complexity: O(n) since we are using a StringBuilder to store the intermediate results
    // R is the number of rounds we need to perform until the length of the string is less than or equal to k
    public String digitSum2(String s, int k) {
        while (s.length() > k) {
            StringBuilder sb = new StringBuilder();
            int n = s.length();

            for (int i = 0; i < n; i += k) {
                int end = Math.min(i + k, n);
                int sum = 0;

                for (int j = i; j < end; j++) {
                    sum += s.charAt(j) - '0';
                }
                sb.append(sum);
            }
            s = sb.toString();
        }

        return s;
    }

    // #3. Recursive Approach
    // Time Complexity: O(n * R) since we are iterating through the string once
    // Space Complexity: O(n) space + O(R) stack, since we are using a StringBuilder to store the intermediate results and the recursion stack
    // R is the number of rounds we need to perform until the length of the string is less than or equal to k
    public String digitSum3(String s, int k) {
        int n = s.length();
        if (n <= k) return s;

        StringBuilder next = new StringBuilder();
        for (int i = 0; i < n; i += k) {
            int sum = 0;
            int end = Math.min(i + k, n);
            for (int j = i; j < end; j++) {
                sum += s.charAt(j) - '0';
            }
            next.append(sum);
        }

        return digitSum3(next.toString(), k);
    }
}
