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
public class Solution1 {
    /**
     * Approach 1: Brute Force
     * 这种解法的思路是，对于每一块陆地，统计它4条边有多少条是超出边界或者与水相邻，统计满足条件的边的数量，
     * 最终所有满足的边的数量就是岛屿的周长。
     *
     * Complexity Analysis:
     * Time Complexity: O(m*n)
     * Space Complexity: O(1)
     *
     * Result of Submission:
     * Runtime: 6 ms, faster than 58.62% of Java online submissions for Island Perimeter.
     * Memory Usage: 39.6 MB, less than 99.24% of Java online submissions for Island Perimeter.
     *
     * @param grid int[][], a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water
     * @return int, the perimeter of the island
     */
    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = m > 0 ? grid[0].length : 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int perimeter = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0; k < 4; ++k) {
                        int r = i + dr[k], c = j + dc[k];
                        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0) {
                            ++cnt;
                        }
                    }
                    perimeter += cnt;
                }
            }
        }
        return perimeter;
    }

    /**
     * 解法1：迭代
     * 遍历网格中的每一个格子的四条边，当边满足以下任意一个条件时，边是岛屿周长的一部分
     * 1. 边位于网格的边缘，即 r < 0 || r >= m || c < 0 || c >= n
     * 2. 毗邻海水，grid[r][c] = 0
     * 其中，r 表示格子的横坐标，而 c 表示格子的纵坐标
     *
     * Complexity Analysis:
     * Time Complexity: O(m*n)
     * Space Complexity: O(1)
     *
     * @param grid int[][], a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water
     * @return int, the perimeter of the island
     */
    public int islandPerimeterV2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int perimeter = 0;
        int[] ra = new int[] {1, -1, 0, 0};
        int[] ca = new int[] {0, 0, 1, -1};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; ++k) {
                        int r = i + ra[k], c = j + ca[k];
                        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0) {
                            ++perimeter;
                        }
                    }
                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        int[][] grid1 = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int[][] grid2 = {{0, 0, 0, 0}, {0, 1, 1, 1}, {0, 1, 0, 1}, {0, 1, 1, 1}};
        Solution1 solu = new Solution1();
        System.out.println(solu.islandPerimeter(grid1) == 16);
        System.out.println(solu.islandPerimeter(grid2) == 16);
    }
}