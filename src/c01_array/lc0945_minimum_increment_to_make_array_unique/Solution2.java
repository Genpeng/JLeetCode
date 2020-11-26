package c01_array.lc0945_minimum_increment_to_make_array_unique;

import java.util.Arrays;

/**
 * This is the solution of No. 945 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/minimum-increment-to-make-array-unique/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.
 *
 * Return the least number of moves to make every value in A unique.
 *
 * Example 1:
 * Input: [1,2,2]
 * Output: 1
 * Explanation:  After 1 move, the array could be [1, 2, 3].
 *
 * Example 2:
 * Input: [3,2,1,2,1,7]
 * Output: 6
 * Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
 * It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
 *
 * Note:
 * - 0 <= A.length <= 40000
 * - 0 <= A[i] < 40000
 * ==========================================================================================================
 *
 * Tags: array;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2
     * 思路与方法一是一致的，只是为了不用再去统计数字出现的次数，直接对整个数组进行排序。
     *
     * Complexity Analysis:
     * Time Complexity: O(N * log(N))
     * Space Complexity: O(log(N))
     *
     * Result of Submission:
     * Runtime: 14 ms, faster than 36.61% of Java online submissions for Minimum Increment to Make Array Unique.
     * Memory Usage: 46.1 MB, less than 100.00% of Java online submissions for Minimum Increment to Make Array Unique.
     *
     * @param A int, the integer array
     * @return int, the least number of moves to make every value in A unique
     */
    public int minIncrementForUniqueV0(int[] A) {
        int n = A.length;
        if (n <= 1) {
            return 0;
        }
        Arrays.sort(A);
        int moves = 0, duplicates = 0;
        for (int i = 1; i < n; ++i) {
            if (A[i-1] == A[i]) {
                ++duplicates;
                moves -= A[i];
            } else if (duplicates > 0) {
                int span = Math.min(duplicates, A[i] - A[i-1] - 1);
                duplicates -= span;
                moves += A[i-1] * span + span * (span + 1) * 0.5;
            }
        }
        if (duplicates > 0) {
            moves += A[n - 1] * duplicates + duplicates * (duplicates + 1) * 0.5;
        }
        return moves;
    }

    /**
     * Approach 2: Sort
     * Time Complexity: O(N * log(N))
     * Space Complexity: O(log(N))
     *
     * Runtime: 13 ms, faster than 63.16% of Java online submissions for Minimum Increment to Make Array Unique.
     * Memory Usage: 46.1 MB, less than 100.00% of Java online submissions for Minimum Increment to Make Array Unique.
     *
     * @param A int, the integer array
     * @return int, the least number of moves to make every value in A unique
     */
    public int minIncrementForUniqueV1(int[] A) {
        if (A.length <= 1) {
            return 0;
        }
        Arrays.sort(A);
        int moves = 0;
        for (int i = 1; i < A.length; ++i) {
            if (A[i-1] >= A[i]) {
                moves += (A[i-1] - A[i] + 1);
                A[i] = A[i-1] + 1;
            }
        }
        return moves;
    }
}