package array.lc0695_max_area_of_island;

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
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    private int numRow;
    private int numCol;
    private boolean[][] seen;

    /**
     * 解法1：Recursive (DFS)
     * 时间复杂度：O(m * n)
     * 空间复杂度：O(m * n)
     *
     * Runtime: 2 ms, faster than 99.55% of Java online submissions for Max Area of Island.
     * Memory Usage: 41.5 MB, less than 85.19% of Java online submissions for Max Area of Island.
     *
     * @param grid int[][], the input 2D array which represents an island
     * @return int, the max area of squares in the island
     */
    public int maxAreaOfIsland(int[][] grid) {
        numRow = grid.length;
        numCol = grid[0].length;
        seen = new boolean[numRow][numCol];
        int maxArea = 0;
        for (int i = 0; i < numRow; ++i) {
            for (int j = 0; j < numCol; ++j) {
                maxArea = Math.max(maxArea, areaOfIsland(grid, i, j));
            }
        }
        return maxArea;
    }

    private int areaOfIsland(int[][] grid, int r, int c) {
        if (r < 0 || r >= numRow || c < 0 || c >= numCol || seen[r][c] || grid[r][c] == 0) {
            return 0;
        }
        seen[r][c] = true;
        return areaOfIsland(grid, r-1, c) +
                areaOfIsland(grid, r+1, c) +
                areaOfIsland(grid, r, c-1) +
                areaOfIsland(grid, r, c+1) + 1;
    }
}