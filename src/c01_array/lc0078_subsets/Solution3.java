package c01_array.lc0078_subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This is the solution of No. 78 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/subsets/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: array;backtracking;bit manipulation;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution3 {
    /**
     * Approach 3: Bit Manipulation
     * The idea is to represent all the combinations by using binary representation,
     * and for each binary representation, 1 stands for in and 0 stands for not in.
     *
     * Complexity Analysis:
     * Time Complexity: O(N * 2^N)
     * Space Complexity: O(N * 2^N)
     *
     * Result of Submission:
     * Runtime: 2 ms, faster than 18.99% of Java online submissions for Subsets.
     * Memory Usage: 39.8 MB, less than 45.46% of Java online submissions for Subsets.
     *
     * References:
     * [1] https://leetcode.com/problems/subsets/discuss/27288/My-solution-using-bit-manipulation
     *
     * @param nums int[], a set of distinct integers
     * @return List<List<Integer>>, all possible subsets
     */
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length, p = 1 << n;
        List<List<Integer>> subs = new ArrayList<>();
        for (int i = 0; i < p; ++i) {
            subs.add(new LinkedList<>());
        }
        for (int i = 0; i < p; ++i) { // 2 ^ n
            for (int j = 0; j < n; ++j) { // n
                if (((i >> j) & 1) != 0) {
                    subs.get(i).add(nums[j]);
                }
            }
        }
        return subs;
    }
}