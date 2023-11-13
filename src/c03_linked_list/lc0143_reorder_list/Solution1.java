package c03_linked_list.lc0143_reorder_list;

import entity.ListNode;

/**
 * This is the solution of No. 143 problem in the LeetCode,
 * the website of the problem is as follows:
 * https://leetcode.com/problems/reorder-list/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 *
 * Example 1:
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 *
 * Example 2:
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 *
 * Constraints:
 * - The number of nodes in the list is in the range [1, 5 * 104].
 * - 1 <= Node.val <= 1000
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: linked list;
 *
 * @author  Lukas (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * 题意：
     * - 按照规则改变链表结点的位置，目标链表为：原链表的左半端和反转后的右半端合并后的结果
     * - 规则为：L_0 -> L_1 -> ... -> L_n-1 -> L_n 调整为 L_0 -> L_n -> L_1 -> L_n-1 -> ...
     *
     * 思路：
     * 步骤1：找到链表的中间结点，将链表拆分为两个部分
     * 步骤2：翻转后半部分链表
     * 步骤3：合并两部分链表，前半部分取一个，然后后半部分取一个
     *
     * 复杂度分析：
     * 时间复杂度：O(L)
     * 空间复杂度：O(1)
     *
     * @param head ListNode, the head of singly linked list
     */
    public void reorderList(ListNode head) {
        // 如果链表为空，或者只有一个或者两个结点，直接返回
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode mid = findMiddleNode(head);
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverse(l2);
        merge(head, l2);
    }

    public ListNode findMiddleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            // update to next iteration
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private void merge(ListNode l1, ListNode l2) {
        // TODO 是否有更优雅的写法
        // l1_length >= l2_length
        while (l1 != null && l2 != null) {
            ListNode n1 = l1.next;
            ListNode n2 = l2.next;
            l1.next = l2;
            l1 = n1;
            l2.next = l1;
            l2 = n2;
        }
    }
}