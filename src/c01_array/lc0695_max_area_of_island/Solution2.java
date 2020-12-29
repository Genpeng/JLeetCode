package c01_array.lc0695_max_area_of_island;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is the solution of No. 695 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/max-area-of-island/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of
 * the grid are surrounded by water.
 *
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 *
 * Example 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 *
 * Example 2:
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 *
 * Note: The length of each dimension in the given grid does not exceed 50.
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: array;dfs;bfs;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: BFS (Iterative)
     *
     * Complexity Analysis:
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     *
     * Result of Submission:
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Max Area of Island.
     * Memory Usage: 39.7 MB, less than 39.64% of Java online submissions for Max Area of Island.
     *
     * @param grid int[][], the input 2D array
     * @return int, the max area of squares in the island
     */
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = m > 0 ? grid[0].length : 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int maxArea = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    int area = 1;
                    grid[i][j] = 2;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[] {i, j});
                    while (!q.isEmpty()) {
                        int[] pos = q.poll();
                        for (int k = 0; k < 4; ++k) {
                            int nr = pos[0] + dr[k], nc = pos[1] + dc[k];
                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                                q.offer(new int[] {nr, nc});
                                ++area;
                                grid[nr][nc] = 2;
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}