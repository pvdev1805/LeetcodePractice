package bitManipulation.problem868;

// Problem 868 - Binary Gap
// Link: https://leetcode.com/problems/binary-gap/
// Level: Easy

public class Solution {
    // #1. Bit Manipulation Approach
    // Time Complexity: O(log n), where n is the input number, since we are processing each bit of n.
    // Space Complexity: O(1), no extra space used.
    public int binaryGap(int n) {
        if ((n & (n - 1)) == 0) return 0; // If n is a power of 2, it has only one set bit, so the binary gap is 0.
        int trailingZeros = Integer.numberOfTrailingZeros(n); // Count the number of trailing zeros in n, which gives us the position of the least significant set bit.
        n >>= trailingZeros; // Shift n right to remove the trailing zeros and position the least significant set bit at the rightmost position.
        int answer = 0;
        int gap = 0;
        while (n > 0) {
            // If the least significant bit of n is 1, we check if the current gap is greater than the answer and reset the gap counter.
            if ((n & 1) == 1) {
                answer = Math.max(answer, gap);
                gap = 0; // Reset the gap counter when we encounter a set bit
            } else {
                gap++; // Increment the gap counter if the least significant bit of n is 0
            }
            n >>= 1; // Shift n right to process the next bit
        }
        return answer + 1; // We add 1 to the answer because the gap is counted between two set bits, so we need to account for the position of the second set bit.
    }

    // #2. Bit Manipulation with Index Tracking
    // Time Complexity: O(log n), where n is the input number, since we are processing each bit of n.
    // Space Complexity: O(1), no extra space used.
    public int binaryGap2(int n) {
        int start = -1; // Initialize start to -1 to indicate that we haven't found the first set bit yet
        int end = -1; // Initialize end to -1 to indicate that we haven't found the second set bit yet
        int maxGap = 0;
        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1; // Get the i-th bit of n
            if (bit == 1) {
                start = (start == -1) ? i : start; // If start is -1, set it to the current index i, otherwise keep it unchanged
                end = (end == -1) ? start : i; // If end is -1, set it to start (which means we found the first set bit), otherwise update it to the current index i (which means we found another set bit)
                maxGap = Math.max(maxGap, end - start); // Update maxGap if the current gap between start and end is greater than maxGap
                start = end; // Move start to the position of the current set bit for the next iteration
            }
        }
        return maxGap; // Return the maximum gap found between two set bits
    }

    // #3. Bit Manipulation with Position Tracking
    // Time Complexity: O(log n), where n is the input number, since we are processing each bit of n.
    // Space Complexity: O(1), no extra space used.
    public int binaryGap3(int n) {
        int ans = 0, previousBitPos = -1, pos = 0;
        while (n > 0) {
            int currentBit = n % 2;
            if (currentBit == 1) {
                if (previousBitPos != -1) {
                    ans = Math.max(ans, pos - previousBitPos);
                }
                previousBitPos = pos;
            }
            pos++;
            n /= 2;
        }
        return ans;
    }
}
