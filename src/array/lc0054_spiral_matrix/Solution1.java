package array.lc0054_spiral_matrix;

import java.util.LinkedList;
import java.util.List;

/**
 * This is the solution of No. 54 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/spiral-matrix/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * Example 1:
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * <p>
 * Example 2:
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * ==========================================================================================================
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * 解法1（Simulation）
     * 时间复杂度：O(m * n)
     * 空间复杂度：O(m * n)
     * <p>
     * 备注：
     * - 参照官方解答1（https://leetcode.com/articles/spiral-matrix/）
     * <p>
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
     * Memory Usage: 37.4 MB, less than 5.21% of Java online submissions for Spiral Matrix.
     *
     * @param matrix int[][], two dimensional array
     * @return List<Integer>, the elements of the matrix in spiral order
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        if (isIllegal(matrix)) {
            return ans;
        }
        int rowNum = matrix.length, colNum = matrix[0].length; // number of rows, number of columns
        int[] rowDirs = new int[]{0, 1, 0, -1};
        int[] colDirs = new int[]{1, 0, -1, 0};
        boolean[][] seen = new boolean[rowNum][colNum];
        int ri = 0, ci = 0, di = 0;
        for (int i = 0; i < rowNum * colNum; ++i) {
            ans.add(matrix[ri][ci]);
            seen[ri][ci] = true;
            int nri = ri + rowDirs[di], nci = ci + colDirs[di]; // next row index, next column index
            if (nri >= 0 && nri < rowNum && nci >= 0 && nci < colNum && !seen[nri][nci]) {
                ri = nri;
                ci = nci;
            } else {
                di = (di + 1) % 4;
                ri = ri + rowDirs[di];
                ci = ci + colDirs[di];
            }
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
        Solution1 solution = new Solution1();
        System.out.println("[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]");
        System.out.println(solution.spiralOrder(matrix));
    }
}