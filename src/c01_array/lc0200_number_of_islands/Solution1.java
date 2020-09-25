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
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length, nc = grid[0].length;
        int count = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                dfs(grid, r, c);
                ++count;
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        int nr = grid.length, nc = grid[0].length;
        if (r < 0 || r >= nr || c < 0 || c >= nc) {
            return;
        }
        grid[r][c] = 0;
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
    }

    public static void main(String[] args) {
        int[][] grid = {{}};
        System.out.println(grid.length);
        System.out.println(grid[0].length);
    }
}