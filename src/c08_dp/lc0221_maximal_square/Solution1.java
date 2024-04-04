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
public class Solution1 {
    public int maximalSquare(char[][] matrix) {
        // 解法1：暴力法
        // 时间复杂度：O(m * n * min(m, n)^2)
        // 空间复杂度：O(1)

        int m = matrix.length, n = matrix[0].length;
        int maxSide = 0; // 最大边长
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '1') {
                    maxSide = Math.max(maxSide, 1);
                    int upper = Math.min(m-i, n-j);
                    for (int k = 1; k < upper; ++k) {
                        if (matrix[i+k][j+k] == '0') {
                            break;
                        }
                        boolean flag = true;
                        for (int a = 0; a < k; ++a) {
                            if (matrix[i+k][j+a] == '0' || matrix[i+a][j+k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            maxSide = Math.max(maxSide, k+1);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return maxSide * maxSide;
    }
}