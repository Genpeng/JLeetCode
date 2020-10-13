package c03_linked_list.lc0206_reverse_linked_list;

import entity.ListNode;

/**
 * This is the solution of No. 206 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Reverse a singly linked list.
 *
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * ==========================================================================================================
 *
 * Difficulty: Easy
 * Tags: linked list;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 * @date   2019/03/28
 */
public class Solution2 {
    /**
     * 解法二：递归
     * 时间复杂度：O(n)，其中n为链表的长度
     * 空间复杂度：O(n)，额外的空间是由于递归占用系统栈空间，递归深度最多为n
     *
     * @param head ListNode, the head of a linked list
     * @return ListNode, the head of the reversed order linked list
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[] {1, 2, 3, 4, 5});
        System.out.println(head);
        System.out.println((new Solution2()).reverseList(head));
    }
}
