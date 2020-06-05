package entity;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("[ERROR] The input array is null or empty!!!");
        }
        this.val = arr[0];
        ListNode prev = this;
        for (int i = 1; i < arr.length; ++i) {
            prev.next = new ListNode(arr[i]);
            prev = prev.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            res.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        res.append("null");
        return res.toString();
    }
}