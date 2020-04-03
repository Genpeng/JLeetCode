package c03_linked_list.lc0148_sort_list;

import entity.ListNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * This is the solution of No. 148 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/sort-list/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 *
 * Example 2:
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/06/30
 */
public class Solution1 {
    /**
     * 解法一：取出链表的元素，然后进行排序（弃用）
     * 时间复杂度：O(n * log(n))
     * 空间复杂度：O(n)
     *
     * @param head ListNode, the head of the linked list
     * @return ListNode, the head of the sorted list
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 1. 取出所有的链表元素
        List<Integer> vals = new LinkedList<>();
        ListNode curr = head;
        while (curr != null) {
            vals.add(curr.val);
            curr = curr.next;
        }
        // 2. 排序
        Collections.sort(vals);
        // 3. 生成排序后的链表
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        for (int val : vals) {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[] {-1, 5, 3, 4, 0});
        System.out.println(head);
        Solution1 solution = new Solution1();
        System.out.println(solution.sortList(head));
    }
}