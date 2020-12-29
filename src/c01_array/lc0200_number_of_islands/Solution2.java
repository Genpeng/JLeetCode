package c01_array.lc0200_number_of_islands;

import entity.Pair;

import java.util.LinkedList;
import java.util.Queue;

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
public class Solution2 {
    /**
     * Approach 2: BFS
     *
     * Complexity Analysis:
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     *
     * @param grid char[][], a 2d grid map of '1's (land) and '0's (water)
     * @return int, the number of islands
     */
    public int numIslands(char[][] grid) {
        int m = grid.length, n = m > 0 ? grid[0].length : 0;
        int count = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    ++count;
                    // BFS
                    grid[i][j] = '2';
                    Queue<Pair<Integer, Integer>> q = new LinkedList<>();
                    q.offer(new Pair<>(i, j));
                    while (!q.isEmpty()) {
                        Pair<Integer, Integer> pair = q.poll();
                        for (int k = 0; k < 4; ++k) {
                            int r = pair.first + dr[k], c = pair.second + dc[k];
                            if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1') {
                                grid[r][c] = '2';
                                q.offer(new Pair<>(r, c));
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution2 solu = new Solution2();
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(solu.numIslands(grid));
    }
}