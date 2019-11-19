package linked_list.lc0023_merge_k_sorted_lists;

import entity.ListNode;

import java.util.Comparator;
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
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/07/04
 */
public class Solution3 {
    /**
     * 解法三：
     * 对解法二进行优化，利用优先队列找出最小值，从而将查找最小值的时间复杂度从O(k)降为O(log(k))，
     * 当然也将空间复杂度从O(1)提升为O(k)。
     *
     * 时间复杂度：O(N * log(k))
     * 空间复杂度：O(k)
     *
     * @param lists ListNode[], k sorted linked lists
     * @return ListNode, the new sorted linked list
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
//        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode n1, ListNode n2) {
//                return n1.val - n2.val;
//            }
//        });
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
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