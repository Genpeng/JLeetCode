package util;

import entity.ListNode;

/**
 * Utilities for Linked-List.
 *
 * @author Lukas
 */
public class LinkedListUtil {
    /**
     * Cut linked list into two parts
     *
     * @param head ListNode, head of linked list
     * @return ListNode, head of the second part
     */
    public static ListNode bisect(ListNode head) {
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) {
            prev.next = null;
        }
        return slow;
    }
}
