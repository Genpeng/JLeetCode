package heap.leetcode703;

import java.util.PriorityQueue;

/**
 * This is the solution of No. 703 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/12/06
 */
public class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;

        if (nums == null || nums.length == 0) {
            return;
        }

        for (int num : nums) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num > pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
    }

    public int add(int val) {
        if (pq.size() < k - 1) {
            throw new IllegalArgumentException("[ERROR] The number of elements is less than (k - 1)!");
        } else if (pq.size() == k - 1) {
            pq.offer(val);
        } else if (val > pq.peek()) { // pq.size() >= k
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(k, arr);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(8));
        System.out.println(kthLargest.add(8));
    }
}

// Runtime: 69 ms
// Your runtime beats 99.31 % of java submissions.

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
