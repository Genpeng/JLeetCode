package c03_linked_list.lc0023_merge_k_sorted_lists;

import entity.ListNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
public class Solution1 {
    /**
     * Approach 1: Brute Force
     * Time Complexity: O(N * log(N))
     * Space Complexity: O(N)
     * where N represents the number of all the elements
     *
     * @param lists ListNode[], k sorted linked lists
     * @return ListNode, the new sorted linked list
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        List<Integer> vals = new LinkedList<>();
        for (ListNode l : lists) {
            while (l != null) {
                vals.add(l.val);
                l = l.next;
            }
        }
        Collections.sort(vals);
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        for (int val : vals) {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(new int[] {1, 4, 5});
        ListNode head2 = new ListNode(new int[] {1, 3, 4});
        ListNode head3 = new ListNode(new int[] {2, 6});
        ListNode[] lists = new ListNode[] {head1, head2, head3};
        Solution1 solution = new Solution1();
        System.out.println(solution.mergeKLists(lists));
    }
}