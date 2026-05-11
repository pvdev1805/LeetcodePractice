package array.problem2553;

// Problem 2553 - Separate the Digits in an Array
// Link: https://leetcode.com/problems/separate-the-digits-in-an-array/
// Level: Easy

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    // #1. String Conversion Approach
    // Time Complexity: O(N * M), where N is the length of the input array nums and M is the average number of digits in the numbers, since we need to iterate through each number and then through each digit of the number, we are using O(N * M) time.
    // Space Complexity: O(N * M), since we are using a list to store the separated digits, and in the worst case, if all numbers have M digits, we are using O(N * M) space.
    public int[] separateDigits(int[] nums) {
        List<Integer> answerList = new LinkedList<>();
        for (int num : nums) {
            String numStr = String.valueOf(num);
            for (char digit : numStr.toCharArray()) {
                answerList.addLast(digit - '0'); // Convert char digit to int and add to the list
            }
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i); // Convert List<Integer> to int[]
        }
        return answer;
    }

    // #2. Mathematical Approach
    // Time Complexity: O(N * M), where N is the length of the input array nums and M is the average number of digits in the numbers, since we need to iterate through each number and then through each digit of the number, we are using O(N * M) time.
    // Space Complexity: O(N * M), since we are using a list to store the separated digits, and in the worst case, if all numbers have M digits, we are using O(N * M) space.
    public int[] separateDigits2(int[] nums) {
        List<Integer> answerList = new LinkedList<>();
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            while (num > 0) {
                int digit = num % 10;
                answerList.addLast(digit); // Add the last digit to the list
                num /= 10; // Remove the last digit
            }
        }
        Collections.reverse(answerList);
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i); // Convert List<Integer> to int[]
        }
        return answer;
    }

    // #3. Stack Approach
    // Time Complexity: O(N * M), where N is the length of the input array nums and M is the average number of digits in the numbers, since we need to iterate through each number and then through each digit of the number, we are using O(N * M) time.
    // Space Complexity: O(N * M), since we are using a list to store the separated digits and a stack to temporarily hold the digits of each number, in the worst case, if all numbers have M digits, we are using O(N * M) space.
    public int[] separateDigits3(int[] nums) {
        List<Integer> answerList = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        for (int num : nums) {
            if (num <= 9) {
                answerList.addLast(num);
                continue;
            }
            while (num > 0) {
                int digit = num % 10;
                stack.push(digit); // Push the last digit onto the stack
                num /= 10; // Remove the last digit
            }
            while (!stack.isEmpty()) {
                answerList.addLast(stack.pop()); // Pop digits from the stack and add to the list
            }
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i); // Convert List<Integer> to int[]
        }
        return answer;
    }
}
