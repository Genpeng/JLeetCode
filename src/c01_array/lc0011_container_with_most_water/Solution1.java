package c01_array.lc0011_container_with_most_water;

/**
 * This is the solution of No. 11 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/container-with-most-water/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 * <img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg">
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case,
 * the max area of water (blue section) the container can contain is 49.
 *
 * Example:
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * ==========================================================================================================
 *
 * Tags: two pointers;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Brute Force
     * Time Complexity: O(n ^ 2)
     * Space Complexity: O(1)
     *
     * Result of Submission:
     * Runtime: 350 ms, faster than 8.05% of Java online submissions for Container With Most Water.
     * Memory Usage: 40.9 MB, less than 23.72% of Java online submissions for Container With Most Water.
     *
     * @param heights int[], the input integer array which represents the lengths of the rectangle
     * @return int, the max area of the container
     */
    public int maxArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                maxArea = Math.max(maxArea, Math.min(heights[i], heights[j]) * (j - i));
            }
        }
        return maxArea;
    }
}