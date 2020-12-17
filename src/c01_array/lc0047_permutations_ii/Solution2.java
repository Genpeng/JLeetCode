package c01_array.lc0047_permutations_ii;

import java.util.*;

/**
 * This is the solution of No. 47 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/permutations-ii/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: array;backtracking;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Backtracking with pruning
     * The basic idea is the same as no. 46 problem, but this time we must to prune the branches
     * that create repeated results.
     *
     * Complexity Analysis:
     * Time Complexity: O(N * N!)
     * Space Complexity: O(N * N!)
     *
     * References:
     * [1] https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
     *
     * @param nums int[], a collection of numbers that might contain duplicates
     * @return List<List<Integer>, all possible unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); // key point #1
        int n = nums.length;
        List<List<Integer>> perms = new LinkedList<>();
        Deque<Integer> path = new ArrayDeque<>(n);
        boolean[] seen = new boolean[n];
        permuteUnique(nums, 0, path, seen, perms);
        return perms;
    }

    private void permuteUnique(int[] nums, int depth, Deque<Integer> path, boolean[] seen, List<List<Integer>> perms) {
        if (depth == nums.length) {
            perms.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (seen[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i-1] && !seen[i-1]) { // key point #2, pruning
                continue;
            }
            path.offerLast(nums[i]);
            seen[i] = true;
            permuteUnique(nums, depth + 1, path, seen, perms);
            seen[i] = false;
            path.pollLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        Solution2 solu = new Solution2();
        System.out.println(solu.permuteUnique(nums));
    }
}