package c03_linked_list.lc0142_linked_list_cycle_ii;

import entity.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * This is the solution of No. 142 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)
 * in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 *
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 *
 * Follow up:
 * Can you solve it without using extra space?
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: linked list;two pointers;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 * @date    2019/03/31
 */
public class Solution1 {
    /**
     * Approach 1: Hash Table
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param head ListNode, the head of linked list
     * @return ListNode, the node where the cycle begins
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            if (seen.contains(curr)) {
                return curr;
            }
            seen.add(curr);
            curr = curr.next;
        }
        return null;
    }
}
