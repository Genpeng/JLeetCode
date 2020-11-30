package c06_heap_and_priority_queue.lc0347_top_k_frequent_elements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * This is the solution of No. 347 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Note:
 * - You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * - Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * - It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
 *   You can return the answer in any order.
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: heap;sort;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Heap
     *
     * Complexity Analysis:
     * Time Complexity: O(N * log(k))
     * Space Complexity: O(N)
     *
     * @param nums int[], the input integer array
     * @param k int, an integer used to specify the number of most frequent elements to return
     * @return int[], the k most frequent elements
     */
    public int[] topKFrequent(int[] nums, int k) {
        final int n = nums.length;
        if (n <= 1 || k == n) {
            return nums;
        }
        Map<Integer, Integer> counts = new HashMap<>(n);
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> counts.get(e1) - counts.get(e2));
        for (int num : counts.keySet()) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (counts.get(num) > counts.get(pq.peek())) {
                pq.poll();
                pq.offer(num);
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}