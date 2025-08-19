package c01_array.lc0073_set_matrix_zeroes;

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
public class Solution2 {
    /**
     * Approach 2
     * 使用每一行和每一列的第一个位置作为标志，如果矩阵中某个元素为 0，则将该元素对应的行和列的第一个位置置为 0。
     * 因为矩阵的第一个位置 matrix[0][0] 的标志位重合，所以需要额外的标志位存储。下面的程序采用 matrix[0][0]
     * 作为第一个位置的行标志，采用变量 col0 作为第一个位置的列标志。
     *
     * 程序主要分为两个步骤：
     * 1. 遍历所有元素（从左到右，从上到下），根据元素的值设置标志位（Top-down）
     * 2. 再一次遍历所有元素（从右到左，从下到上），根据标志位设置元素的值（Bottom-up）
     *
     * Complexity Analysis:
     * Time Complexity: O(m * n)
     * Space Complexity: O(1)
     *
     * @param matrix int[][], the input integer matrix
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int col0 = 1;
        for (int i = 0; i < m; ++i) {
            if (matrix[i][0] == 0) {
                col0 = 0;
            }
            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 1; --j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0) {
                matrix[i][0] = 0;
            }
        }
    }
}