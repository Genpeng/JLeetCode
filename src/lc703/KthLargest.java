package lc703;

import java.util.PriorityQueue;

/**
 * This is the solution of No. 703 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element
 * in the sorted order, not the kth distinct element.
 *
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums,
 * which contains initial elements from the stream. For each call to the method KthLargest.add,
 * return the element representing the kth largest element in the stream.
 *
 * Example:
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 *
 * Note:
 * You may assume that nums' length ≥ k-1 and k ≥ 1.
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/04/18
 */
public class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>(k);
        this.k = k;

        if (nums == null || nums.length == 0) {
            return;
        }
        // 为什么这里不能直接用self.pq.add(num)？
        for (int num : nums) {
            if (this.pq.size() < k) {
                this.pq.add(num);
            } else if (num > this.pq.peek()) {
                this.pq.poll();
                this.pq.add(num);
            }
        }
    }

    public int add(int val) {
        if (this.pq.size() < k - 1) {
            throw new IllegalArgumentException("[ERROR] The number of elements is less than (k-1) !!!");
        } else if (this.pq.size() == k - 1) {
            this.pq.add(val);
        } else if (val > this.pq.peek()) {
            this.pq.poll();
            this.pq.add(val);
        }
        return this.pq.peek();
    }
}