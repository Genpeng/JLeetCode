package c01_array.lc0059_spiral_matrix_ii;

/**
 * This is the solution of No. 59 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/spiral-matrix-ii/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.
 *
 * Example:
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * ==========================================================================================================
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution {
    /**
     * 解法：Layer-by-Layer
     * 时间复杂度：O(n ^ 2)
     * 空间复杂度：O(1)
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix II.
     * Memory Usage: 37.6 MB, less than 8.33% of Java online submissions for Spiral Matrix II.
     *
     * @param n int, the width and height of the matrix
     * @return int[][], the square matrix
     */
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[][] {};
        }
        int currElem = 1;
        int r1 = 0, c1 = 0;
        int r2 = n - 1, c2 = n - 1;
        int[][] matrix = new int[n][n];
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; ++c) {
                matrix[r1][c] = currElem++;
            }
            for (int r = r1 + 1; r <= r2; ++r) {
                matrix[r][c2] = currElem++;
            }
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; --c) {
                    matrix[r2][c] = currElem++;
                }
                for (int r = r2; r > r1; --r) {
                    matrix[r][c1] = currElem++;
                }
            }
            ++r1;
            ++c1;
            --r2;
            --c2;
        }
        return matrix;
    }
}