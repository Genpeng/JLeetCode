package c01_array.lc0240_search_a_2d_matrix_ii;

/**
 * This is the solution of No. 240 problem in the LeetCode,
 * the website of the problem is as follows:
 * https://leetcode.com/problems/search-a-2d-matrix-ii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
 * This matrix has the following properties:
 * <p>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * <p>
 * Example 1:
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * Output: true
 * <p>
 * Example 2:
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * Output: false
 * <p>
 * Constraints:
 * - m == matrix.length
 * - n == matrix[i].length
 * - 1 <= n, m <= 300
 * - -10^9 <= matrix[i][j] <= 10^9
 * - All the integers in each row are sorted in ascending order.
 * - All the integers in each column are sorted in ascending order.
 * - -10^9 <= target <= 10^9
 * ==========================================================================================================
 * <p>
 * Difficulty: Medium
 * Tags: array;binary-search;
 *
 * @author Lukas (xgp1227atgmail.com)
 */
public class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 题意：
        // 已知一个二维矩阵 matrix，判断二维矩阵中是否存在目标值 target
        // 二维矩阵有以下两个性质：
        // - 每行的元素从左到右升序排列
        // - 每列的元素从上到下升序排列

        // 解法2：二分查找
        // 时间复杂度：O(m * log(n))
        // 空间复杂度：O(1)

        int m = matrix.length, n = matrix[0].length;
        for (int[] row : matrix) {
            int index = binarySearch(row, target);
            if (index != -1) {
                return true;
            }
        }
        return false;
    }

    private int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        final int n = nums.length;
        if (target < nums[0] || target > nums[n-1]) {
            return -1;
        }
        int li = 0, ri = n-1;
        while (li <= ri) {
            int mi = li + ((ri-li) >> 1);
            if (nums[mi] == target) {
                return mi;
            } else if (nums[mi] < target) {
                li = mi + 1;
            } else {
                ri = mi - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        matrix[0] = new int[] {1,  2,  3,  4,  5};
        matrix[1] = new int[] {6,  7,  8,  9,  10};
        matrix[2] = new int[] {11, 12, 13, 14, 15};
        matrix[3] = new int[] {16, 17, 18, 19, 20};
        matrix[4] = new int[] {21, 22, 23, 24, 25};
        int target = 19;
        Solution2 solu = new Solution2();
        System.out.println(solu.searchMatrix(matrix, target));
    }
}