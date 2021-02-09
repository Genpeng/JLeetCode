package c03_linked_list.lc0092_reverse_linked_list_ii;

import entity.ListNode;

/**
 * This is the solution of No. 92 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/reverse-linked-list-ii/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: linked list;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 步骤0：创建一个虚拟结点，主要用于处理 m = 1 的情况
        ListNode dummyHead = new ListNode(-1, head);
        // 步骤1：创建一个指针，并指向反转区域的前一个结点
        int index = 0;
        ListNode p1 = dummyHead;
        while (index < m - 1) {
            p1 = p1.next;
            ++index;
        }
        // 步骤2：对反转区域中的结点进行反转
        ListNode p2 = p1.next;
        ListNode prev = null;
        ListNode curr = p2;
        ++index;
        while (index <= n) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            ++index;
        }
        // 步骤3：将断开的链表进行连接
        p1.next = prev;
        p2.next = curr;
        return dummyHead.next;
    }
}