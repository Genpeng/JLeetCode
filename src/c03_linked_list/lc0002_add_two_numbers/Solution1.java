package c03_linked_list.lc0002_add_two_numbers;

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
 * Tags: linked list;
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/03/20
 */
public class Solution1 {
    /**
     * Approach 1: Iteration (Intuition)
     * Time Complexity: O(max(m, n))
     * Space Complexity: O(max(m, n))
     *
     * @param l1 ListNode, the head of one of linked list
     * @param l2 ListNode, the head of the other linked list
     * @return ListNode, result represents the sum of two linked lists
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;
        ListNode p1 = l1, p2 = l2;
        int s;
        int carry = 0;
        while (p1 != null || p2 != null) {
            s = carry;
            s += p1 == null ? 0 : p1.val;
            s += p2 == null ? 0 : p2.val;
            prev.next = new ListNode(s % 10);
            // update to next iteration
            carry = s / 10;
            p1 = p1 == null ? p1 : p1.next;
            p2 = p2 == null ? p2 : p2.next;
            prev = prev.next;
        }
        if (carry > 0) {
            prev.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[] {2, 4, 3});
        ListNode l2 = new ListNode(new int[] {5, 6, 4});
        System.out.println((new Solution1()).addTwoNumbers(l1, l2));
    }
}
