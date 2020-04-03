package c03_linked_list.lc0024_swap_nodes_in_pairs;

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
public class Solution2 {
    /**
     * 解法二：递归
     * 时间复杂度：O(n)，最多需要递归 int(n/2)+1 次
     * 空间复杂度：O(n)，额外的空间是由于递归调用占用系统栈空间，递归的深度为 int(n/2)+1 层
     *
     * @param head ListNode, the head of the linked list
     * @return ListNode, the head of the modified linked list
     */
    public ListNode swapPairs(ListNode head) {
        // Recursion termination condition
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        head.next = swapPairs(nextNode.next);
        nextNode.next = head;
        return nextNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[] {1, 2, 3, 4, 5});
        System.out.println(head);
        System.out.println((new Solution2()).swapPairs(head));
    }
}
