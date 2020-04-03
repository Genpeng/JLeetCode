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
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/07/04
 */
public class Solution2 {
    /**
     * 解法二："k指针"（双指针的扩展版），即每次将值最小的节点加到结果链表中
     * 时间复杂度：O(N * k)
     * 空间复杂度：O(1)
     *
     * @param lists ListNode[], k sorted linked lists
     * @return ListNode, the new sorted linked list
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        while (true) {
            int minIndex = -1;
            ListNode minNode = new ListNode(Integer.MAX_VALUE);
            for (int i = 0; i < lists.length; ++i) {
                ListNode node = lists[i];
                if (node != null && node.val < minNode.val) {
                    minIndex = i;
                    minNode = node;
                }
            }
            if (minNode.val == Integer.MAX_VALUE) { // or `minIndex == -1`
                break;
            }
            tail.next = minNode;
            tail = tail.next;
            // update to next iteration
            lists[minIndex] = minNode.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(new int[] {1, 4, 5});
        ListNode head2 = new ListNode(new int[] {1, 3, 4});
        ListNode head3 = new ListNode(new int[] {2, 6});
        ListNode[] lists = new ListNode[] {head1, head2, head3};
        Solution2 solution = new Solution2();
        System.out.println(solution.mergeKLists(lists));
    }
}