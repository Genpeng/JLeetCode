package c01_array.lc0200_number_of_islands;

/**
 * This is the solution of No. 200 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/number-of-islands/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 *
 * Example 2:
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: bfs;dfs;union find;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: DFS
     *
     * Complexity Analysis:
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     *
     * Result of Submission:
     * Runtime: 1 ms, faster than 99.99% of Java online submissions for Number of Islands.
     * Memory Usage: 41.4 MB, less than 66.75% of Java online submissions for Number of Islands.
     *
     * @param grid char[][], a 2d grid map of '1's (land) and '0's (water)
     * @return int, the number of islands
     */
    public int numIslands(char[][] grid) {
        int m = grid.length, n = m > 0 ? grid[0].length : 0;
        int count = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    ++count;
                    eraseIslands(grid, m, n, i, j);
                }
            }
        }
        return count;
    }

    private void eraseIslands(char[][] grid, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        eraseIslands(grid, m, n, i-1, j);
        eraseIslands(grid, m, n, i+1, j);
        eraseIslands(grid, m, n, i, j-1);
        eraseIslands(grid, m, n, i, j+1);
    }
}