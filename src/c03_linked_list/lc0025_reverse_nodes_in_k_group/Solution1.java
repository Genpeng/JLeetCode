package c03_linked_list.lc0025_reverse_nodes_in_k_group;

import entity.ListNode;

/**
 * This is the solution of No. xxx problem in the LeetCode,
 * the website of the problem is as follows:
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes
 * is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 *
 * Example 2:
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 *
 * Constraints:
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 *
 * Follow-up: Can you solve the problem in O(1) extra memory space?
 * ==========================================================================================================
 *
 * Difficulty: Hard
 * Tags: linked list;
 *
 * @author  Lukas (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * 解法1：Intuition
     * 构造一个虚拟结点（dummy），从 dummy 结点开始，每次遍历 k 个结点，用两个指针标识分别标记 k 个结点的前一个结点（prev）
     * 以及 k 个结点的结束结点（end），然后翻转这 k 个结点，如此重复，当不足 k 个结点时，则不进行翻转
     *
     * Complexity Analysis:
     * - Time Complexity: O(N)
     * - Space Complexity: O(1)
     *
     * @param head ListNode, the head of input linked list
     * @param k int, how many nodes reverse one time
     * @return ListNode, the head of modified linked list
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; ++i) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = prev.next;
            ListNode next = end.next;
            end.next = null;
            prev.next = reverse(start);
            start.next = next;
            prev = start;
            end = start;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[] {1,2,3,4,5});
        System.out.println(head);
        Solution1 solu = new Solution1();
        System.out.println(solu.reverseKGroup(head, 2));
    }
}