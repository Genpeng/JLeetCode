package c01_array.lc0239_sliding_window_maximum;

import util.PrintUtil;

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
     * 题意：
     * - 给定一个数组和固定大小的窗口
     * - 窗口从左往右滑动，每次滑动一个元素，即步幅等于 1
     * - 返回窗口从左往右滑动过程中的最大值
     *
     * 解法 1：暴力法
     * 时间复杂度：O(n * k)
     * 空间复杂度：O(n)
     * 其中，n 表示数组的长度，k 表示窗口的大小
     *
     * @param nums int[], the input integer array
     * @param k int, the size of the sliding window
     * @return int[], the max sliding window
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 保证：1 <= k <= n
        if (nums == null || k < 1 || k > nums.length) {
            throw new IllegalArgumentException();
        }
        final int n = nums.length;
        int[] ans = new int[n-k+1];
        int ai = 0;
        for (int i = k-1; i < n; ++i) {
            ans[ai++] = windowMax(nums, i-k+1, i);
        }
        return ans;
    }

    private int windowMax(int[] nums, int li, int ri) {
        int max = Integer.MIN_VALUE;
        for (int i = li; i <= ri; ++i) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = new int[] {1, 3, -1, -3, 5, 3, 6, 7};

        Solution1 solu = new Solution1();
        int[] res = solu.maxSlidingWindow(nums, k);
        PrintUtil.printArray(res);
    }
}
