package c01_array.lc0994_rotting_oranges;

import java.util.*;

/**
 * This is the solution of No. 994 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/rotting-oranges/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * In a given grid, each cell can have one of three values:
 * <p>
 * - the value 0 representing an empty cell;
 * - the value 1 representing a fresh orange;
 * - the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 * <p>
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 * If this is impossible, return -1 instead.
 * <p>
 * Example 1:
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * <p>
 * Example 2:
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting
 * only happens 4-directionally.
 * <p>
 * Example 3:
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 * <p>
 * Note:
 * - 1 <= grid.length <= 10
 * - 1 <= grid[0].length <= 10
 * - grid[i][j] is only 0, 1, or 2.
 * ==========================================================================================================
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: BFS
     * 时间复杂度：O(m * n)
     * 空间复杂度：O(m * n)
     *
     * Runtime: 3 ms, faster than 75.83% of Java online submissions for Rotting Oranges.
     * Memory Usage: 38.5 MB, less than 81.25% of Java online submissions for Rotting Oranges.
     *
     * @param grid int[][], the input two dimensional array
     * @return int, the minimum number of minutes that must elapse until no cell has a fresh orange
     */
    public int orangesRotting(int[][] grid) {
        int nRow = grid.length, nCol = grid[0].length;
        // 步骤1：遍历整个 grid，将腐烂的橘子放入队列中，并记录新鲜橘子的数目
        Queue<int[]> q = new LinkedList<>();
        int nFresh = 0;
        for (int i = 0; i < nRow; ++i) {
            for (int j = 0; j < nCol; ++j) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    ++nFresh;
                }
            }
        }
        if (nFresh == 0) {
            return 0;
        }
        // 步骤2：一层一层地往下"腐烂"，直至没有新鲜的橘子，并记录腐烂的次数
        int nRotting = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int n = q.size();
            while (n-- > 0) {
                int[] point = q.poll();
                for (int[] dir: dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    if (x < 0 || x >= nRow || y < 0 || y >= nCol || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }
                    grid[x][y] = 2;
                    --nFresh;
                    q.offer(new int[] {x, y});
                }
            }
            ++nRotting;
        }
        // 为什么是 `nRotting - 1`？
        // 因为最后一次腐烂之后，还会把腐烂的橘子放入队列中，但是此时已经没有橘子可以腐烂了，使得 nRotting 的次数多了一次。
        return nFresh == 0 ? nRotting - 1 : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        Solution1 solution = new Solution1();
        System.out.println(solution.orangesRotting(grid));
    }
}