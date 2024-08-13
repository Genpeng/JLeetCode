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

    /**
     * Cut linked list into two parts
     *
     * @param head ListNode, head of linked list
     * @return ListNode[], a pair of two elements, where the first element is the end of the first half
     *         and the second element is the beginning of the second half
     */
    public static ListNode[] bisectV2(ListNode head) {
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) {
            prev.next = null;
        }
        return new ListNode[] {prev, slow};
    }

    /**
     * Reverse linked list
     *
     * @param head ListNode, the head of linked list
     * @return ListNode, the reversed linked list
     */
    public static ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
