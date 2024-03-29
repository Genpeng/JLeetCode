package c03_linked_list.lc0021_merge_two_sorted_lists;

import entity.ListNode;

/**
 * This is the solution of No. 21 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Merge two sorted linked lists and return it as a new list. The new list should be made by
 * splicing together the nodes of the first two lists.
 *
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * ==========================================================================================================
 *
 * Tags: linked list;
 *
 * @author  Lukas (xgp1227@gmail.com)
 * @date    2019/03/27
 */
public class Solution1 {
    /**
     * Approach 1: Iteration
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param l1 ListNode, one of two linked lists
     * @param l2 ListNode, the other linked list
     * @return ListNode, the merged linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 == null ? l2 : l1;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[] {1, 2, 4});
        ListNode l2 = new ListNode(new int[] {1, 3, 4});
        System.out.println((new Solution1()).mergeTwoLists(l1, l2));
    }
}
