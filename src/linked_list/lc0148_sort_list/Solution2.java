package linked_list.lc0148_sort_list;

import entity.ListNode;


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
public class Solution2 {
    /**
     * 解法二：归并排序（Top down）
     * 时间复杂度：O(n * log(n))
     * 空间复杂度：O(log(n))
     *
     * @param head ListNode, the head of the linked list
     * @return ListNode, the head of the sorted list
     */
    public ListNode sortList(ListNode head) {
        // Recursion termination condition
        if (head == null || head.next == null) {
            return head;
        }
        // Find the middle position and split the linked list into two halves
        ListNode head2 = splitListV0(head);
        // Recursively call `sortList`
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(head2);
        // Merge two sorted list
        return mergeTwoLists(l1, l2);
        // More Concisely
//        return mergeTwoLists(sortList(head), sortList(head2));
    }

    /**
     * 将一个链表分成两半，当链表数目是奇数时，前半部分少一个结点
     *
     * @param head ListNode, the head of the list
     * @return ListNode, the head of the second half
     */
    private ListNode splitListV0(ListNode head) {
//        if (head == null || head.next == null) {
//            throw new IllegalArgumentException("[ERROR] The linked list cannot be separated into two halves!!!");
//        }
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }

    /**
     * 将一个链表分成两半，当链表数目是奇数时，前半部分多一个结点
     *
     * @param head ListNode, the head of the list
     * @return ListNode, the head of the second half
     */
    private ListNode splitListV1(ListNode head) {
//        if (head == null || head.next == null) {
//            throw new IllegalArgumentException("[ERROR] The linked list cannot be separated into two halves!!!");
//        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        return head2;
    }

    /**
     * Merge two sorted list into a 'long' list.
     *
     * @param l1 ListNode, the head of one linked list
     * @param l2 ListNode, the head of the other linked list
     * @return ListNode, the 'long' sorted list
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        // 测试 split 方法
//        ListNode head = new ListNode(new int[] {-1, 5, 3, 4, 0});
//        System.out.println(head);
//        Solution2 solution = new Solution2();
//        ListNode head2 = solution.splitListV1(head);
//        System.out.println(head);
//        System.out.println(head2);

        // 测试 mergeList 方法
        ListNode head = new ListNode(new int[] {-1, 5, 3, 4, 0});
//        System.out.println(solution.sortList(head));
    }
}