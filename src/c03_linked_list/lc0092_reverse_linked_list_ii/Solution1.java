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
 * Note: 1 ≤ m ≤ n ≤ length of list.
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 步骤1：创建一个虚拟头结点
        ListNode dummyHead = new ListNode(-1, head);
        // 步骤2：跳转到 left 前一个位置
        int i = 0;
        ListNode p1 = dummyHead;
        while (i < left - 1) {
            p1 = p1.next;
            ++i;
        }
        // 步骤3：翻转区间内的链表
        ListNode p2 = p1.next;
        ListNode prev = null, curr = p2;
        ++i;
        while (i <= right) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            ++i;
        }
        // 步骤4：链接断开的链表
        p1.next = prev;
        p2.next = curr;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.reverseBetween(new ListNode(new int[] {1, 2, 3, 4, 5}), 2, 4));
    }
}