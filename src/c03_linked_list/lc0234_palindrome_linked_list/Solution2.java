package c03_linked_list.lc0234_palindrome_linked_list;

import entity.ListNode;

/**
 * This is the solution of No. 234 problem in the LeetCode,
 * the website of the problem is as follows:
 * https://leetcode.com/problems/palindrome-linked-list
 *
 * The description of problem is as follows:
 * ==========================================================================================================
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 *
 * Example 1:
 * Input: head = [1,2,2,1]
 * Output: true
 *
 * Example 2:
 * Input: head = [1,2]
 * Output: false
 *
 * Constraints:
 * - The number of nodes in the list is in the range [1, 10^5].
 * - 0 <= Node.val <= 9
 *
 * Follow up: Could you do it in O(n) time and O(1) space?
 * ==========================================================================================================
 *
 * Difficulty: Easy
 * Tags: linked list; fast and slow pointers; two pointers;
 *
 * @author  Lukas (xgp1227atgmail.com)
 */
public class Solution2 {
    public boolean isPalindrome(ListNode head) {
        // 解法2：快慢指针（优化版）
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)

        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode prev = null, curr = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 反转链表
            curr.next = prev;
            prev = curr;
            curr = slow;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }
        return true;
    }
}