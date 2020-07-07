package c03_linked_list.lc0876_middle_of_the_linked_list;

import entity.ListNode;

/**
 * This is the solution of No. 876 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/middle-of-the-linked-list/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * If there are two middle nodes, return the second middle node.
 *
 * Example 1:
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 *
 * Example 2:
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 *
 * Note:
 * The number of nodes in the given list will be between 1 and 100.
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/10/12
 */
public class Solution1 {
    /**
     * 解法：双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param head ListNode, the head of the linked list
     * @return ListNode, the middle node of the linked list
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}