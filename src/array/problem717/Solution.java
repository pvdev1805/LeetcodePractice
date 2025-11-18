package array.problem717;

// Problem 717 - 1-bit and 2-bit Characters
// Link: https://leetcode.com/problems/1-bit-and-2-bit-characters/
// Level: Easy

public class Solution {
    // #1. Simulation
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int idx = 0;
        while(idx < n - 1){
            if(bits[idx] == 0){
                idx++;
            } else {
                idx += 2;
            }
        }
        return idx == n - 1;
    }

    // #2. Count Trailing Ones
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public boolean isOneBitCharacter2(int[] bits) {
        int n = bits.length;
        int count = 0;
        for(int i = n - 2; i >= 0 && bits[i] == 1; i--){
            count++;
        }
        return count % 2 == 0;
    }

    // #3. Jumping Pointers
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public boolean isOneBitCharacter3(int[] bits) {
        int n = bits.length;
        if (n >= 2 && bits[n - 2] == 0) return true;
        int i = 0;
        while(i < n - 1)
            i += bits[i] + 1;
        return i == n - 1;
    }
}
