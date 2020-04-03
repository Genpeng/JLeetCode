package c01_array.lc1162_as_far_from_land_as_possible;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is the solution of No. 1162 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/as-far-from-land-as-possible/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an N x N grid containing only values 0 and 1, where 0 represents water and 1 represents land,
 * find a water cell such that its distance to the nearest land cell is maximized and return the distance.
 *
 * The distance used in this problem is the Manhattan distance: the distance between two cells
 * (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 *
 * If no land or water exists in the grid, return -1.
 *
 * Example 1:
 * Input: [[1,0,1],[0,0,0],[1,0,1]]
 * Output: 2
 * Explanation:
 * The cell (1, 1) is as far as possible from all the land with distance 2.
 *
 * Example 2:
 * Input: [[1,0,0],[0,0,0],[0,0,0]]
 * Output: 4
 * Explanation:
 * The cell (2, 2) is as far as possible from all the land with distance 4.
 *
 * Note:
 * - 1 <= grid.length == grid[0].length <= 100
 * - grid[i][j] is 0 or 1
 * ==========================================================================================================
 *
 * Tags: array;bfs;dp;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: BFS
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     *
     * Runtime: 12 ms, faster than 88.04% of Java online submissions for As Far from Land as Possible.
     * Memory Usage: 41 MB, less than 100.00% of Java online submissions for As Far from Land as Possible.
     *
     * @param grid int[][], an island 0 represents water and 1 represents land
     * @return int, the maximized distance from a water cell to its nearest land cell
     */
    public int maxDistance(int[][] grid) {
        int n = grid.length; // 1 <= grid.length == grid[0].length <= 100
        if (n == 1) {
            return -1;
        }
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    q.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }
        if (q.size() == n * n || q.size() == 0) { // no land or water exists in the grid
            return -1;
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] point = q.poll();
                int x = point[0];
                int y = point[1];
                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY]) {
                        q.offer(new int[] {newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
            ++level;
        }
        return level - 1;
    }
}