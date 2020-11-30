package c06_heap_and_priority_queue.lc0347_top_k_frequent_elements;

import java.util.Arrays;
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
public class Solution2 {
    /**
     * Approach 2: Quick Select
     *
     * Complexity Analysis:
     * Time Complexity: O(N) in the average case and O(N ^ 2) in the worse case
     * Space Complexity: O(N)
     *
     * Result of Submission:
     * Runtime: 8 ms, faster than 92.10% of Java online submissions for Top K Frequent Elements.
     * Memory Usage: 41.8 MB, less than 37.09% of Java online submissions for Top K Frequent Elements.
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
        // 统计元素出现的频率
        Map<Integer, Integer> counts = new HashMap<>(n);
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        // 取出元素的唯一值
        int nu = counts.size(); // the number of all unique elements
        int idx = 0;
        int[] unique = new int[nu];
        for (int num : counts.keySet()) {
            unique[idx++] = num;
        }
        // 利用快速算法找出频率最大的 k 个元素
        int li = 0, ri = nu - 1;
        int ti = nu - k;
        while (li < ri) {
            int splitPoint = partition(unique, counts, li, ri);
            if (splitPoint == ti) {
                break;
            } else if (splitPoint < ti) {
                li = splitPoint + 1;
            } else {
                ri = splitPoint - 1;
            }
        }
        return Arrays.copyOfRange(unique, ti, nu);
    }

    private int partition(int[] nums, Map<Integer, Integer> counts, int li, int ri) {
        int pivot = counts.get(nums[ri]);
        int i = li - 1;
        for (int j = li; j < ri; ++j) {
            if (counts.get(nums[j]) < pivot) {
                ++i;
                if (i < j) {
                    swap(nums, i, j);
                }
            }
        }
        swap(nums, ++i, ri);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}