package c03_linked_list.lc0019_remove_nth_node_from_end_of_list;

import entity.ListNode;

/**
 * This is the solution of No. 19 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * Note:
 * Given n will always be valid.
 *
 * Follow up:
 * Could you do this in one pass?
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: linked list;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 * @date    2019/04/05
 */
public class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head, p2 = head;
        // 指针p2移动n个节点，此时p1和p2之间有n+1个节点
        while (n-- > 0) {
            p2 = p2.next;
        }
        // 如果p2为空，则说明链表的长度刚好等于n，待删除的节点刚好为头结点
        if (p2 == null) {
            return head.next;
        }
        // 如果p2不为空，同时移动两个节点，使得p2正好处于尾节点，此时p1正好处于倒数第n+1个节点
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // 删除倒数第n个节点
        p1.next = p1.next.next;
//        ListNode deleteNode = p1.next;
//        p1.next = deleteNode.next;
//        deleteNode.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[] {1, 2, 3, 4, 5});
        System.out.println(head);
        System.out.println((new Solution1()).removeNthFromEnd(head, 2));
    }
}
