package linkedList.problem1290;

// Problem 1290 - Convert Binary Number in a Linked List to Integer I
// Link: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
// Level: Easy

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class Solution {
    // #1.
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int getDecimalValue(ListNode head) {
        int ans = head.val;
        while(head.next != null){
            head = head.next;
            ans = ans * 2 + head.val;
        }
        return ans;
    }
}
