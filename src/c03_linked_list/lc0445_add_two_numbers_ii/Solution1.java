package c03_linked_list.lc0445_add_two_numbers_ii;

import entity.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * This is the solution of No. 445 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/add-two-numbers-ii/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit
 * comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Follow up:
 * - What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 *
 * Example:
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: linked list; stack;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        ListNode curr = l1;
        while (curr != null) {
            stack1.push(curr.val);
            curr = curr.next;
        }
        curr = l2;
        while (curr != null) {
            stack2.push(curr.val);
            curr = curr.next;
        }
        curr = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int s = carry;
            s += stack1.isEmpty() ? 0 : stack1.pop();
            s += stack2.isEmpty() ? 0 : stack2.pop();
            carry = s / 10;
            ListNode node = new ListNode(s % 10);
            node.next = curr;
            curr = node;
        }
        return curr;
    }
}