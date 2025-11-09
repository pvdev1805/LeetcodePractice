package Math.problem2169;

// Problem 2169 - Count Operations to Obtain Zero
// Link: https://leetcode.com/problems/count-operations-to-obtain-zero/
// Level: Easy

public class Solution {
    // #1. Simulation
    // Time Complexity: O(max(num1, num2))
    // Space Complexity: O(1)
    public int countOperations(int num1, int num2) {
        int count = 0;
        while(num1 != 0 && num2 != 0){
            if(num1 >= num2){
                num1 -= num2;
            } else {
                num2 -= num1;
            }
            count++;
        }
        return count;
    }

    // #2. Mathematical
    // Time Complexity: O(log(min(num1, num2)))
    // Space Complexity: O(log(min(num1, num2)))
    public int countOperations2(int num1, int num2) {
        if(num1 == 0 || num2 == 0) return 0;
        return num1 / num2 + countOperations2(num2, num1 % num2);
    }

    // #3. Optimized Mathematical
    // Time Complexity: O(log(min(num1, num2)))
    // Space Complexity: O(1)
    public int countOperations3(int num1, int num2) {
        int count = 0;
        int a = Math.max(num1, num2), b = Math.min(num1, num2);
        while(a != 0 && b != 0){
            count += a/b;
            int temp = a % b;
            a = b;
            b = temp;
        }
        return count;
    }
}
