package c03_linked_list.lc0061_rotate_list;

import entity.ListNode;

/**
 * This is the solution of No. 61 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/rotate-list/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * Example 1:
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * <p>
 * Example 2:
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 * ==========================================================================================================
 *
 * Tags: linked list;two pointers;
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/04/02
 */
public class Solution1 {
    /**
     * Approach 1: Two Pointers
     *
     * @param head ListNode, the head of the linked list
     * @param k int, rotation steps
     * @return ListNode, the modified linked list
     */
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0; // the length of the linked list
        for (ListNode curr = head; curr != null; curr = curr.next) {
            ++len;
        }
        if (len == 0 || len == 1) { // if the length is 0 or 1, directly return the linked list
            return head;
        }
        k = k % len; // calculate the real rotation steps, 0 <= k < len
        if (k == 0) {
            return head;
        }
        ListNode p1 = head, p2 = head; // the length between p1 and p2 is k+1, that is [1, len]
        for (int i = 0; i < k; ++i) {
            p2 = p2.next;
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        ListNode newHead = p1.next;
        p1.next = null;
        p2.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(head);
        System.out.println((new Solution1()).rotateRight(head, 2));
    }
}
