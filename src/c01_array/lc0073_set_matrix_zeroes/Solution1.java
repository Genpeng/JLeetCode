package c01_array.lc0073_set_matrix_zeroes;

import java.util.HashSet;
import java.util.Set;

/**
 * This is the solution of No. 73 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/set-matrix-zeroes
 * <p>
 * The description of problem is as follows:
 * ==========================================================================================================
 * Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.
 * <p>
 * Follow up:
 * - A straight forward solution using O(mn) space is probably a bad idea.
 * - A simple improvement uses O(m + n) space, but still not the best solution.
 * - Could you devise a constant space solution?
 * <p>
 * Example 1:
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * <p>
 * Example 2:
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * <p>
 * Constraints:
 * - m == matrix.length
 * - n == matrix[0].length
 * - 1 <= m, n <= 200
 * - -2^31 <= matrix[i][j] <= 2^31 - 1
 * ==========================================================================================================
 * <p>
 * Difficulty: Medium
 * Tags: array;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * 解法1：借助辅助容器
     * 时间复杂度：O(m * n)
     * 空间复杂度：O(m + n)
     *
     * @param matrix int[][], the input integer matrix
     */
    public void setZeroes(int[][] matrix) {
        // 题意：
        // 输入一个整数数组，如果数组中的某个位置为 0，则该位置对应的行和列都设置为 0

        // 解法1：借助辅助容器
        // 时间复杂度：O(m * n)
        // 空间复杂度：O(m + n)

        int m = matrix.length, n = matrix[0].length;

        // 步骤1：记录值为 0 的行和列
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        // 步骤2：将需要置 0 的行和列置为 0
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}