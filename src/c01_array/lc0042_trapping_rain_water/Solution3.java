package c01_array.lc0042_trapping_rain_water;

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
public class Solution3 {
    /**
     * 解法三：双指针（Two Pointers）
     * 思路：解法三是在解法二的基础上继续进行优化，由于当前位置左边和右边的最大高度只使用一次，
     * 因此可以使用两个变量来保存（代替两个 dp 数组）
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @param heights int[], a non-negative integer array representing elevation map
     * @return int, how much water the elevation map can trap after raining
     */
    public int trap(int[] heights) {
        if (heights == null || heights.length < 3) {
            return 0;
        }
        int waters = 0; // 可以接到的雨水总量
        final int L = heights.length;
        int li = 1, ri = L - 2;
        // leftMax 和 rightMax 分别表示在当前位置左边和右边的最大高度（不包括当前位置）
        int leftMax = heights[0], rightMax = heights[L-1];
        while (li <= ri) {
            // 当前位置「左边最大高度」小于等于「右边最大高度」，当前位置可以接的雨水量由「左边最大高度」决定
            if (leftMax <= rightMax) {
                if (heights[li] > leftMax) {
                    // 如果当前高度大于「左边最大高度」，接不到雨水（漏了）
                    leftMax = heights[li];
                } else if (heights[li] < leftMax) {
                    waters += (leftMax - heights[li]);
                }
                ++li;
            } else {
                if (heights[ri] > rightMax) {
                    rightMax = heights[ri];
                } else if (heights[ri] < rightMax) {
                    waters += (rightMax - heights[ri]);
                }
                --ri;
            }
        }
        return waters;
    }

    public int trapV2(int[] heights) {
        // 这道题可以提两个问题：
        // 1. heights[li] < heights[ri] 这个条件判断的作用是什么？
        // 答：判断次小的一方在左边还是在右边。条件中值较大的一方表示目前为止遍历过的所有位置的最大高度，
        //    即次小高度在条件取值较小的一方中。
        // 2. 最外层的条件（li < ri），为什么是小于？可以是小于等于吗？（如果是小于，其实有一个位置没有遍历）
        // 答：因为当 li = ri 时，此时处于全局最大高度，最大高度是无法储水的，没有必要；可以是小于等于。
        if (heights == null || heights.length < 3) {
            return 0;
        }
        final int L = heights.length;
        int waters = 0;
        int li = 0, ri = L - 1;
        // leftMax 和 rightMax 分别表示在当前位置左边和右边的最大高度（不包括当前位置）
        int leftMax = 0, rightMax = 0;
        while (li < ri) {
            // heights[li] 和 heights[ri] 中不需要移动的一方表示当前所有遍历过的位置中的最大高度，
            // 因此次小的高度就在需要移动的一方中
            if (heights[li] < heights[ri]) {
                if (heights[li] >= leftMax) {
                    leftMax = heights[li];
                } else {
                    waters += (leftMax - heights[li]);
                }
                ++li;
            } else {
                if (heights[ri] >= rightMax) {
                    rightMax = heights[ri];
                } else {
                    waters += (rightMax - heights[ri]);
                }
                --ri;
            }
        }
        return waters;
    }

    public static void main(String[] args) {
        Solution3 solu = new Solution3();
        System.out.println(solu.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6
    }
}