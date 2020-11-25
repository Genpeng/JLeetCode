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
public class Solution3 {
    /**
     * Approach 3
     * 统计出每个数字的出现次数，然后将重复重现的数字往前 +1，直到到达最大值。
     *
     * Complexity Analysis:
     * Time Complexity: O(max{A.length, A[i]})
     * Space Complexity: O(A[i])
     *
     * Result of Submission:
     * Runtime: 2 ms, faster than 100.00% of Java online submissions for Minimum Increment to Make Array Unique.
     * Memory Usage: 46.5 MB, less than 86.30% of Java online submissions for Minimum Increment to Make Array Unique.
     *
     * @param A int, the integer array
     * @return int, the least number of moves to make every value in A unique
     */
    public int minIncrementForUnique(int[] A) {
        final int N = A.length;
        if (N <= 1) {
            return 0;
        }
        // Step 1: find out the maximum element
        int max = Integer.MIN_VALUE;
        for (int x : A) {
            max = Math.max(max, x);
        }
        // Step 2: count the number of occurrence
        int[] counts = new int[max+1];
        for (int x : A) {
            ++counts[x];
        }
        // Step 3: count the number of moves
        int moves = 0;
        for (int x = 0; x < max; ++x) {
            int t = counts[x];
            if (t > 0) {
                moves += (t - 1);
                counts[x+1] += (t - 1); // 将重复出现的数字 +1
            }
        }
        moves += counts[max] * (counts[max] - 1) * 0.5;
        return moves;
    }
}