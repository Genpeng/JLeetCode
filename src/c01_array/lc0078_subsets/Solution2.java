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
     * The idea is to enumerate all the possible combinations with the help of backtracking technique.
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
        List<List<Integer>> subs = new LinkedList<>();
        List<Integer> sub = new ArrayList<>(); // current track in the result tree
        subsets(nums, 0, sub, subs);
        return subs;
    }

    /**
     * Find out all the possible subsets start from `fromIndex` in the `nums`.
     *
     * @param nums int[], a set of distinct integers
     * @param fromIndex int, the index to start
     * @param sub List<Integer>, the current track
     * @param subs List<List<Integer>, all the possible combinations
     */
    private void subsets(int[] nums, int fromIndex, List<Integer> sub, List<List<Integer>> subs) {
        subs.add(new ArrayList<>(sub));
        for (int i = fromIndex; i < nums.length; ++i) {
            sub.add(nums[i]);
            subsets(nums, i + 1, sub, subs);
            sub.remove(sub.size() - 1);
        }
    }

    /**
     * Approach 2: Backtracking
     * The idea is to enumerate all the possible combinations with the help of backtracking technique.
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