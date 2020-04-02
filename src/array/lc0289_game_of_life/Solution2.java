package array.lc0289_game_of_life;

import java.util.Arrays;

/**
 * This is the solution of No. 289 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/game-of-life/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton
 * devised by the British mathematician John Horton Conway in 1970."
 *
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using
 * the following four rules (taken from the above Wikipedia article):
 * 1. Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * 2. Any live cell with two or three live neighbors lives on to the next generation.
 * 3. Any live cell with more than three live neighbors dies, as if by over-population..
 * 4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 *
 * Write a function to compute the next state (after one update) of the board given its current state. 
 * The next state is created by applying the above rules simultaneously to every cell in the current state,
 * where births and deaths occur simultaneously.
 *
 * Example:
 * Input:
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * Output:
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 *
 * Follow up:
 * - Could you solve it in-place? Remember that the board needs to be updated at the same time:
 *   You cannot update some cells first and then use their updated values to update other cells.
 * - In this question, we represent the board using a 2D array. In principle, the board is infinite,
 *   which would cause problems when the active area encroaches the border of the array.
 *   How would you address these problems?
 * ==========================================================================================================
 *
 * Tags: array;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    private int m, n;

    /**
     * Approach 2: Slightly modify the rule
     * board[i][j] = -1 if board[i][j] from 1 to 0
     * board[i][j] = 2 if board[i][j] from 0 to 1
     *
     * Time Complexity: O(m, n)
     * Space Complexity: O(1)
     *
     * @param board int[][], a board with m by n cells
     */
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                MoveToNextState(board, i, j);
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] > 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }

    private void MoveToNextState(int[][] board, int i, int j) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {-1, -1}, {1, -1}};
        int lives = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && Math.abs(board[x][y]) == 1) {
                ++lives;
            }
        }
        if ((board[i][j] == 1) && (lives < 2 || lives > 3)) {
            board[i][j] = -1;
        } else if ((board[i][j] == 0) && (lives == 3)) {
            board[i][j] = 2;
        }
    }

    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        Solution2 solution = new Solution2();
        System.out.println(Arrays.deepToString(board));
        solution.gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }
}