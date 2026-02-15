package string.problem67;

// Problem 67 - Add Binary
// Link: https://leetcode.com/problems/add-binary/
// Level: Easy

public class Solution {
    // #1. Two Pointers + StringBuilder
    // Time Complexity: O(max(M, N)) where M and N are the lengths of the input strings
    // Space Complexity: O(max(M, N)) for the result string
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while(i >= 0 || j >= 0 || carry > 0){
            int sum = carry;
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';

            result.append(sum % 2); // Append the current bit
            carry = sum / 2; // Update carry for next iteration
        }

        return result.reverse().toString(); // Reverse the result to get the final binary string
    }
}
