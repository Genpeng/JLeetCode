package c07_math_and_digit.lc0892_surface_area_of_3d_shapes;

/**
 * This is the solution of No. 892 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/surface-area-of-3d-shapes/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * On a N * N grid, we place some 1 * 1 * 1 cubes.
 *
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
 *
 * Return the total surface area of the resulting shapes.
 *
 * Example 1:
 * Input: [[2]]
 * Output: 10
 *
 * Example 2:
 * Input: [[1,2],[3,4]]
 * Output: 34
 *
 * Example 3:
 * Input: [[1,0],[0,2]]
 * Output: 16
 *
 * Example 4:
 * Input: [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 32
 *
 * Example 5:
 * Input: [[2,2,2],[2,1,2],[2,2,2]]
 * Output: 46
 *
 * Note:
 * - 1 <= N <= 50
 * - 0 <= grid[i][j] <= 50
 * ==========================================================================================================
 *
 * Tags: math;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Intuition
     * Time complexity: O(n ^ 2)
     * Space complexity: O(1)
     *
     * @param grid int[][], a grid to place cubes
     * @return int, the total surface area of the resulting shapes
     */
    public int surfaceAreaV1(int[][] grid) {
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int n = grid.length, area = 0;
        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < n; ++c) {
                int v = grid[r][c];
                if (v > 0) {
                    area += 2;
                    for (int k = 0; k < 4; ++k) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        int nv = 0;
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                            nv = grid[nr][nc];

                        }
                        area += Math.max(v - nv, 0);
                    }
                }
            }
        }
        return area;
    }

    /**
     * Approach 1: Intuition
     * Time complexity: O(n ^ 2)
     * Space complexity: O(1)
     *
     * Runtime: 2 ms, faster than 95.43% of Java online submissions for Surface Area of 3D Shapes.
     * Memory Usage: 41.1 MB, less than 100.00% of Java online submissions for Surface Area of 3D Shapes.
     *
     * @param grid int[][], a grid to place cubes
     * @return int, the total surface area of the resulting shapes
     */
    public int surfaceAreaV2(int[][] grid) {
        int n = grid.length, area = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int v = grid[i][j];
                if (v > 0) {
                    area += (v << 2) + 2;
                    area -= i > 0 ? Math.min(v, grid[i-1][j]) << 1 : 0;
                    area -= j > 0 ? Math.min(v, grid[i][j-1]) << 1 : 0;
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0}, {0, 2}};
        Solution1 solution = new Solution1();
        System.out.println(solution.surfaceAreaV2(grid));
    }
}