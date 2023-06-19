package c01_array.lc0827_making_a_large_island;

/**
 * This is the solution of No. 827 problem in the LeetCode,
 * the website of the problem is as follows:
 * https://leetcode.com/problems/making-a-large-island/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
 *
 * Return the size of the largest island in grid after applying this operation.
 *
 * An island is a 4-directionally connected group of 1s.
 *
 * Example 1:
 * Input: grid = [[1,0],[0,1]]
 * Output: 3
 * Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
 *
 * Example 2:
 * Input: grid = [[1,1],[1,0]]
 * Output: 4
 * Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
 *
 * Example 3:
 * Input: grid = [[1,1],[1,1]]
 * Output: 4
 * Explanation: Can't change any 0 to 1, only one island with area = 4.
 *
 * Constraints:
 * - n == grid.length
 * - n == grid[i].length
 * - 1 <= n <= 500
 * - grid[i][j] is either 0 or 1.
 * ==========================================================================================================
 *
 * Difficulty: Hard
 * Tags: array; bfs; dfs;
 *
 * @author  Lukas (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * 解法1：
     * 采用 DFS 的方法标记岛屿并统计岛屿的数量，之后遍历每个海洋格子，查看其四个方向上是否有相邻岛屿，
     * 并将所有相邻岛屿的面积求和，更新当前最大的岛屿面积
     *
     * Complexity Analysis:
     * - Time Complexity: O(n^2)
     * - Space Complexity: O(n^2)
     *
     * @param grid int[][], an n x n binary matrix grid
     * @return int, the size of the largest island in grid after change at most one 0 to be 1
     */
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        // 第一次遍历，标记岛屿，并统计岛屿的面积
        int[] count = new int[n*n+2];
        int tag = 2;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, tag, count);
                    ++tag;
                }
            }
        }
        // 第二次遍历，遍历所有海洋格子，对于每个海洋格子，检查其相邻四个方向
        int maxArea = 0;
        for (int k : count) {
            maxArea = Math.max(maxArea, k);
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    int up = i-1 >= 0 ? grid[i-1][j] : 0;
                    int down = i+1 < n ? grid[i+1][j] : 0;
                    int left = j-1 >= 0 ? grid[i][j-1] : 0;
                    int right = j+1 < n ? grid[i][j+1] : 0;
                    int area = count[up] + 1;
                    if (down != up) {
                        area += count[down];
                    }
                    if (left != up && left != down) {
                        area += count[left];
                    }
                    if (right != up && right != down && right != left) {
                        area += count[right];
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private void dfs(int[][] grid, int i, int j, int tag, int[] count) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = tag; // 标记岛屿
        ++count[tag]; // 统计岛屿的面积
        dfs(grid, i+1, j, tag, count);
        dfs(grid, i-1, j, tag, count);
        dfs(grid, i, j+1, tag, count);
        dfs(grid, i, j-1, tag, count);
    }
}