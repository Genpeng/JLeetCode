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
public class Solution2 {
    /**
     * Approach 2: Recursion
     * Time Complexity: O(max(m,n))
     * Space Complexity: O(max(m,n))
     *
     * @param l1 ListNode, the head of one of linked list
     * @param l2 ListNode, the head of the other linked list
     * @return ListNode, result represents the sum of two linked lists
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        // Recursive Termination Condition
        if (l1 == null && l2 == null) {
            return carry > 0 ? new ListNode(carry) : null;
        }
        int s = carry;
        ListNode l1Next = l1, l2Next = l2;
        if (l1 != null) {
            s += l1.val;
            l1Next = l1.next;
        }
        if (l2 != null) {
            s += l2.val;
            l2Next = l2.next;
        }
        ListNode head = new ListNode(s % 10);
        head.next = addTwoNumbers(l1Next, l2Next, s / 10);
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[] {2, 4, 3});
        ListNode l2 = new ListNode(new int[] {5, 6, 4});
        System.out.println((new Solution2()).addTwoNumbers(l1, l2));
    }
}
