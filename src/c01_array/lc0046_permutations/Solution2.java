package c01_array.lc0046_permutations;

import java.util.*;

/**
 * This is the solution of No. 46 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/permutations/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * ==========================================================================================================
 *
 * Tags: array;backtracking;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Backtracking (improve approach 1)
     * The basic idea is the same as approach 1, the only difference is to use swap operations
     * instead of the auxiliary array.
     *
     * Complexity Analysis:
     * Time Complexity: O(N * N!)
     * Space Complexity: O(N * N!)
     *
     * References:
     * [1] https://leetcode.com/problems/permutations/discuss/18360/C%2B%2B-backtracking-and-nextPermutation
     * [2] https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/
     *
     * Result of Submission:
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Permutations.
     * Memory Usage: 40.1 MB, less than 24.91% of Java online submissions for Permutations.
     *
     * @param nums int[], a collection of distinct integers
     * @return List<List<Integer>>, all possible permutations
     */
    public List<List<Integer>> dfs(int[] nums) {
        List<List<Integer>> perms = new LinkedList<>();
        dfs(nums, 0, perms);
        return perms;
    }

    private void dfs(int[] nums, int depth, List<List<Integer>> perms) {
        if (depth == nums.length) {
            List<Integer> perm = new LinkedList<>();
            for (int num : nums) {
                perm.add(num);
            }
            perms.add(perm);
            return;
        }
        for (int i = depth; i < nums.length; ++i) {
            swap(nums, depth, i);
            dfs(nums, depth + 1, perms);
            swap(nums, depth, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution2 solu = new Solution2();
        List<List<Integer>> perms = solu.dfs(nums);
        System.out.println(perms);
    }
}