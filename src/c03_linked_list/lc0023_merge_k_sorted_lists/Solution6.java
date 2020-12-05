package c03_linked_list.lc0023_merge_k_sorted_lists;

import entity.ListNode;

/**
 * This is the solution of No. 23 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * ==========================================================================================================
 *
 * Difficulty: Hard
 * Tags: linked list;two pointers;divide and conquer;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution6 {
    /**
     * 解法六：Divide & Conquer (Bottom up)
     * 时间复杂度：O(N * log(k))
     * 空间复杂度：O(1)
     *
     * @param lists ListNode[], k sorted linked lists
     * @return ListNode, the new sorted linked list
     */
    public ListNode mergeKLists(ListNode[] lists) {
        final int n = lists.length;
        if (n == 0) {
            return null;
        }
        for (int interval = 1; interval < n; interval <<= 1) {
            for (int i = 0; i < n - interval; i += 2 * interval) {
                lists[i] = mergeTwoLists(lists[i], lists[i+interval]);
            }
        }
        return lists[0];
    }

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
        ListNode head1 = new ListNode(new int[] {1, 4, 5});
        ListNode head2 = new ListNode(new int[] {1, 3, 4});
        ListNode head3 = new ListNode(new int[] {2, 6});
        ListNode[] lists = new ListNode[] {head1, head2, head3};
        Solution6 solution = new Solution6();
        System.out.println(solution.mergeKLists(lists));
    }
}