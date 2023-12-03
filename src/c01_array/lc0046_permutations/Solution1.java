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
public class Solution1 {
    /**
     * Approach 1: Backtracking
     * The idea is to use backtracking technique to enumerate all the permutations,
     * and by the same time, use a boolean array to mark the numbers that have been
     * enumerated.
     *
     * Complexity Analysis:
     * Time Complexity: O(N * N!)
     * Space Complexity: O(N * N!)
     *
     * References:
     * [1] https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
     *
     * Result of Submission:
     * Runtime: 1 ms, faster than 92.10% of Java online submissions for Permutations.
     * Memory Usage: 39.9 MB, less than 38.19% of Java online submissions for Permutations.
     *
     * @param nums int[], a collection of distinct integers
     * @return List<List<Integer>>, all possible permutations
     */
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> perms = new LinkedList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] seen = new boolean[n];
        permute(nums, n, 0, path, seen, perms);
        return perms;
    }

    private void permute(int[] nums, int L, int depth, Deque<Integer> path, boolean[] seen, List<List<Integer>> perms) {
        if (depth == L) {
            perms.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < L; ++i) {
            if (seen[i]) {
                continue;
            }
            path.offerLast(nums[i]);
            seen[i] = true;
            permute(nums, L, depth + 1, path, seen, perms); // keypoint
            seen[i] = false;
            path.pollLast();
        }
    }

    private List<List<Integer>> ans = new ArrayList<>();

    /**
     * 题意：
     * - 返回数组所有可能的排列（与顺序有关）
     *
     * 解法1：回溯（backtracking）
     * 时间复杂度：O(n! * n)
     * 空间复杂度：O(n! * n)
     *
     * @param nums int[], a collection of distinct integers
     * @return List<List<Integer>>, all possible permutations
     */
    public List<List<Integer>> permuteV2(int[] nums) {
        final int n = nums.length;
        boolean[] seen = new boolean[n];
        int[] path = new int[n];
        dfs(nums, seen, path, 0);
        return ans;
    }

    private void dfs(int[] nums, boolean[] seen, int[] path, int depth) {
        if (depth == nums.length) {
            List<Integer> vals = new ArrayList<>();
            for (int val : path) {
                vals.add(val);
            }
            ans.add(vals);
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (seen[i]) {
                continue;
            }
            seen[i] = true;
            path[depth] = nums[i];
            dfs(nums, seen, path, depth+1);
            seen[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution1 solu = new Solution1();
        List<List<Integer>> perms = solu.permute(nums);
        System.out.println(perms);
    }
}