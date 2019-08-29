package linked_list.lc0023_merge_k_sorted_lists;

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
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/07/04
 */
public class Solution1 {
    /**
     * 解法一：暴力法（Brute force），取出链表中所有节点的值，然后进行排序，最后用排序的数组生成一个新的链表
     * 时间复杂度：O(N * log(N))
     * 空间复杂度：O(N)
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