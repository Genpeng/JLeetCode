package c08_dp.lc0063_unique_paths_ii;

/**
 * This is the solution of No. 63 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/unique-paths-ii/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach
 * the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Note:
 * - m and n will be at most 100.
 *
 * Example 1:
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: array;dp;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Dynamic Programming
     * Suppose dp[i][j] represents the number of unique paths starting from (0, 0) to (i, j),
     * the state transition equation can be written as follow:
     *            / dp[i-1][j] + dp[i][j-1], i * j > 0 and o[i][j] = 0
     * dp[i][j] = - 1, i = 0, V 0 <= k <= j, o[0][k] = 0
     *            \ 1, j = 0, V 0 <= k <= i, o[k][0] = 0
     *            \ 0, others
     *
     * @param obstacleGrid int[][], a two dimensional array used to represents obstacle grid
     * @return int, the number of unique paths
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; ++i) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; ++j) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        Solution1 solu = new Solution1();
        System.out.println(solu.uniquePathsWithObstacles(obstacleGrid) == 2);
    }
}