package c01_array.lc0073_set_matrix_zeroes;

import java.util.HashSet;
import java.util.Set;

/**
 * This is the solution of No. 73 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/set-matrix-zeroes/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Follow up:
 * - A straight forward solution using O(mn) space is probably a bad idea.
 * - A simple improvement uses O(m + n) space, but still not the best solution.
 * - Could you devise a constant space solution?
 *
 *
 * Example 1:
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 *
 * Example 2:
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * Constraints:
 * - m == matrix.length
 * - n == matrix[0].length
 * - 1 <= m, n <= 200
 * - -231 <= matrix[i][j] <= 231 - 1
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: array;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1
     * 借助额外的空间记录需要置零的所有行和列
     *
     * Complexity Analysis:
     * Time Complexity: O(m * n)
     * Space Complexity: O(m + n)
     *
     * Result of submission:
     * Runtime: 2 ms, faster than 33.70% of Java online submissions for Set Matrix Zeroes.
     * Memory Usage: 40.5 MB, less than 9.10% of Java online submissions for Set Matrix Zeroes.
     *
     * @param matrix int[][], the input integer matrix
     */
    public void setZeroes(int[][] matrix) {
        final int R = matrix.length, C = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}