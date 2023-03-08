package c03_linked_list.lc0082_remove_duplicates_from_sorted_list_ii;

import entity.ListNode;

/**
 * This is the solution of No. 83 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only
 * distinct numbers from the original list. Return the linked list sorted as well.
 *
 * Example 1:
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 *
 * Example 2:
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 *
 * Constraints:
 * 1. The number of nodes in the list is in the range [0, 300].
 * 2. -100 <= Node.val <= 100
 * 3. The list is guaranteed to be sorted in ascending order.
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: linked list;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {
        // 如果链表为空，或者只有一个结点，则肯定不存在重复的元素
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1, head); // 元素的取值为 [0, 300]
        ListNode prev = dummyHead;
        while (prev.next != null && prev.next.next != null) {
            if (prev.next.val == prev.next.next.val) {
                int x = prev.next.val;
                while (prev.next != null && prev.next.val == x) {
                    prev.next = prev.next.next;
                }
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }
}