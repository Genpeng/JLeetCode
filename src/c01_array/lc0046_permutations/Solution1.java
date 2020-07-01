package c01_array.lc0046_permutations;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
public class Solution1 {
    /**
     * Approach 1: Backtracking
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
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perms = new LinkedList<>();
        permute(nums, 0, perms);
        return perms;
    }

    private void permute(int[] nums, int fromIndex, List<List<Integer>> perms) {
        if (fromIndex == nums.length) {
            List<Integer> perm = new LinkedList<>();
            for (int num : nums) {
                perm.add(num);
            }
            perms.add(perm);
            return;
        }
        for (int i = fromIndex; i < nums.length; ++i) {
            swap(nums, fromIndex, i);
            permute(nums, fromIndex + 1, perms);
            swap(nums, fromIndex, i);
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
        Solution1 solu = new Solution1();
        List<List<Integer>> perms = solu.permute(nums);
        System.out.println(perms);
    }
}