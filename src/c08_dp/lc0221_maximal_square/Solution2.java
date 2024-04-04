package c08_dp.lc0221_maximal_square;

/**
 * This is the solution of No. 221 problem in the LeetCode,
 * the website of the problem is as follows:
 * https://leetcode.com/problems/maximal-square
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example 1:
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 4
 *
 * Example 2:
 * Input: matrix = [["0","1"],["1","0"]]
 * Output: 1
 *
 * Example 3:
 * Input: matrix = [["0"]]
 * Output: 0
 *
 * Constraints:
 * - m == matrix.length
 * - n == matrix[i].length
 * - 1 <= m, n <= 300
 * - matrix[i][j] is '0' or '1'.
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: dp;
 *
 * @author  Lukas (xgp1227atgmail.com)
 */
public class Solution2 {
    public int maximalSquare(char[][] matrix) {
//        m == matrix.length
//        n == matrix[i].length
//        1 <= m, n <= 300
//        matrix[i][j] is '0' or '1'.

        // 解法2：动态规划
        // 令 dp[i][j] 表示以 matrix[i][j] 为右下角的正方形的最大边长，则有
        //            / 1, i * j = 0 and matrix[i][j] = 1
        // dp[i][j] = - min{dp[i-1][j], dp[i][j-1], dp[i-1][j-1]} + 1, i * j > 0 and matrix[i][j] = 1
        //            \ 0, others
        // 时间复杂度：O(m * n)
        // 空间复杂度：O(m * n) or O(n)

//        int m = matrix.length, n = matrix[0].length;
//        int[][] dp = new int[m+1][n+1];
//        int maxSide = 0;
//        for (int i = 0; i < m; ++i) {
//            for (int j = 0; j < n; ++j) {
//                if (matrix[i][j] == '1') {
//                    dp[i+1][j+1] = Math.min(Math.min(dp[i][j+1], dp[i+1][j]), dp[i][j]) + 1;
//                    maxSide = Math.max(maxSide, dp[i+1][j+1]);
//                }
//            }
//        }
//        return maxSide * maxSide;

        int m = matrix.length, n = matrix[0].length;
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];
        int maxSide = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '1') {
                    curr[j+1] = Math.min(Math.min(prev[j+1], curr[j]), prev[j]) + 1;
                    maxSide = Math.max(maxSide, curr[j+1]);
                } else {
                    curr[j+1] = 0;
                }
            }
            int[] tmp = prev;
            prev = curr;
            curr = tmp;
        }
        return maxSide * maxSide;
    }
}