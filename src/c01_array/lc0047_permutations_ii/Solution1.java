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
public class Solution1 {
    /**
     * Approach 1: Backtracking
     * The basic idea is the same as no. 46 problem, and in order to remove duplicated permutation,
     * we use a hash table to store all the permutations.
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
        int n = nums.length;
        Set<List<Integer>> perms = new HashSet<>();
        permute(nums, n, 0, perms);
        return new LinkedList<>(perms);
    }

    private void permute(int[] nums, int len, int pos, Set<List<Integer>> perms) {
        if (pos == len) {
            List<Integer> perm = new LinkedList<>();
            for (int num : nums) {
                perm.add(num);
            }
            perms.add(perm);
            return;
        }
        for (int i = pos; i < nums.length; ++i) {
            swap(nums, pos, i);
            permute(nums, len, pos+1, perms);
            swap(nums, pos, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        if (i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        Solution1 solu = new Solution1();
        System.out.println(solu.permuteUnique(nums));
    }
}