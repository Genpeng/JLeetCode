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
public class Solution1 {
    /**
     * 解法一：迭代（推荐）
     * 时间复杂度：O(n)，最多需要迭代n/2次
     * 空间复杂度：O(1)，只需要保存4个节点的引用
     *
     * @param head ListNode, the head of the linked list
     * @return ListNode, the head of the modified linked list
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode n1, n2;
        while (prev.next != null && prev.next.next != null) {
            n1 = prev.next;
            n2 = prev.next.next;
            // swap two nodes
            n1.next = n2.next;
            n2.next = n1;
            prev.next = n2;
            // update to next iteration
            prev = n1;
        }
        return dummyHead.next;
    }

    /**
     * 迭代的另一种写法
     * 时间复杂度：O(n)，最多需要迭代 int(n/2) 次
     * 空间复杂度：O(1)，只需要保存 4 个节点的引用
     *
     * @param head ListNode, the head of the linked list
     * @return ListNode, the head of the modified linked list
     */
    public ListNode swapPairsV2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead, curr = head;
        while (curr != null && curr.next != null) {
            ListNode nextNode = curr.next;
            curr.next = nextNode.next;
            nextNode.next = curr;
            prev.next = nextNode;
            // update to next iteration
            prev = curr;
            curr = curr.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[] {1, 2, 3, 4, 5});
        System.out.println(head);
        System.out.println((new Solution1()).swapPairs(head));
    }
}
