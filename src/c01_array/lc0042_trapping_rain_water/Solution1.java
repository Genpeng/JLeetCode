package c01_array.lc0042_trapping_rain_water;

/**
 * This is the solution of No. 42 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 * Example 1:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 *
 * Example 2:
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 * Constraints:
 * - n == height.length
 * - 1 <= n <= 2 * 10^4
 * - 0 <= height[i] <= 10^5
 * ==========================================================================================================
 *
 * Difficulty: Hard
 * Tags: array; dynamic programming; two pointers; monotonic stack;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * 解法一：暴力法
     * 时间复杂度：O(N ^ 2)
     * 空间复杂度：O(1)
     *
     * @param heights int[], a non-negative integer array representing elevation map
     * @return int, how much water the elevation map can trap after raining
     */
    public int trap(int[] heights) {
        if (heights == null || heights.length < 3) {
            return 0;
        }
        final int L = heights.length;
        int waters = 0;
        for (int i = 1; i < L - 1; ++i) {
            // 找出左边最高的高度
            int leftMax = 0;
            for (int j = i - 1; j >= 0; --j) {
                if (heights[j] > leftMax) {
                    leftMax = heights[j];
                }
            }
            // 找出右边最高的高度
            int rightMax = 0;
            for (int j = i + 1; j < L; ++j) {
                if (heights[j] > rightMax) {
                    rightMax = heights[j];
                }
            }
            // 更新接的雨水数（如果当前的高度低于左右两边最高高度中最小的一个）
            int minHeight = Math.min(leftMax, rightMax);
            if (minHeight > heights[i]) {
                waters += (minHeight - heights[i]);
            }
        }
        return waters;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6
    }
}