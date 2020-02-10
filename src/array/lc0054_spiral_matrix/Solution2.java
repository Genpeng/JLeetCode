package array.lc0054_spiral_matrix;

import java.util.LinkedList;
import java.util.List;

/**
 * This is the solution of No. 54 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/spiral-matrix/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * ==========================================================================================================
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * 解法2（Layer-by-Layer）
     * 时间复杂度：O(m * n)
     * 空间复杂度：O(1)
     *
     * 备注：
     * - 参照官方解答2（https://leetcode.com/articles/spiral-matrix/）
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
     * Memory Usage: 37.9 MB, less than 5.21% of Java online submissions for Spiral Matrix.
     *
     * @param matrix int[][], two dimensional array
     * @return List<Integer>, the elements of the matrix in spiral order
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        if (isIllegal(matrix)) {
            return ans;
        }
        int rowNum = matrix.length, colNum = matrix[0].length;
        int r1 = 0, c1 = 0;
        int r2 = rowNum - 1, c2 = colNum - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; ++c) {
                ans.add(matrix[r1][c]);
            }
            for (int r = r1 + 1; r <= r2; ++r) {
                ans.add(matrix[r][c2]);
            }
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; --c) {
                    ans.add(matrix[r2][c]);
                }
                for (int r = r2; r > r1; --r) {
                    ans.add(matrix[r][c1]);
                }
            }
            ++r1;
            ++c1;
            --r2;
            --c2;
        }
        return ans;
    }

    /**
     * Judge a matrix array is illegal.
     *
     * @param matrix int[][], two dimensional array
     * @return boolean, true if the input matrix is illegal
     */
    private boolean isIllegal(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return true;
        }
        int cn = matrix[0].length;
        for (int i = 1; i < matrix.length; ++i) {
            if (matrix[i].length != cn) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] row1 = new int[] {1, 2, 3, 4};
        int[] row2 = new int[] {5, 6, 7, 8};
        int[] row3 = new int[] {9, 10, 11, 12};
        int[][] matrix = new int[][]{row1, row2, row3};
        Solution2 solution = new Solution2();
        System.out.println("[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]");
        System.out.println(solution.spiralOrder(matrix));
    }
}