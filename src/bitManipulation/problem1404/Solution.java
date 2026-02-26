package bitManipulation.problem1404;

// Problem 1404 - Number of Steps to Reduce a Number in Binary Representation to One
// Link: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
// Level: Medium

public class Solution {
    // #1. Iterative Approach with Carry
    // Time Complexity: O(N), where N is the length of the binary string, since we iterate through the string once.
    // Space Complexity: O(1), as we are using only a constant amount of extra space for the steps and carry variables.
    public int numSteps(String s) {
        int steps = 0, carry = 0; // Initialize steps and carry for addition
        for (int i = s.length() - 1; i > 0; i--) {
            int bit = s.charAt(i) & 1; // Get the current bit (0 or 1)
            if (bit + carry == 1) {
                steps += 2; // If the bit plus carry is 1, we need to add 1 (which will cause a carry) and then divide by 2
                carry = 1; // Set carry to 1 for the next iteration
            } else {
                steps += 1; // If the bit plus carry is 0, we can just divide by 2
            }
            carry |= bit; // Update carry based on the current bit
        }
        return steps + carry; // Add any remaining carry to the steps
    }
}
