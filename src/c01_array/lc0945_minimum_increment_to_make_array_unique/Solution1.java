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
     * Approach 1
     * - 统计每个数字出现的次数
     * - 对于重复出现的数字，先从 moves 中减去，之后遇到一个没有出现过的数字再加上该数字
     *
     * Complexity Analysis:
     * Time Complexity: O(L)
     * Space Complexity: O(L)
     * where L represents `max(A) + A.length`
     *
     * Result of Submission:
     * Runtime: 19 ms, faster than 28.89% of Java online submissions for Minimum Increment to Make Array Unique.
     * Memory Usage: 65.2 MB, less than 16.67% of Java online submissions for Minimum Increment to Make Array Unique.
     *
     * @param A int, the integer array
     * @return int, the least number of moves to make every value in A unique
     */
    public int minIncrementForUnique(int[] A) {
        int n = A.length;
        if (n <= 1) {
            return 0;
        }
        // Step 1: count the number of occurrences of each element
        int[] counts = new int[80000];
        for (int x : A) {
            ++counts[x];
        }
        // Step 2: count the number of moves
        int moves = 0, duplicates = 0;
        for (int x = 0; x < 80000; ++x) {
            int t = counts[x];
            if (t > 1) {
                duplicates += (t - 1);
                moves -= (t - 1) * x;
            } else if (t == 0 && duplicates > 0) {
                moves += x;
                --duplicates;
            }
        }
        return moves;
    }
}