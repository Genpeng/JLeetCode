package lc2;

import entity.ListNode;

/**
 * This is the solution of No. 2 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/add-two-numbers/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/03/20
 */
public class Solution1 {
    /**
     * 解法：非递归
     * 时间复杂度：O(max(m, n))，其中m和n分别表示两个的长度
     * 空间复杂度：O(max(m, n))，返回链表的长度最多为max(m, n)+1
     *
     * @param l1 ListNode, the head of one of linked list
     * @param l2 ListNode, the head of the other linked list
     * @return ListNode, result represents the sum of two linked lists
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;

        int carry = 0;
        for (ListNode p = l1, q = l2; p != null || q != null; ) {
            int sum = carry;
            sum += p == null ? 0 : p.val;
            sum += q == null ? 0 : q.val;

            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            p = p == null ? p : p.next;
            q = q == null ? q : q.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[] {2, 4, 3});
        ListNode l2 = new ListNode(new int[] {5, 6, 4});
        System.out.println((new Solution1()).addTwoNumbers(l1, l2));
    }
}
