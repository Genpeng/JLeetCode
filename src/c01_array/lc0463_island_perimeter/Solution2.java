package c01_array.lc0463_island_perimeter;

/**
 * This is the solution of No. 463 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/island-perimeter/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0
 * represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
 * and there is exactly one island (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island.
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 *
 * Example 1:
 * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * Output: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image above.
 *
 * Example 2:
 * Input: grid = [[1]]
 * Output: 4
 *
 * Example 3:
 * Input: grid = [[1,0]]
 * Output: 4
 *
 * Constraints:
 * - row == grid.length
 * - col == grid[i].length
 * - 1 <= row, col <= 100
 * - grid[i][j] is 0 or 1.
 * ==========================================================================================================
 *
 * Difficulty: Easy
 * Tags: array;dfs;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: DFS
     *
     * Complexity Analysis:
     * Time Complexity: O(m*n)
     * Space Complexity: O(m*n)
     *
     * Result of Submission:
     *
     * @param grid int[][], a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water
     * @return int, the perimeter of the island
     */
    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = m > 0 ? grid[0].length : 0;
        int perimeter = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    perimeter += islandPerimeter(grid, m, n, i, j);
                }
            }
        }
        return perimeter;
    }

    private int islandPerimeter(int[][] grid, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == 2) {
            return 0;
        }
        grid[i][j] = 2;
        return islandPerimeter(grid, m, n, i-1, j)
                + islandPerimeter(grid, m, n, i+1, j)
                + islandPerimeter(grid, m, n, i, j-1)
                + islandPerimeter(grid, m, n, i, j+1);
    }

    public static void main(String[] args) {
        int[][] grid1 = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int[][] grid2 = {{0, 0, 0, 0}, {0, 1, 1, 1}, {0, 1, 0, 1}, {0, 1, 1, 1}};
        Solution2 solu = new Solution2();
        System.out.println(solu.islandPerimeter(grid1) == 16);
        System.out.println(solu.islandPerimeter(grid2) == 16);
    }
}