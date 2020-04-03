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
public class Solution3 {
    /**
     * 方法二：动态规划
     *
     * 时间复杂度：O(n)，其中，n表示数组的长度
     * 空间复杂度：O(n)
     *
     * @param nums int[], the input integer array
     * @param k int, the size of the sliding window
     * @return int[], the max sliding window
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        boolean isKIllegal = k <= 0 || k > nums.length;
        if (nums == null || isKIllegal) {
            throw new IllegalArgumentException("[ERROR] The input array is null, or the value of k is illegal!!!");
        }
        // TODO: 学习完动态规划后补充
        return null;
    }

    public static void main(String[] args) {
        int k = 4;
        int[] nums = new int[] {1, 3, -1, -3, 5, 3, 6, 7};

        Solution3 solution1 = new Solution3();
        int[] res = solution1.maxSlidingWindow(nums, k);
        PrintUtil.printArray(res);
    }
}
