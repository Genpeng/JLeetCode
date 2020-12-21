package c01_array.lc0090_subsets_ii;

import java.util.*;

/**
 * This is the solution of No. 90 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/subsets-ii/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: array;backtracking;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Backtracking
     * The idea is to enumerate all the combinations without containing duplicates
     * with the help of backtracking technique.
     *
     * Complexity Analysis:
     * Time Complexity: O(N * 2^N)
     * Space Complexity: O(N * 2^N)
     *
     * @param nums int[], a collection of integers that might contain duplicates
     * @return List<List<Integer>>, all possible subsets (the power set)
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> subs = new LinkedList<>();
        Deque<Integer> path = new ArrayDeque<>();
        subsetsWithDup(nums, n, 0, path, subs);
        return subs;
    }

    private void subsetsWithDup(int[] nums, int len, int pos, Deque<Integer> path, List<List<Integer>> subs) {
        subs.add(new LinkedList<>(path));
        for (int i = pos; i < len; ++i) {
            if (i > pos && nums[i] == nums[i-1]) {
                continue;
            }
            path.offerLast(nums[i]);
            subsetsWithDup(nums, len, i+1, path, subs);
            path.pollLast();
        }
    }
}