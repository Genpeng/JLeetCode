package array.leetcode239;

import util.PrintUtil;
import java.util.PriorityQueue;

/**
 * This is the solution of No. 239 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array
 * to the very right. You can only see the k numbers in the window. Each time the sliding window moves right
 * by one position. Return the max sliding window.
 *
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 *
 * Follow up:
 * Could you solve it in linear time?
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/12/25
 */
public class Solution1 {
    /**
     * 方法一：用最大堆去模拟滑动窗口
     *
     * 时间复杂度：O(n * k)，其中，n表示数组的长度
     * 空间复杂度：O(n)
     *
     * @param nums int[], 输入的数组
     * @param k int, 窗口的大小
     * @return int[], 滑动过程中滑动窗口的所有最大值
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }

        int n = nums.length;
        int ri = 0;
        int[] res = new int[n - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; ++i) {
            if (i <= k - 1) { // 如果"窗口"（最大堆）中的元素不足k个
                pq.add(nums[i]);
            } else { // 如果"窗口"（最大堆）中的元素多于k个，则先删除"窗口"的左边界，再加入新的元素
                pq.remove(nums[i - k]);
                pq.add(nums[i]);
            }

            if (i >= k - 1) {
                res[ri++] = pq.peek();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = new int[] {1, 3, -1, -3, 5, 3, 6, 7};

        Solution1 solution1 = new Solution1();
        int[] res = solution1.maxSlidingWindow(nums, k);
        PrintUtil.printArray(res);
    }
}
