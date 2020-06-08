package c03_linked_list.lc0148_sort_list;

import entity.ListNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * This is the solution of No. 148 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/sort-list/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * Sort a linked list in O(n log n) time using constant space complexity.
 * <p>
 * Example 1:
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * <p>
 * Example 2:
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * ==========================================================================================================
 * <p>
 * Tags: linked list;sort;divide and conquer;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 * @date    2019/06/30
 */
public class Solution1 {
    /**
     * Approach 1: Brute Force
     * Fetch all the elements in the linked list, sort them, finally generate a new linked list.
     * Time Complexity: O(N * log(N))
     * Space Complexity: O(N)
     *
     * @param head ListNode, the head of the linked list
     * @return ListNode, the head of the sorted list
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // Step 1: fetch all the elements in the linked list
        List<Integer> vals = new LinkedList<>();
        ListNode curr = head;
        while (curr != null) {
            vals.add(curr.val);
            curr = curr.next;
        }
        // Step 2: sort, O(N * log(N))
        Collections.sort(vals);
        // Step 3: generate a new linked list
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        for (int val : vals) {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{-1, 5, 3, 4, 0});
        System.out.println(head);
        Solution1 solution = new Solution1();
        System.out.println(solution.sortList(head));
    }
}