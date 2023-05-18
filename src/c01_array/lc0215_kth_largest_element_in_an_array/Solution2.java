package c01_array.lc0215_kth_largest_element_in_an_array;

import java.util.PriorityQueue;

/**
 * This is the solution of No. 215 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 *
 * Example 1:
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 * Example 2:
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: array;sort;heap;divide and conquer;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Priority Queue (Min Heap)
     * The idea is to maintain a min heap with a capacity of k, each time if an integer
     * is larger than the top of heap, we update the heap, and finally return the top
     * of the heap.
     *
     * Complexity Analysis:
     * Time Complexity: O(N * log(k))
     * Space Complexity: O(k)
     *
     * Result of Submission:
     * Runtime: 3 ms, faster than 73.83% of Java online submissions for Kth Largest Element in an Array.
     * Memory Usage: 39.5 MB, less than 89.02% of Java online submissions for Kth Largest Element in an Array.
     *
     * @param nums int[], an input integer array
     * @param k int, an integer represents the kth
     * @return int, the kth largest element
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int num : nums) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (pq.peek() < num) {
                pq.poll();
                pq.offer(num);
            }
        }
        return pq.peek();
    }
}