package c01_array.lc0078_subsets;

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
 * Tags: array;backtracking;bit manipulation;
 *
 * | Date          | #   | Desc   |
 * | ------------- | --- | ------ |
 * | June 25, 2020 | 1   | ×      |
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Cascading
     * The idea is start from empty subset, and then we take a new integer into consideration at each step,
     * and generate new subsets.
     *
     * Complexity Analysis:
     * Time Complexity: O(N * 2^N)
     * Space Complexity: O(N * 2^N)
     *
     * Result of Submission:
     * Runtime: 1 ms, faster than 61.82% of Java online submissions for Subsets.
     * Memory Usage: 39.9 MB, less than 35.55% of Java online submissions for Subsets.
     *
     * @param nums int[], a set of distinct integers
     * @return List<List<Integer>, all possible subsets
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subs = new LinkedList<>();
        subs.add(new LinkedList<>());
        for (int num : nums) {
            List<List<Integer>> newSubs = new LinkedList<>();
            for (List<Integer> sub : subs) {
                List<Integer> newSub = new LinkedList<>(sub);
                newSub.add(num);
                newSubs.add(newSub);
            }
            subs.addAll(newSubs);
        }
        return subs;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution1 solu = new Solution1();
        List<List<Integer>> subsets = solu.subsets(nums);
        System.out.println(subsets);
    }
}