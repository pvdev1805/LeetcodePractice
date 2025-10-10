package prefixSum.problem3147;

// Problem 3147 - Taking Maximum Energy From the Mystic Dungeon
// https://leetcode.com/problems/taking-maximum-energy-from-the-mystic-dungeon/
// Level: Medium

public class Solution {
    // #1. Prefix Sum
    // Time Complexity: O(n) where n is the length of the input array
    // Space Complexity: O(n) where n is the length of the input array
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int maxEnergy = -1001;
        int[] prefixSum = new int[n];
        for(int i = n - 1; i >= 0; i--){
            if(i + k <= n - 1){
                prefixSum[i] = energy[i] + prefixSum[i + k];
            } else {
                prefixSum[i] = energy[i];
            }
            maxEnergy = Math.max(maxEnergy, prefixSum[i]);
        }
        return maxEnergy;
    }

    // #2. Dynamic Programming (In-Place)
    // Time Complexity: O(n) where n is the length of the input array
    // Space Complexity: O(1) - modifying the input array
    public int maximumEnergy2(int[] energy, int k) {
        int n = energy.length;
        int maxEnergy = energy[n - 1];
        for(int i = n - 1; i >= 0; i--){
            if(i + k <= n - 1){
                energy[i] += energy[i + k];
            }
            maxEnergy = Math.max(maxEnergy, energy[i]);
        }
        return maxEnergy;
    }
}
