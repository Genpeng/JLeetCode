package c01_array.lc0039_combination_sum;

import java.util.*;

/**
 * This is the solution of No. 39 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/combination-sum/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique
 * combinations of candidates where the chosen numbers sum to target. You may return the combinations
 * in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique
 * if the frequency of at least one of the chosen numbers is different.
 *
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations
 * for the given input.
 *
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 *
 * Example 2:
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * Example 3:
 * Input: candidates = [2], target = 1
 * Output: []
 *
 * Example 4:
 * Input: candidates = [1], target = 1
 * Output: [[1]]
 *
 * Example 5:
 * Input: candidates = [1], target = 2
 * Output: [[1,1]]
 *
 * Constraints:
 * - 1 <= candidates.length <= 30
 * - 1 <= candidates[i] <= 200
 * - All elements of candidates are distinct.
 * - 1 <= target <= 500
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: backtracking;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Backtracking with pruning (Addition)
     *
     * @param candidates int[], an array of distinct integers
     * @param target int, the target integer
     * @return List<List<Integer>>, all unique combinations of candidates where the chosen numbers sum to target
     */
    public List<List<Integer>> combinationSumV1(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> combs = new LinkedList<>();
        if (n == 0) {
            return combs;
        }
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        combinationSumV1(candidates, n, target, 0, 0, path, combs);
        return combs;
    }

    private void combinationSumV1(int[] nums, int len, int target, int start, int pathSum, Deque<Integer> path, List<List<Integer>> combs) {
        if (pathSum == target) {
            combs.add(new LinkedList<>(path));
            return;
        }
        for (int i = start; i < len && nums[i] + pathSum <= target; ++i) {
            pathSum += nums[i];
            path.offerLast(nums[i]);
            combinationSumV1(nums, len, target, i, pathSum, path, combs);
            pathSum -= nums[i];
            path.pollLast();
        }
    }

    /**
     * Approach 1: Backtracking with pruning (Subtraction)
     *
     * Result of Submission:
     * Runtime: 2 ms, faster than 98.77% of Java online submissions for Combination Sum.
     * Memory Usage: 39.4 MB, less than 56.12% of Java online submissions for Combination Sum.
     *
     * @param candidates int[], an array of distinct integers
     * @param target int, the target integer
     * @return List<List<Integer>>, all unique combinations of candidates where the chosen numbers sum to target
     */
    public List<List<Integer>> combinationSumV2(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> combs = new LinkedList<>();
        if (n == 0) {
            return combs;
        }
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        combinationSumV2(candidates, n, target, 0, path, combs);
        return combs;
    }

    private void combinationSumV2(int[] nums, int len, int target, int start, Deque<Integer> path, List<List<Integer>> combs) {
        if (target == 0) {
            combs.add(new LinkedList<>(path));
            return;
        }
        for (int i = start; i < len && target - nums[i] >= 0; ++i) {
            path.offerLast(nums[i]);
            combinationSumV2(nums, len, target - nums[i], i, path, combs);
            path.pollLast();
        }
    }
}