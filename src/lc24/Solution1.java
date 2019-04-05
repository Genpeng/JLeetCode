package lc24;

import entity.ListNode;

/**
 * This is the solution of No. 24 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/04/05
 */
public class Solution1 {
    /**
     * 解法一：迭代
     * 时间复杂度：O(n)，最多需要迭代 int(n/2) 次
     * 空间复杂度：O(1)，只需要保存 4 个节点的引用
     *
     * @param head ListNode, the head of the linked list
     * @return ListNode, the head of the modified linked list
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode curr = dummyHead;
        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next, second = curr.next.next;
            // swap two nodes
            first.next = second.next;
            second.next = first;
            curr.next = second;
            // update to next iteration
            curr = curr.next.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[] {1, 2, 3, 4, 5});
        System.out.println(head);
        System.out.println((new Solution1()).swapPairs(head));
    }
}
