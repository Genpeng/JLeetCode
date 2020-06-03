package c03_linked_list.lc0023_merge_k_sorted_lists;

import entity.ListNode;

import java.util.PriorityQueue;

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
 * Tags: linked list;two pointers;divide and conquer;
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/07/04
 */
public class Solution3 {
    /**
     * Approach 3: improve approach 2, use priority queue to find out the minimum node
     * Time Complexity: O(N * log(K))
     * Space Complexity: O(K)
     *
     * @param lists ListNode[], k sorted linked lists
     * @return ListNode, the new sorted linked list
     */
    public ListNode mergeKLists(ListNode[] lists) {
        final int N = lists.length;
        if (N == 0) {
            return null;
        }
        if (N == 1) {
            return lists[0]; // 当只有一个链表时，不用执行下面的程序
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
//        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode n1, ListNode n2) {
//                return n1.val - n2.val;
//            }
//        });
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        while (!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;
            if (tail.next != null) {
                pq.offer(tail.next);
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(new int[] {1, 4, 5});
        ListNode head2 = new ListNode(new int[] {1, 3, 4});
        ListNode head3 = new ListNode(new int[] {2, 6});
        ListNode[] lists = new ListNode[] {head1, head2, head3};
        Solution3 solution = new Solution3();
        System.out.println(solution.mergeKLists(lists));
    }
}