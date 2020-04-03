package c01_array.lc0945_minimum_increment_to_make_array_unique;

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
public class Solution1 {
    /**
     * Approach 1: Counting
     * Time Complexity: O(L)
     * Space Complexity: O(L)
     * where L represents `max(A) + A.length`
     *
     * Runtime: 19 ms, faster than 28.89% of Java online submissions for Minimum Increment to Make Array Unique.
     * Memory Usage: 65.2 MB, less than 16.67% of Java online submissions for Minimum Increment to Make Array Unique.
     *
     * @param A int, the integer array
     * @return int, the least number of moves to make every value in A unique
     */
    public int minIncrementForUnique(int[] A) {
        if (A.length <= 1) {
            return 0;
        }
        int[] counts = new int[80000];
        for (int x : A) {
            ++counts[x];
        }
        int moves = 0, duplicated = 0;
        for (int x = 0; x < counts.length; ++x) {
            if (counts[x] >= 2) {
                duplicated += (counts[x] - 1);
                moves -= x * (counts[x] - 1);
            } else if (duplicated > 0 && counts[x] == 0) {
                moves += x;
                --duplicated;
            }
        }
        return moves;
    }
}