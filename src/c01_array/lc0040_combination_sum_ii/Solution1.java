package c01_array.lc0040_combination_sum_ii;

import java.util.*;

/**
 * This is the solution of No. 40 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/combination-sum-ii/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique
 * combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 *
 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 * Constraints:
 * - 1 <= candidates.length <= 100
 * - 1 <= candidates[i] <= 50
 * - 1 <= target <= 30
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: backtracking
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Backtracking with pruning
     *
     * @param candidates int[], a collection of candidate numbers
     * @param target int, a target number
     * @return List<List<Integer>>, all unique combinations in candidates where the candidate numbers sum to target
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> combs = new LinkedList<>();
        if (n == 0) {
            return combs;
        }
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        combinationSum2(candidates, n, target, 0, path, combs);
        return combs;
    }

    private void combinationSum2(int[] nums, int len, int target, int start, Deque<Integer> path, List<List<Integer>> combs) {
        if (target == 0) {
            combs.add(new LinkedList<>(path));
            return;
        }
        for (int i = start; i < len; ++i) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            if (target - nums[i] < 0) {
                break;
            }
            path.offerLast(nums[i]);
            combinationSum2(nums, len, target - nums[i], i+1, path, combs);
            path.pollLast();
        }
    }
}