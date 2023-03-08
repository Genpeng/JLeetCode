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
 * Difficulty: Medium
 * Tags: linked list;
 *
 * @author  Lukas (xgp1227@gmail.com)
 * @date    2019/03/20
 */
public class Solution1 {
    /**
     * Approach 1: Iteration (Intuition)
     *
     * Complexity Analysis:
     * Time Complexity: O(max(m, n))
     * Space Complexity: O(max(m, n))
     *
     * @param l1 ListNode, the head of one of linked list
     * @param l2 ListNode, the head of the other linked list
     * @return ListNode, result represents the sum of two linked lists
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        int s;
        int carry = 0;
        while (l1 != null || l2 != null) {
            s = carry;
            s += l1 == null ? 0 : l1.val;
            s += l2 == null ? 0 : l2.val;
            tail.next = new ListNode(s % 10);
            // update to next iteration
            carry = s / 10;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
            tail = tail.next;
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        // 输入：两个链表，分别表示两个正整数，需要注意的是，链表存储的是整数的逆序，比如：整数 123，用链表 3->2->1 表示
        // 输出：两个正整数相加的结果，同样的，链表存储的也是整数的逆序

        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        int s, carry = 0;
        while (l1 != null || l2 != null) {
            s = carry;
            if (l1 != null) {
                s += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                s += l2.val;
                l2 = l2.next;
            }
            tail.next = new ListNode(s % 10);
            carry = s / 10;
            tail = tail.next;
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[] {2, 4, 3});
        ListNode l2 = new ListNode(new int[] {5, 6, 4});
        System.out.println((new Solution1()).addTwoNumbersV2(l1, l2));
    }
}
