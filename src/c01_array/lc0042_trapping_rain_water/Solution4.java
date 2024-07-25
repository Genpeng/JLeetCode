package c01_array.lc0042_trapping_rain_water;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * This is the solution of No. 42 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/trapping-rain-water
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
public class Solution4 {
    /**
     * 解法四：单调栈（Monotonic Stack）
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param heights int[], a non-negative integer array representing elevation map
     * @return int, how much water the elevation map can trap after raining
     */
    public int trap(int[] heights) {
        if (heights == null || heights.length < 3) {
            return 0;
        }
        int waters = 0;
        final int L = heights.length;
        int i = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        while (i < L) {
            while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                int h = heights[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }
                int width = i - stack.peek() - 1;
                int height = Math.min(heights[stack.peek()], heights[i]) - h;
                waters += width * height;
            }
            stack.push(i++);
        }
        return waters;
    }

    public static void main(String[] args) {
        Solution4 solu = new Solution4();
        System.out.println(solu.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6
        System.out.println(solu.trap(new int[] {4, 2, 0, 3, 2, 5})); // 9
    }
}