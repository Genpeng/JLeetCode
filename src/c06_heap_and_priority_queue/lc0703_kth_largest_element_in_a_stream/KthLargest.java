package c06_heap_and_priority_queue.lc0703_kth_largest_element_in_a_stream;

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
    private final PriorityQueue<Integer> pq;
    private final int k;

    public KthLargest(int k, int[] nums) {
        if (nums == null || nums.length < k - 1) {
            throw new IllegalArgumentException("[ERROR] The input array is null, or the size of priority queue is less than k-1!!!");
        }

        this.pq = new PriorityQueue<>();
        this.k = k;

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (pq.size() < k) {
            pq.add(val);
        } else if (val > pq.peek()) { // pq.size() == k
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[] {4, 5, 8, 2};
        int k = 3;
        KthLargest kthLargest = new KthLargest(k, nums);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}