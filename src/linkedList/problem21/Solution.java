package linkedList.problem21;

// Problem 21 - Merge Two Sorted Lists
// Link: https://leetcode.com/problems/merge-two-sorted-lists/
// Level: Easy

public class Solution {
    // #1. Iterative
    // Time Complexity: O(N + M)
    // Space Complexity: O(1)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }

        cur.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }

    // #2. Recursive
    // Time Complexity: O(N + M)
    // Space Complexity: O(N + M)
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return (list1 != null) ? list1 : list2;
        }

        if (list1.val > list2.val) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }

        list1.next = mergeTwoLists(list1.next, list2);
        return list1;
    }
}
