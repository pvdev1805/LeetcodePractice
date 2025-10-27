package matrix.problem2125;

// Problem 2125 - Number of Laser Beams in a Bank
// https://leetcode.com/problems/number-of-laser-beams-in-a-bank/
// Level: Medium

public class Solution {
    // #1. Simulation
    // Time Complexity: O(m * n) where m is the number of rows and n
    // Space Complexity: O(1)
    public int numberOfBeams(String[] bank) {
        int rows = bank.length;
        int cols = bank[0].length();
        int totalBeams = 0;
        int previousDeviceCount = 0;
        int currentDeviceCount = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(bank[i].charAt(j) == '1'){
                    if(i == 0){
                        previousDeviceCount++;
                    } else {
                        currentDeviceCount++;
                    }
                }
            }
            if(currentDeviceCount > 0){
                totalBeams += previousDeviceCount * currentDeviceCount;
                previousDeviceCount = currentDeviceCount;
                currentDeviceCount = 0;
            }
        }

        return totalBeams;
    }
}
