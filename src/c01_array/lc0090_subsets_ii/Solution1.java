package c01_array.lc0090_subsets_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
 * Tags: array;backtracking;
 *
 * | Date          | #   | Desc   |
 * | ------------- | --- | ------ |
 * | June 29, 2020 | 1   | ×      |
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
     * @return List<List<Integer>, all possible subsets (the power set)
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subs = new LinkedList<>();
        List<Integer> sub = new ArrayList<>();
        subsetsWithDup(nums, 0, sub, subs);
        return subs;
    }

    private void subsetsWithDup(int[] nums, int fromIndex, List<Integer> sub, List<List<Integer>> subs) {
        subs.add(new ArrayList<>(sub));
        for (int i = fromIndex; i < nums.length; ++i) {
            if (i > fromIndex && nums[i] == nums[i-1]) {
                continue;
            }
            sub.add(nums[i]);
            subsetsWithDup(nums, i + 1, sub, subs);
            sub.remove(sub.size() - 1);
        }
    }
}