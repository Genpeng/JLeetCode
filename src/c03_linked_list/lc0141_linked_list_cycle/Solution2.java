package c03_linked_list.lc0141_linked_list_cycle;

import entity.ListNode;

/**
 * This is the solution of No. 141 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)
 * in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 * Follow up:
 * Can you solve it using O(1) (i.e. constant) memory?
 * ==========================================================================================================
 *
 * Tags: linked list;two pointers;
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/03/31
 */
public class Solution2 {
    /**
     * Approach 2: Fast Slow Pointers
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param head ListNode, the head of the linked list
     * @return boolean, true if the linked list has a cycle
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(new int[] {1, 2, 3, 4});
        System.out.println((new Solution2()).hasCycle(head1));

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = head2;
        System.out.println((new Solution2()).hasCycle(head2));
    }
}
