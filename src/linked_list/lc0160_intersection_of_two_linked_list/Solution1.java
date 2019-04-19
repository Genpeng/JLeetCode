package linked_list.lc0160_intersection_of_two_linked_list;

import entity.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * This is the solution of No. 160 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:
 *
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 *
 * begin to intersect at node c1.
 *
 * Notes:
 * - If the two linked lists have no intersection at all, return null.
 * - The linked lists must retain their original structure after the function returns.
 * - You may assume there are no cycles anywhere in the entire linked structure.
 * - Your code should preferably run in O(n) time and use only O(1) memory.
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/04/01
 */
public class Solution1 {
    /**
     * 解法一：哈希表
     * 时间复杂度：O(m + n)，其中m和n分别表示两个链表的长度
     * 空间复杂度：O(m) or O(n)
     *
     * @param headA ListNode, the head of one of the two linked list
     * @param headB ListNode, the other head of the two linked list
     * @return ListNode, the intersection node
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodesHasSeen = new HashSet<>();
        ListNode pA = headA, pB = headB;
        while (pA != null) {
            nodesHasSeen.add(pA);
            pA = pA.next;
        }
        while (pB != null) {
            if (nodesHasSeen.contains(pB)) {
                return pB;
            }
            pB = pB.next;
        }
        return null;
    }
}
