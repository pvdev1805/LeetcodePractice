package linkedList.problem3217;

// Problem 3217 - Delete Nodes From Linked List Present in Array
// Link: https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/
// Level: Medium

import java.util.*;

public class Solution {
    // #1. HashMap
    // Time Complexity: O(N + M) where N is the length of linked list and M is the length of nums array
    // Space Complexity: O(M)
    public ListNode modifiedList(int[] nums, ListNode head) {
        Map<Integer, Boolean> map = new HashMap<>();
        for(int num : nums){
            map.put(num, true);
        }
        while(head != null && map.containsKey(head.val)){
            head = head.next;
        }
        ListNode currentNode = head;
        while(currentNode != null){
            while(currentNode.next != null && map.containsKey(currentNode.next.val)){
                currentNode.next = currentNode.next.next;
            }
            currentNode = currentNode.next;
        }
        return head;
    }

    // #2. Counting Array
    // Time Complexity: O(N + M) where N is the length of linked list and
    // Space Complexity: O(1)
    public ListNode modifiedList2(int[] nums, ListNode head) {
        boolean[] exists = new boolean[1001];
        for(int num : nums){
            exists[num] = true;
        }
        while(head != null && exists[head.val]){
            head = head.next;
        }
        ListNode currentNode = head;
        while(currentNode != null){
            while(currentNode.next != null && exists[currentNode.next.val]){
                currentNode.next = currentNode.next.next;
            }
            currentNode = currentNode.next;
        }
        return head;
    }

    // #3. HashSet
    // Time Complexity: O(N + M) where N is the length of linked list and
    // Space Complexity: O(M)
    public ListNode modifiedList3(int[] nums, ListNode head){
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        while(head != null && set.contains(head.val)){
            head = head.next;
        }
        ListNode currentNode = head;
        while(currentNode != null){
            while(currentNode.next != null && set.contains(currentNode.next.val)){
                currentNode.next = currentNode.next.next;
            }
            currentNode = currentNode.next;
        }
        return head;
    }

    // #4. HashSet + Stack
    // Time Complexity: O(N + M) where N is the length of linked list and
    public ListNode modifiedList4(int[] nums, ListNode head){
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        Stack<Integer> stack = new Stack<>();
        ListNode currentNode = head;
        while(currentNode != null){
            if(!set.contains(currentNode.val)){
                stack.push(currentNode.val);
            }
            currentNode = currentNode.next;
        }
        ListNode newHead = null;
        while(!stack.isEmpty()){
            ListNode newNode = new ListNode(stack.pop());
            newNode.next = newHead;
            newHead = newNode;
        }
        return newHead;
    }
}
