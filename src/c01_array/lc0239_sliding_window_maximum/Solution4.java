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
public class Solution4 {
    /**
     * 解法 4：分块 + 预处理（类似稀疏表）
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * 其中，n 表示数组的长度
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
        int[] left  = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i += k) {
            int start = i, end = Math.min(i + k - 1, n-1);
            left[start] = nums[start];
            for (int j = start+1; j <= end; ++j) {
                left[j] = Math.max(left[j-1], nums[j]);
            }
            right[end] = nums[end];
            for (int j = end-1; j >= start; --j) {
                right[j] = Math.max(right[j+1], nums[j]);
            }
        }
        int[] ans = new int[n-k+1];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = Math.max(right[i], left[i+k-1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = new int[] {1, 3, -1, -3, 5, 3, 6, 7};

        Solution4 solu = new Solution4();
        int[] res = solu.maxSlidingWindow(nums, k);
        PrintUtil.printArray(res);
    }
}
