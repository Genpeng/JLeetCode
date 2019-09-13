package linked_list.lc0061_rotate_list;

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
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/04/02
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        // 求出链表的长度
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            ++n;
            curr = curr.next;
        }
        // 求出实际右移的次数
        k %= n;
        if (k == 0) {
            return head;
        }
        // 找到倒数第k+1个节点
        ListNode p1 = head, p2 = head;
        for (int i = 0; i < k; ++i) {
            p2 = p2.next;
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // “右移”链表
        ListNode newHead = p1.next;
        p1.next = null;
        p2.next = head;
        return newHead;
    }

    public ListNode rotateRightV2(ListNode head, int k) {
        // 求出链表的长度
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            ++n;
            curr = curr.next;
        }
        // 求出实际翻转的长度
        k %= n; // the range of k is: [0, n-1]
        // 翻转链表
        return rotateNthFromEnd(head, k);
    }

    private ListNode rotateNthFromEnd(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode p1 = head, p2 = head;
        // 移动p2指针，使得p1和p2指针之间有k+1个节点
        for (int i = 0; i < k; ++i) {
            p2 = p2.next;
        }
        // 同时移动p1和p2指针，使得p2指针处于链表的尾部
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // 翻转链表
        ListNode newHead = p1.next;
        p1.next = null;
        p2.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(head);
        System.out.println((new Solution()).rotateRightV2(head, 2));
    }
}
