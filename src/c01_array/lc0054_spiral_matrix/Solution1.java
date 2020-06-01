package c01_array.lc0054_spiral_matrix;

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
 * Tags: array;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Simulation
     * Draw the path that the spiral makes. We know that the path should turn clockwise
     * whenever it would go out of bounds or into a cell that was previously visited.
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     *
     * Reference:
     * [1] https://leetcode.com/articles/spiral-matrix/
     *
     * Result of Submission:
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
     * Memory Usage: 37.4 MB, less than 5.21% of Java online submissions for Spiral Matrix.
     *
     * @param matrix int[][], two dimensional array
     * @return List<Integer>, the elements of the matrix in spiral order
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        if (matrix.length == 0) { // in practice, we can use `isIllegal(...)` below to judge
            return ans;
        }
        final int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0, y = 0, di = 0;
        for (int i = 0; i < R * C; ++i) {
            ans.add(matrix[x][y]);
            seen[x][y] = true;
            int nx = x + dx[di];
            int ny = y + dy[di];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C && !seen[nx][ny]) {
                x = nx;
                y = ny;
            } else {
                di = (di + 1) % 4;
                x = x + dx[di];
                y = y + dy[di];
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