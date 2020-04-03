package c03_linked_list.lc0160_intersection_of_two_linked_list;

import entity.ListNode;

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
public class Solution2 {
    /**
     * 解法二：双指针
     * 时间复杂度：O(L1 + L2 + L3)，具体分析见：https://blog.csdn.net/x273591655/article/details/83409873
     * 空间复杂度：O(1)
     *
     * @param head1 ListNode, the head of one of the two linked list
     * @param head2 ListNode, the other head of the two linked list
     * @return ListNode, the intersection node
     */
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        ListNode p1 = head1, p2 = head2;
        while (p1 != p2) {
            p1 = p1 == null ? head2 : p1.next;
            p2 = p2 == null ? head1 : p2.next;
        }
        return p1;
    }
}
