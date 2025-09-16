package numberTheory.problem2197;

// Problem 2197 - Replace Non-Coprime Numbers in Array
// https://leetcode.com/problems/replace-non-coprime-numbers-in-array
// Level: Hard

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int gcd(int a, int b){
        while(b != 0){
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }

    private int lcm(int a, int b){
        return a / gcd(a, b) * b;
    }

    // #1. GCD and LCM with Stack
    // Time Complexity: O(N * log(M)) where N is the length of nums and M is the maximum number in nums
    // Space Complexity: O(N) for the stack
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stack = new ArrayList<>();

        for(int num: nums){
            while(!stack.isEmpty()){
                int top = stack.getLast();
                int g = gcd(top, num);
                if (g == 1) {
                    break;
                }
                stack.removeLast();
                num = lcm(top, num);
            }
            stack.add(num);
        }
        return stack;
    }
}
