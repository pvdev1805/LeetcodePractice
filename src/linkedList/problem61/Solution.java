package linkedList.problem61;

// Problem 61 - Rotate List
// Link: https://leetcode.com/problems/rotate-list/
// Level: Medium

public class Solution {
    // #1. Circular List Approach
    // Time Complexity: O(N), where N is the number of nodes in the linked list, since we need to traverse the list to find its length and then again to find the new tail, we are using O(N) time.
    // Space Complexity: O(1), since we are using a constant amount of space to store pointers and variables, we are using O(1) space.
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int n = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        k = k % n;
        if (k == 0) return head;

        tail.next = head; // Connect tail to head to make it circular

        ListNode newTail = head;
        // Move newTail to the (n-k-1)th node, which will be the new tail after rotation
        for (int i = 0; i < n - k - 1; i++) {
            newTail = newTail.next;
        }

        head = newTail.next;
        newTail.next = null; // Break the circular link to finalize the new list
        return head;
    }
}
