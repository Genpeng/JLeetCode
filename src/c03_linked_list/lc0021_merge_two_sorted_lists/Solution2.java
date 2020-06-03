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
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/03/27
 */
public class Solution2 {
    /**
     * Approach 2: Recursion
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param l1 ListNode, one of two linked lists
     * @param l2 ListNode, the other linked list
     * @return ListNode, the merged linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Recursive termination condition
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[] {1, 2, 4});
        ListNode l2 = new ListNode(new int[] {1, 3, 4});
        System.out.println((new Solution2()).mergeTwoLists(l1, l2));
    }
}
