package c01_array.lc0078_subsets;

import java.util.*;

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
public class Solution2 {
    /**
     * Approach 2: Backtracking
     * 一个位置一个位置地考虑可以选择哪些元素
     *
     * Complexity Analysis:
     * Time Complexity: O(N * 2^N)
     * Space Complexity: O(N * 2^N)
     *
     * References:
     * [1] https://leetcode.com/articles/subsets/
     * [2] https://leetcode.com/problems/subsets/discuss/27278/C%2B%2B-RecursiveIterativeBit-Manipulation
     * [3] https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
     *
     * @param nums int[], a set of distinct integers
     * @return List<List<Integer>>, all possible subsets
     */
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> subs = new LinkedList<>();
        Deque<Integer> path = new ArrayDeque<>(); // current track in the result tree
        subsets(nums, n, 0, path, subs);
        return subs;
    }

    private void subsets(int[] nums, int len, int pos, Deque<Integer> path, List<List<Integer>> subs) {
        subs.add(new LinkedList<>(path));
        for (int i = pos; i < len; ++i) {
            path.offerLast(nums[i]);
            subsets(nums, len, i + 1, path, subs);
            path.pollLast();
        }
    }

    /**
     * Approach 2: Backtracking
     * 一个元素一个元素地考虑是否使用
     *
     * Complexity Analysis:
     * Time Complexity: O(N * 2^N)
     * Space Complexity: O(N * 2^N)
     *
     * References:
     * [1] https://leetcode.com/articles/subsets/
     * [2] https://leetcode.com/problems/subsets/discuss/27278/C%2B%2B-RecursiveIterativeBit-Manipulation
     * [3] https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
     *
     * @param nums int[], a set of distinct integers
     * @return List<List<Integer>>, all possible subsets
     */
    public List<List<Integer>> subsetsV2(int[] nums) {
        List<List<Integer>> subs = new LinkedList<>();
        Deque<Integer> path = new ArrayDeque<>();
        subsetsV2(nums, 0, path, subs);
        return subs;
    }

    private void subsetsV2(int[] nums, int fromIndex, Deque<Integer> path, List<List<Integer>> subs) {
        if (fromIndex == nums.length) {
            subs.add(new LinkedList<>(path));
            return;
        }
        path.offerLast(nums[fromIndex]);
        subsetsV2(nums, fromIndex+1, path, subs);
        path.pollLast();
        subsetsV2(nums, fromIndex+1, path, subs);
    }

    public static void main(String[] args) {
        Solution2 solu = new Solution2();
        System.out.println(solu.subsetsV2(new int[] {1, 2, 3}));
    }
}