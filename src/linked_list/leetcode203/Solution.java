package linked_list.leetcode203;

/**
 * This is the solution of no. 203 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 *
 * @author StrongXGP
 */
public class Solution {
    /**
     * Solution1 without dummy head.
     *
     * @param head ListNode, the head of the linked list
     * @param val int, the value we want to find
     * @return ListNode, the head of the changed linked list
     */
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if (head == null) {
            return null;
        }

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }

        return head;
    }

    /**
     * Solution1 with dummy head.
     *
     * @param head ListNode, the head of the linked list
     * @param val int, the value we want to find
     * @return ListNode, the head of the changed linked list
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }

    /**
     * Solution1 using recursion.
     *
     * @param head ListNode, the head of the linked list
     * @param val int, the value we want to find
     * @return ListNode, the head of the changed linked list
     */
    public ListNode removeElements3(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        head.next = removeElements3(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 6, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution()).removeElements3(head, 6);
        System.out.println(head);
    }
}
