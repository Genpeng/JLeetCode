package linked_list.leetcode203;

/**
 * The way to debug recursive codes.
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/07/09
 */
public class DebugRecursion {
    /**
     * Solution1 using recursion.
     *
     * @param head ListNode, the head of the linked list
     * @param val int, the value we want to find
     * @return ListNode, the head of the changed linked list
     */
    public ListNode removeElements(ListNode head, int val, int depth) {
        String depthString = generateDepthString(depth);

        System.out.print(depthString);
        System.out.println("Call: remove " + val + " in " + head);

        if (head == null) {
            System.out.print(depthString);
            System.out.println("Head is null, return!");
            return null;
        }

        ListNode res = removeElements(head.next, val, ++depth);

        System.out.print(depthString);
        System.out.println("After remove " + val + ": " + res);

        ListNode ret;
        if (head.val == val) {
            ret = res;
        } else {
            head.next = res;
            ret = head;
        }

        System.out.print(depthString);
        System.out.println("Return: " + ret);

        return ret;
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; ++i) {
            res.append("  ");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 6, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new DebugRecursion()).removeElements(head, 6, 0);
        System.out.println(head);
    }
}
