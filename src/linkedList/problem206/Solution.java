package linkedList.problem206;

// Problem 206 - Reverse Linked List
// Link: https://leetcode.com/problems/reverse-linked-list/
// Level: Easy

public class Solution {
    // #1. Recursive Approach
    // Time Complexity: O(n), where n is the number of nodes in the linked list.
    // Space Complexity: O(n), due to the recursion stack space used.
    public ListNode reverseList(ListNode head) {
        // Base case: if the list is empty or has only one node, return it as is
        if(head == null || head.next == null) {
            return head; // If the list is empty or has only one node, return it as is
        }
        ListNode nextNode = head.next; // Store the next node(s) (1 or more nodes ahead)
        ListNode newHead = reverseList(nextNode); // Recursively reverse the rest of the list
        nextNode.next = head; // Set the next node's next to the current head
        head.next = null; // Set the current head's next to null to avoid cycles
        return newHead; // Return the new head of the reversed list
    }

    // #2. Iterative Approach
    // Time Complexity: O(n), where n is the number of nodes in the linked list
    // Space Complexity: O(1), no extra space used.
    public ListNode reverseList2(ListNode head) {
        ListNode previousNode = null; // Initialize previous node as null
        ListNode currentNode = head; // Start with the head of the list
        while(currentNode != null){
            ListNode nextNode = currentNode.next; // Store the next node
            currentNode.next = previousNode; // Reverse the link by pointing current node's next to previous node
            previousNode = currentNode; // Move previous node to current node
            currentNode = nextNode; // Move to the next node in the original list
        }
        return previousNode; // Return the new head of the reversed list
    }
}
