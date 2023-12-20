package c01_array.lc0463_island_perimeter;

import java.util.ArrayDeque;
import java.util.Queue;

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
public class Solution3 {
    /**
     * 题意：
     * - 计算岛屿的周长
     * - 恰好只有一个岛屿（简化条件）
     * - 岛屿中没有湖（简化条件）
     *
     * 思路：
     * 找出所有与水接壤的边
     *
     * 解法3：BFS
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(m*n)
     *
     * @param grid int[][], a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water
     * @return int, the perimeter of the island
     */
    public int islandPerimeter(int[][] grid) {
        int[] ra = {-1, 1, 0, 0};
        int[] ca = {0, 0, -1, 1};
        int m = grid.length, n = grid[0].length;
        int perimeter = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    // 以下部分为 BFS
                    int count = 0;
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[] {i, j});
                    grid[i][j] = 2;
                    while (!q.isEmpty()) {
                        int[] p = q.poll();
                        for (int k = 0; k < 4; ++k) {
                            int r = p[0] + ra[k], c = p[1] + ca[k];
                            if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0) {
                                ++count;
                                continue;
                            }
                            if (grid[r][c] == 2) {
                                continue;
                            }
                            q.offer(new int[] {r, c});
                            grid[r][c] = 2;
                        }
                    }

                    perimeter += count;
                    break;
                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        Solution3 solu = new Solution3();
        int perimeter = solu.islandPerimeter(grid);
        System.out.println(perimeter);
    }
}